package com.example.andrew.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*DECLARATIONS*/
    int redIsActive;
    String winner;
    boolean gameActive;

    // 0 = red, 1 = yellow, 2 = empty
    int[] gameState;

    //Winning Positions
    int [] [] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resetGame();
    }

    //Called by Play Again Button
    public void playAgain(View view){
        //had to make reset method with no view param to use in onCreate for initial setup
        resetGame();
    }

    //animate checker if space not taken and game is active
    public void dropIn(View view){
        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if(gameState[tappedCounter-1] == 2 && gameActive) {
            //set piece position to active player
            gameState[tappedCounter - 1] = redIsActive;

            //animation for active player, swap active player after move
            if (redIsActive == 0) {
                counter.setTranslationY(-1500);
                counter.setImageResource(R.drawable.red);
                counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
                redIsActive = 1;
            } else {
                counter.setTranslationY(-1500);
                counter.setImageResource(R.drawable.yellow);
                counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
                redIsActive = 0;
            }

            checkForWin();

        }

    }//END dropIn


    //compare board with winning positions array to determine if there is a winner
    private void checkForWin(){
        //check for win
        for (int[] winningPosition : winningPositions) {
            if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]]) {
                if (gameState[winningPosition[0]] != 2) {

                    //set winner, if player is now yellow then red move won the game and vice versa
                    if (redIsActive == 1) {
                        winner = "Red";
                    } else {
                        winner = "Yellow";
                    }

                    //stop game and show label and button
                    gameActive = false;
                    TextView winText = findViewById(R.id.winTextView);
                    winText.setText(winner + " wins!");

                    Button playAgainButton = findViewById(R.id.playAgainButton);
                    playAgainButton.setVisibility(View.VISIBLE);
                    winText.setVisibility(View.VISIBLE);
                }
            }
        }
    }




    //reset all game variables
    private void resetGame(){
        Button playAgainButton = findViewById(R.id.playAgainButton);
        playAgainButton.setVisibility(View.INVISIBLE);
        TextView winText = findViewById(R.id.winTextView);
        winText.setVisibility(View.INVISIBLE);
        gameState = new int[] {2, 2, 2, 2, 2, 2, 2, 2, 2};
        redIsActive = 0;
        winner = "";
        gameActive = true;


        clearGameBoard();
    }

    //clear images from ImageViews
    private void clearGameBoard(){
        GridLayout grid = findViewById(R.id.gameBoard);
        for(int i = 0; i < grid.getChildCount(); i++){
            ImageView counter = (ImageView) grid.getChildAt(i);
            counter.setImageDrawable(null);
        }
    }
}
