package ragus.lienty.asynctask;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Slivo on 03/03/2017.
 */

public class AlarmRegister {

    public static void setAlarm (Context context) {

        Intent intent = new Intent(context,AlarmReceiver.class);
        intent.putExtra("keyId","6042657");
        intent.putExtra("vCode","nt00MxJxf34nZV7WYTZZuwHbD3M3Mh72nzVQrVGBkH3cOTFpH2lsJ4GbnMmBXGeV");

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
