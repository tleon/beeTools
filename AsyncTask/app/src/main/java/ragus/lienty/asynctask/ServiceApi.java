package ragus.lienty.asynctask;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom on 01/03/2017.
 */

public class ServiceApi extends IntentService {

    private NotificationManager mNotificationManager;
    private String keyId;
    private String vCode;

    public ServiceApi(){
        super("ServiceApi");
    }

    @Override
    public void onHandleIntent(Intent intent) {
        task(intent);
        Log.d("ServiceApi", "Service Running");
    }

    public void task(Intent intent){

        iterateNotifications();
    }

    private void sendNotification(String msg, String notifId, String senderName) {
        mNotificationManager = (NotificationManager)
                this.getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, MainActivity.class), 0);

        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle(msg)
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
                        .setContentText("From " + senderName)
                        .setSound(alarmSound);

        mBuilder.setContentIntent(contentIntent);
        mNotificationManager.notify(Integer.parseInt(notifId), mBuilder.build());
    }

    protected void iterateNotifications() {

        Account account = new Account(StorageManager.getStoredApi(this.getApplicationContext()));
        account.retrieveCharacters();

        for(int i = 0 ; i < account.getListChar().size(); i++){

            Character character = account.getListChar().get(i);
            character.retrieveNotifications(account.getApi());

            for (int j = 0 ; j < character.getListNotif().size(); j++){

                EveNotif notification = character.getListNotif().get(j);
                Integer notificationType = Integer.parseInt(notification.getNotifType());
                String text;

                if(StaticData.notificationTypes.containsKey(notificationType)){

                    text = StaticData.notificationTypes.get(notificationType);
                    //Log.d("Service", "notif type = " + notificationType + " text = " + text);
                } else {
                    text = "Unknown notification type : " + notification.getNotifType();
                }

                if (StorageManager.isNotificationNew(this,notification.getNotifId())) {
                    sendNotification(text, notification.getNotifId(), notification.getSenderName());
                    StorageManager.saveNotificationId(this,notification.getNotifId());
                }
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("ServiceApi", "Service Destroyed");
    }

}