package dev.estebes10.com.labs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin, btnSettings, btnInvited;
    private TextView txtMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtMain = (TextView)findViewById(R.id.txtMain);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnSettings = (Button)findViewById(R.id.btnSettings);
        btnInvited = (Button)findViewById(R.id.btnInvited);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMain.setText("Login works");
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.putExtra("LOGIN", "Login was clicked");
                startActivity(intent);
            }
        });

        btnInvited.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMain.setText("Invited button was clicked!");
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                intent.putExtra("INVITED", "Invited button was clicked");
                startActivity(intent);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMain.setText("Settings was clicked!");
                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                intent.putExtra("SETTINGS", "Settings button was clicked");
                startActivity(intent);
            }
        });
    }
}
