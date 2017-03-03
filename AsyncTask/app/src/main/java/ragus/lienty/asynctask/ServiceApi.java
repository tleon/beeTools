package ragus.lienty.asynctask;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

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
        Bundle extras = intent.getExtras();
        if (extras == null){
            Log.d("EXTRA", "Nothing in here");
        }else{
            this.keyId = (String) extras.get("keyId");
            this.vCode = (String) extras.get("vCode");
            iterateNotifications();
        }
    }

    private void sendNotification(String msg, String notifId) {
        mNotificationManager = (NotificationManager)
                this.getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, MainActivity.class), 0);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle(notifId)
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText(msg))
                        .setContentText(msg);

        mBuilder.setContentIntent(contentIntent);
        mNotificationManager.notify(Integer.parseInt(notifId), mBuilder.build());
    }

    protected void iterateNotifications() {

        Account account = new Account(this.keyId, this.vCode);
        List<String> notificationStrings = new ArrayList<String>(); // c'est quoi pk c'est pas utilisé ?

        for(int i = 0 ; i < account.getListChar().size(); i++){ // tab de 3 pilotes

            Characters chararacter = account.getListChar().get(i); // 1 pilote a chaque tour

            for (int j = 0 ; j < chararacter.getListNotif().size(); j++){       //tab de notif pour le pilote en cours

                Notifications notif = chararacter.getListNotif().get(j); // List notifs
                Integer notifType = Integer.parseInt(notif.getNotifType()); //notif type
                String text;

                if(StaticData.notificationTypes.containsKey(notifType)){

                    text = StaticData.notificationTypes.get(notifType);
                    Log.d("Service", "notif type = " + notifType + " text = " + text);
                } else {

                    text = "Unknown notification type : " + notif.getNotifType();
                }
                sendNotification(text, notif.getNotifId());
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("ServiceApi", "Service Destroyed");
    }

}