package ragus.lienty.asynctask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Registering alarm
        AlarmReceiver.setAlarm(this);

        // Initializing api fields
        EditText keyIdField = (EditText)findViewById(R.id.keyId);
        EditText vCodeField = (EditText)findViewById(R.id.vCode);

        EveAPI eveAPI = StorageManager.getStoredApi(this);
        keyIdField.setText(eveAPI.getKeyId(), TextView.BufferType.EDITABLE);
        vCodeField.setText(eveAPI.getvCode(), TextView.BufferType.EDITABLE);

        // Save API button
        final Button button = (Button) findViewById(R.id.saveAPI);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText keyIdField = (EditText)findViewById(R.id.keyId);
                EditText vCodeField = (EditText)findViewById(R.id.vCode);

                String api = keyIdField.getText() + ":" + vCodeField.getText();
                StorageManager.storeAPI(MainActivity.this, api);

                Toast.makeText(getApplicationContext(),"Api stored", Toast.LENGTH_SHORT).show();
            }
        });
    }


}



