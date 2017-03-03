package ragus.lienty.asynctask;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Slivo on 03/03/2017.
 */

public class AlarmRegister {

    public static void setAlarm (Context context) {

        Log.d("AlarmRegister", "Set Alarm");
        Intent intent = new Intent(context,AlarmReceiver.class);
        intent.putExtra("keyId","");
        intent.putExtra("vCode","");

        final PendingIntent pIntent = PendingIntent
                .getBroadcast(context,123456789, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarm = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarm.setInexactRepeating(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis()+ AlarmManager.INTERVAL_HALF_HOUR / 30,
                AlarmManager.INTERVAL_HALF_HOUR /30,
                pIntent
        );
    }
}
