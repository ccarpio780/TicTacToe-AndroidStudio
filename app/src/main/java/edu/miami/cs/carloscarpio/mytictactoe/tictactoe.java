//=================================================================================================
package edu.miami.cs.carloscarpio.mytictactoe;
//--------------------------------------------------------------------------------------------------
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class tictactoe extends AppCompatActivity {
//--------------------------------------------------------------------------------------------------
    private int barClickTime;
    private int maxBarTime;
    private ProgressBar myProgressBar;
    private boolean redTurn;
    private int turnController;
    private double turnSetter = 0.5;
    private boolean redWin;
    private boolean greenWin;
    private int[][] table = new int[3][3];
    private String maxtime;

//--------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);

        Random random = new Random();
        double randNum = random.nextDouble();

        if (randNum > turnSetter) {
            turnSetter += 0.1;
            redTurn = false;
        }
        else {
            turnSetter -= 0.1;
            redTurn = true;
        }
        turnSetter += 0.1;

        Intent result = getIntent();
        maxtime = result.getStringExtra("maxtime");
        maxBarTime = Integer.parseInt(maxtime);
        System.out.println(maxBarTime);

        myProgressBar = findViewById(R.id.time_left);
        myProgressBar.setProgress(maxBarTime);
        myProgressBar.setMax(maxBarTime);
        barClickTime = getResources().getInteger(R.integer.bar_click_time);
        //maxBarTime = getResources().getInteger(R.integer.bar_time);
        myProgresser.run();
    }

    public void tictactoetable(int row, int column, int colorNum){
        //colorNum 1 = red, 2 = green
        //  [0][0]  [0][1]  [0][2]
        //  [1][0]  [1][1]  [1][2]
        //  [2][0]  [2][1]  [2][2]
        //  button1  button2  button3
        //  button4  button5  button6
        //  button7  button8  button9


        table[row][column] = colorNum;

        //check for horizontal win
        if (table[0][0]==1 && table[0][1]==1 && table[0][2]==1){
            redWin = true;
        }
        if (table[0][0]==2 && table[0][1]==2 && table[0][2]==2){
            greenWin = true;
        }
        if (table[1][0]==1 && table[1][1]==1 && table[1][2]==1){
            redWin = true;
        }
        if (table[1][0]==2 && table[1][1]==2 && table[1][2]==2){
            greenWin = true;
        }
        if (table[2][0]==1 && table[2][1]==1 && table[2][2]==1){
            redWin = true;
        }
        if (table[2][0]==2 && table[2][1]==2 && table[2][2]==2){
            greenWin = true;
        }

        //check for vertical win
        if (table[0][0]==1 && table[1][0]==1 && table[2][0]==1){
            redWin = true;
        }
        if (table[0][0]==2 && table[1][0]==2 && table[2][0]==2){
            greenWin = true;
        }
        if (table[0][1]==1 && table[1][1]==1 && table[2][1]==1){
            redWin = true;
        }
        if (table[0][1]==2 && table[1][1]==2 && table[2][1]==2){
            greenWin = true;
        }
        if (table[0][2]==1 && table[1][2]==1 && table[2][2]==1){
            redWin = true;
        }
        if (table[0][2]==2 && table[1][2]==2 && table[2][2]==2){
            greenWin = true;
        }

        //check for diagonal win
        if (table[0][0]==1 && table[1][1]==1 && table[2][2]==1){
            redWin = true;
        }
        if (table[0][0]==2 && table[1][1]==2 && table[2][2]==2){
            greenWin = true;
        }
        if (table[2][0]==1 && table[1][1]==1 && table[0][2]==1){
            redWin = true;
        }
        if (table[2][0]==2 && table[1][1]==2 && table[0][2]==2){
            greenWin = true;
        }

    }
//--------------------------------------------------------------------------------------------------
    public void myClickListener(View view) {

        //even numbers will be red player
        //odd numbers will be green players
        Button button;


        switch(view.getId()){
            case R.id.button1:
                button = findViewById(R.id.button1);
                if (redTurn){
                    //make button red
                    button.setBackgroundColor(Color.RED);
                    tictactoetable(0,0,1);
                }
                else if (!redTurn){
                    //MAKE BUTTON GREEN
                    button.setBackgroundColor(Color.GREEN);
                    tictactoetable(0,0,2);
                }
                button.setClickable(false);
                myProgressBar.setProgress(maxBarTime);
                redTurn = !redTurn;
                turnController+=1;
                break;
            case R.id.button2:
                button = findViewById(R.id.button2);
                if (redTurn){
                    //make button red
                    button.setBackgroundColor(Color.RED);
                    tictactoetable(0,1,1);
                }
                else if (!redTurn){
                    //MAKE BUTTON GREEN
                    button.setBackgroundColor(Color.GREEN);
                    tictactoetable(0,1,2);
                }
                button.setClickable(false);
                myProgressBar.setProgress(maxBarTime);
                redTurn = !redTurn;
                turnController+=1;
                break;
            case R.id.button3:
                button = findViewById(R.id.button3);
                if (redTurn){
                    //make button red
                    button.setBackgroundColor(Color.RED);
                    tictactoetable(0,2,1);
                }
                else if (!redTurn){
                    //MAKE BUTTON GREEN
                    button.setBackgroundColor(Color.GREEN);
                    tictactoetable(0,2,2);
                }
                button.setClickable(false);
                myProgressBar.setProgress(maxBarTime);
                redTurn = !redTurn;
                turnController+=1;
                break;
            case R.id.button4:
                button = findViewById(R.id.button4);
                if (redTurn){
                    //make button red
                    button.setBackgroundColor(Color.RED);
                    tictactoetable(1,0,1);
                }
                else if (!redTurn){
                    //MAKE BUTTON GREEN
                    button.setBackgroundColor(Color.GREEN);
                    tictactoetable(1,0,2);
                }
                button.setClickable(false);
                myProgressBar.setProgress(maxBarTime);
                redTurn = !redTurn;
                turnController+=1;
                break;
            case R.id.button5:
                button = findViewById(R.id.button5);
                if (redTurn){
                    //make button red
                    button.setBackgroundColor(Color.RED);
                    tictactoetable(1,1,1);
                }
                else if (!redTurn){
                    //MAKE BUTTON GREEN
                    button.setBackgroundColor(Color.GREEN);
                    tictactoetable(1,1,2);

                }
                button.setClickable(false);
                myProgressBar.setProgress(maxBarTime);
                redTurn = !redTurn;
                turnController+=1;
                break;
            case R.id.button6:
                button = findViewById(R.id.button6);
                if (redTurn){
                    //make button red
                    button.setBackgroundColor(Color.RED);
                    tictactoetable(1,2,1);
                }
                else if (!redTurn){
                    //MAKE BUTTON GREEN
                    button.setBackgroundColor(Color.GREEN);
                    tictactoetable(1,2,2);
                }
                button.setClickable(false);
                myProgressBar.setProgress(maxBarTime);
                redTurn = !redTurn;
                turnController+=1;
                break;
            case R.id.button7:
                button = findViewById(R.id.button7);
                if (redTurn){
                    //make button red
                    button.setBackgroundColor(Color.RED);
                    tictactoetable(2,0,1);
                }
                else if (!redTurn){
                    //MAKE BUTTON GREEN
                    button.setBackgroundColor(Color.GREEN);
                    tictactoetable(2,0,2);
                }
                button.setClickable(false);
                myProgressBar.setProgress(maxBarTime);
                redTurn = !redTurn;
                turnController+=1;
                break;
            case R.id.button8:
                button = findViewById(R.id.button8);
                if (redTurn){
                    //make button red
                    button.setBackgroundColor(Color.RED);
                    tictactoetable(2,1,1);
                }
                else if (!redTurn){
                    //MAKE BUTTON GREEN
                    button.setBackgroundColor(Color.GREEN);
                    tictactoetable(2,1,2);
                }
                button.setClickable(false);
                myProgressBar.setProgress(maxBarTime);
                redTurn = !redTurn;
                turnController+=1;
                break;
            case R.id.button9:
                button = findViewById(R.id.button9);
                if (redTurn){
                    //make button red
                    button.setBackgroundColor(Color.RED);
                    tictactoetable(2,2,1);
                }
                else if (!redTurn){
                    //MAKE BUTTON GREEN
                    button.setBackgroundColor(Color.GREEN);
                    tictactoetable(2,2,2);
                }
                button.setClickable(false);
                myProgressBar.setProgress(maxBarTime);
                redTurn = !redTurn;
                turnController+=1;
                break;
        }

    }

    //----------------------------------------------------------------------------------------------

    private final Runnable myProgresser = new Runnable() {
        private Handler myHandler = new Handler();
        public void run() {

            Intent returnIntent;

            myProgressBar.setProgress(myProgressBar.getProgress()-barClickTime);

            Button red_button = findViewById(R.id.red_button);
            Button green_button = findViewById(R.id.green_button);

            TextView playerNumber = findViewById(R.id.current_player);

            if (redWin){
                returnIntent = new Intent(getApplicationContext(), MainActivity.class);
                returnIntent.putExtra("winner","r");
                setResult(RESULT_OK,returnIntent);
                finish();
                return;
            }

            if (greenWin){
                returnIntent = new Intent(getApplicationContext(), MainActivity.class);
                returnIntent.putExtra("winner","g");
                setResult(RESULT_OK,returnIntent);
                finish();
                return;
            }

            if (redTurn) {
                red_button.setVisibility(View.VISIBLE);
                green_button.setVisibility(View.INVISIBLE);
                playerNumber.setText(R.string.player1_text);
            }
            else {
                red_button.setVisibility(View.INVISIBLE);
                green_button.setVisibility(View.VISIBLE);
                playerNumber.setText(R.string.player2_text);
            }

            if (myProgressBar.getProgress() <= 0) {
                myProgressBar.setProgress(maxBarTime);
                redTurn = !redTurn;
                /*returnIntent = new Intent(getApplicationContext(), MainActivity.class);
                setResult(RESULT_OK,returnIntent);
                finish();*/
            }

            if (!myHandler.postDelayed(myProgresser,barClickTime)) {
                Log.e("ERROR","Cannot postDelayed");
            }
            if (turnController == 9) {
                returnIntent = new Intent(getApplicationContext(), MainActivity.class);
                returnIntent.putExtra("winner","n");
                setResult(RESULT_OK,returnIntent);
                finish();
                return;
            }
        }
    };
}