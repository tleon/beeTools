package ragus.lienty.asynctask;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

/**
 * Created by leone on 02/03/2017.
 */

public class AlarmReceiver extends WakefulBroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent i = new Intent(context, ServiceApi.class);
        Log.d("AlarmReceiver", "Broadcast Received");
        context.startService(i);
    }

    public static void setAlarm (Context context) {

        Log.d("AlarmReceiver", "Set Alarm");
        Intent intent = new Intent(context, AlarmReceiver.class);

        final PendingIntent pIntent = PendingIntent.getBroadcast(
            context,
            123456789,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        );

        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setInexactRepeating(
            AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis()+ AlarmManager.INTERVAL_HALF_HOUR / 30,
            AlarmManager.INTERVAL_HALF_HOUR,
            pIntent
        );
    }
}
