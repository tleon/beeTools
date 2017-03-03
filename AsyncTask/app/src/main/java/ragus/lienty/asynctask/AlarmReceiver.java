package ragus.lienty.asynctask;

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
}
