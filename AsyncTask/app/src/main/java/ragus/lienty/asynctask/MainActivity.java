package ragus.lienty.asynctask;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {


    String keyId;
    String vCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MA","test");
        keyId = tmpkeyId;
        vCode = tmpvCode;

        Intent intent = new Intent(this,AlarmReceiver.class);
        intent.putExtra("keyId",keyId);
        intent.putExtra("vCode",vCode);

        Intent serviceIntent = new Intent(this,ServiceApi.class);
        serviceIntent.putExtra("keyId",keyId);
        serviceIntent.putExtra("vCode",vCode);

        startService(serviceIntent);

        final PendingIntent pIntent = PendingIntent
                .getBroadcast(this,123456789, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarm = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarm.setInexactRepeating(
            AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis()+ AlarmManager.INTERVAL_HALF_HOUR / 30,
            AlarmManager.INTERVAL_HALF_HOUR /30,
            pIntent
        );
        //+ (AlarmManager.INTERVAL_HALF_HOUR / 30)




        Button loadBtn = (Button)findViewById(R.id.loadBtn);
        loadBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Stop service
                Intent intent = new Intent(MainActivity.this, AlarmReceiver.class);
                final PendingIntent pIntent = PendingIntent.getBroadcast(getApplicationContext(),0,
                        intent, 0);
                AlarmManager alarm = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
                alarm.cancel(pIntent);
                stopService(new Intent(MainActivity.this, ServiceApi.class));
            }
        });

        Button statusBtn = (Button)findViewById(R.id.statusBtn);
        statusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean test = isMyServiceRunning(getApplicationContext());
                if (test){
                    Toast.makeText(getApplicationContext(),"Service Is Running", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Service Is Stopped", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    protected  void submitApi(){
        EditText keyField = (EditText)findViewById(R.id.keyField);
        EditText vCodeField = (EditText)findViewById(R.id.vCodeField);

        keyId = keyField.getText().toString();
        vCode = vCodeField.getText().toString();

    }





    private boolean isMyServiceRunning(Context mContext) {
        ActivityManager manager = (ActivityManager) mContext
                .getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager
                .getRunningServices(Integer.MAX_VALUE)) {
            if (ServiceApi.class.getName().equals(
            service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}



