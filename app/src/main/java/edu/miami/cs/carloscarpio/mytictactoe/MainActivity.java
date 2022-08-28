package edu.miami.cs.carloscarpio.mytictactoe;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

//=================================================================================================
public class MainActivity extends AppCompatActivity {
    //-------------------------------------------------------------------------------------------------
    private RatingBar player1bar;
    private RatingBar player2bar;
    private int max_score = 5;
    private String winner;
    private String maxtime = "5000";

    //-------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1bar = findViewById(R.id.player1_score);
        player1bar.setRating(0);

        player2bar = findViewById(R.id.player2_score);
        player2bar.setRating(0);



    }

    //-------------------------------------------------------------------------------------------------
    public void myClickHandler(View view) {

        Intent nextActivity;
        switch (view.getId()) {
            case R.id.start_button:
                nextActivity = new Intent(this, tictactoe.class);
                nextActivity.putExtra("maxtime",maxtime);
                startSendAndReceive.launch(nextActivity);
                break;
            default:
                break;
        }
    }

    ActivityResultLauncher<Intent> startSendAndReceive = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    Intent resultData;
                    Button playButton = findViewById(R.id.start_button);

                    if (result.getResultCode() == Activity.RESULT_OK) {
                        resultData = result.getData();
                        winner = result.getData().getStringExtra("winner");
                        if (winner.equals("r")) {
                            player1bar.setRating(player1bar.getRating() + 1);
                        }
                        if (winner.equals("g")) {
                            player2bar.setRating(player2bar.getRating() + 1);
                        }
                        if (winner.equals("n")){
                            return;
                        }
                        if (player1bar.getRating() == max_score || player2bar.getRating() == max_score) {
                            playButton.setVisibility(View.INVISIBLE);
                            return;
                        } else {
                            return;
                        }
                    }
                }
            });
    //----------------------------------------------------------------------------------------------

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item){

        tictactoe settime = new tictactoe();

        switch (item.getItemId()) {
            case R.id.reset:
                Button playButton = findViewById(R.id.start_button);
                player1bar.setRating(0);
                player2bar.setRating(0);
                playButton.setVisibility(View.VISIBLE);
                return true;
            case R.id.second_1:
                maxtime = "1000";
                return true;
            case R.id.second_2:
                maxtime = "2000";
                return true;
            case R.id.second_5:
                maxtime = "5000";
                return true;
            case R.id.second_10:
                maxtime = "10000";
                return true;
            default:
                return (super.onOptionsItemSelected(item));
        }
    }
}