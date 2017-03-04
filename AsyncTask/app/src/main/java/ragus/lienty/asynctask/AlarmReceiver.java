package ragus.lienty.asynctask;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by leone on 02/03/2017.
 */

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        Log.d("AlarmReceiver","Brodcast received");
        Intent i = new Intent(context, ServiceApi.class);
        i.putExtra("keyId",(String) bundle.get("keyId"));
        i.putExtra("vCode",(String) bundle.get("vCode"));
        context.startService(i);

    }

    public static void setAlarm (Context context) {

        Log.d("AlarmReceiver", "Set Alarm");
        Intent intent = new Intent(context,AlarmReceiver.class);
        intent.putExtra("keyId","");
        intent.putExtra("vCode","");

        final PendingIntent pIntent = PendingIntent
                .getBroadcast(context,123456789, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarm = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarm.setInexactRepeating(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis()+ AlarmManager.INTERVAL_HALF_HOUR / 30,
                AlarmManager.INTERVAL_HALF_HOUR,
                pIntent
        );
    }
}
