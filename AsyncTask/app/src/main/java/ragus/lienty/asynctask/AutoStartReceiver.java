package ragus.lienty.asynctask;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Slivo on 03/03/2017.
 */

public class AutoStartReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED"))
        {
            Log.d("AutoStartReceiver", "Triggered");
            AlarmReceiver.setAlarm(context);
        }
    }
}
