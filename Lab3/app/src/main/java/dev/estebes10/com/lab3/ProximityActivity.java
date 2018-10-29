package dev.estebes10.com.lab3;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ProximityActivity extends AppCompatActivity {

    private Button btnTestProximity;
    ExampleDialog exampleDialog;

    private SensorManager sensorManager;
    private Sensor proximitySensor;
    private SensorEventListener proximitySensorListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);

        btnTestProximity = (Button)findViewById(R.id.btnTestProximity);

        btnTestProximity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 exampleDialog = new ExampleDialog();
                  exampleDialog.show(getSupportFragmentManager(), "EEE");
            }
        });

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if(proximitySensor == null){
            Toast.makeText(this, "Proximity sensor is not available", Toast.LENGTH_LONG).show();
        }

        proximitySensorListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if(sensorEvent.values[0] < proximitySensor.getMaximumRange()) {
                    // Detected something nearby
                    exampleDialog = new ExampleDialog();
                    exampleDialog.show(getSupportFragmentManager(), "EEE");
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };

        // Register it, specifying the polling interval in microseconds
        //sensorManager.registerListener(proximitySensorListener, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(proximitySensorListener, proximitySensor, 2*1000*1000);
    }



    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(proximitySensorListener);
    }
}
