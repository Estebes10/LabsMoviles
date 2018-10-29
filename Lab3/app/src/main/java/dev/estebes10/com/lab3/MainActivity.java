package dev.estebes10.com.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnVibrate, btnProximity, btnOptional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVibrate = (Button)findViewById(R.id.btnVibrate);
        btnProximity = (Button)findViewById(R.id.btnProximity);
        btnOptional = (Button)findViewById(R.id.btnOptional);

        btnVibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, VibrateActivity.class);
                startActivity(intent1);
            }
        });

        btnProximity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, ProximityActivity.class);
                startActivity(intent2);
            }
        });

        btnOptional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, OptionalActivity.class);
                startActivity(intent3);
            }
        });
    }

}
