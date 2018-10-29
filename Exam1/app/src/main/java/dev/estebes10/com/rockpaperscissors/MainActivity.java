package dev.estebes10.com.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnRestart, btnRock, btnPaper, btnScissor;
    private String computerChoise, playerChoise;
    private TextView txtResult, txtComputerScore, txtPlayerScore, txtComputer, txtOption;
    private int computerScoreValue = 0, playerScoreValue = 0;
    Random myRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myRandom = new Random();

        //Buttons
        btnRestart = (Button)findViewById(R.id.btnRestart);
        btnRock = (Button)findViewById(R.id.btnRock);
        btnPaper = (Button)findViewById(R.id.btnPaper);
        btnScissor = (Button)findViewById(R.id.btnScissor);

        //text views
        txtResult = (TextView)findViewById(R.id.txtResult);
        txtComputerScore = (TextView)findViewById(R.id.txtComputerScore);
        txtPlayerScore = (TextView)findViewById(R.id.txtPlayerScore);
        txtComputer = (TextView)findViewById(R.id.txtComputer);
        txtOption = (TextView)findViewById(R.id.txtOption);

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtComputer.setText("Waiting option!!..");
                txtOption.setText("Waiting option!!..");
                computerScoreValue = 0;
                playerScoreValue = 0;
                txtComputerScore.setText(String.valueOf(computerScoreValue));
                txtPlayerScore.setText(String.valueOf(playerScoreValue));
                txtResult.setText("Waiting for both players");
                Toast.makeText(getApplicationContext(), "Restarting game", Toast.LENGTH_SHORT).show();
            }
        });

        btnScissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerChoise = "Scissors";
                Log.d("BLACKUSERCHOI", playerChoise);
                computerChoise = makeRandom();
                Log.d("BLACKCOMCHOI", computerChoise);
                txtComputer.setText("Computer chose: "+computerChoise);
                txtOption.setText("You chose: "+playerChoise);
                if(computerChoise == "Rock"){
                    computerScoreValue++;
                    txtResult.setText("Computer wins!!!");
                    txtComputerScore.setText(String.valueOf(computerScoreValue));
                }else if(computerChoise == "Paper"){
                    playerScoreValue++;
                    txtResult.setText("Player 1 wins!!!");
                    txtPlayerScore.setText(String.valueOf(playerScoreValue));
                }else if(computerChoise == "Scissors"){
                    txtResult.setText("No one wins");
                }
            }
        });

        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerChoise = "Paper";
                Log.d("BLACKUSERCHOI", playerChoise);
                computerChoise = makeRandom();
                Log.d("BLACKCOMCHOI", computerChoise);
                txtComputer.setText("Computer chose: "+computerChoise);
                txtOption.setText("You chose: "+playerChoise);
                if(computerChoise == "Rock"){
                    playerScoreValue++;
                    txtResult.setText("Player 1 wins!!!");
                    txtPlayerScore.setText(String.valueOf(playerScoreValue));
                }else if(computerChoise == "Paper"){
                    txtResult.setText("No one wins");
                }else if(computerChoise == "Scissors"){
                    computerScoreValue++;
                    txtResult.setText("Computer wins!!!");
                    txtComputerScore.setText(String.valueOf(computerScoreValue));
                }
            }
        });

        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerChoise = "Rock";
                Log.d("BLACKUSERCHOI", playerChoise);
                computerChoise = makeRandom();
                Log.d("BLACKCOMCHOI", computerChoise);
                txtComputer.setText("Computer chose: "+computerChoise);
                txtOption.setText("You chose: "+playerChoise);
                if(computerChoise == "Rock"){
                    txtResult.setText("No one wins");
                }else if(computerChoise == "Paper"){
                    computerScoreValue++;
                    txtResult.setText("Computer wins!!!");
                    txtComputerScore.setText(String.valueOf(computerScoreValue));
                }else if(computerChoise == "Scissors"){
                    playerScoreValue++;
                    txtResult.setText("Player 1 wins!!!");
                    txtPlayerScore.setText(String.valueOf(playerScoreValue));
                }
            }
        });
    }

    public String makeRandom(){
        String textChoise = "";
        int choise = myRandom.nextInt(3);
        Log.d("BLACKCHOISE", String.valueOf(choise));
        switch (choise){
            case 0:
                textChoise = "Rock";
                break;
            case 1:
                textChoise = "Paper";
                break;
            case 2:
                textChoise = "Scissors";
                break;
        }
        Log.d("BLACKTXTRAND", textChoise);
        return textChoise;
    }
}
