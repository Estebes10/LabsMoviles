package dev.estebes10.com.lab3;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OptionalActivity extends AppCompatActivity {

    private TextView infoTextView;
    private Button btnCustomNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optional);

        infoTextView = (TextView)findViewById(R.id.infoTextView);
        btnCustomNotification = (Button)findViewById(R.id.btnCustomNotification);

        if(getIntent().getExtras() != null){
            for(String key : getIntent().getExtras().keySet()){
                String value = getIntent().getExtras().getString(key);
                infoTextView.append("\n" + key + ": "+value);
            }
        }

        btnCustomNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notificationCustom();
            }
        });
    }

    public void notificationCustom(){
        NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_foreground))
                .setContentTitle("Custom Notification")
                .setContentText("This is an example");

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notificationBuilder.build());
    }
}
