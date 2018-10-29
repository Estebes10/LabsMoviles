package dev.estebes10.com.labs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private TextView messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        messageView = (TextView)findViewById(R.id.txtLogin);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String message = bundle.getString("LOGIN", "No message received");

            messageView.setText(message);
            Toast.makeText(getApplicationContext(), "Welcome" + message, Toast.LENGTH_SHORT).show();
        }
    }
}
