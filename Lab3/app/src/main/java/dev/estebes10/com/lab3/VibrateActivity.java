package dev.estebes10.com.lab3;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class VibrateActivity extends AppCompatActivity {

    private Button btnTestVibrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrate);

        btnTestVibrate = (Button)findViewById(R.id.btnTestVibrate);

        btnTestVibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long pattern[]={0,200,100,300,400}; // or you can just set a duration also in ms
                Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(pattern, -1);
                Toast.makeText(getApplicationContext(), "The phone is vibrating", Toast.LENGTH_LONG).show();
            }
        });
    }
}
