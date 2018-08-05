package com.example.andrew.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /* CONSTANT GAME PARAMS */
    final int MAX_BOUND = 6, NUM_BUTTONS = 4, SCORE_MULTIPLIER = 2000;
    final long TIMER_LENGTH = 30000, TIMER_INTERVAL = 1000;

    /* GAME UTILITY DECLARATIONS */
    Random random;
    int answer = 999, correctAnswers = 0, numQuestions = 0;
    boolean isCorrect = false, gameIsActive = false;
    CountDownTimer timer;

    /* VIEWS */
    Button goButton, playAgainButton;
    GridLayout answerButtonGridLayout;
    TextView scoreTextView, timerTextView, mathProblemTextView, resultsTextView, answeredTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random = new Random();
        goButton = findViewById(R.id.goButton);
        playAgainButton = findViewById(R.id.playAgainButton);
        answerButtonGridLayout = findViewById(R.id.answerButtonGridLayout);
        scoreTextView = findViewById(R.id.scoreTextView);
        timerTextView = findViewById(R.id.timerTextView);
        mathProblemTextView = findViewById(R.id.mathProblemTextView);
        resultsTextView = findViewById(R.id.resultsTextView);
        answeredTextView = findViewById(R.id.answerTextView);

        timer = new CountDownTimer(TIMER_LENGTH, TIMER_INTERVAL) {
            @Override
            public void onTick(long l) {
                updateTimerText(l);
            }

            @Override
            public void onFinish() {
                stop();
            }
        };
    }

    public void start(View view) {
        goButton.setVisibility(View.INVISIBLE);
        playAgainButton.setVisibility(View.INVISIBLE);
        resultsTextView.setVisibility(View.INVISIBLE);

        answerButtonGridLayout.setVisibility(View.VISIBLE);
        scoreTextView.setVisibility(View.VISIBLE);
        timerTextView.setVisibility(View.VISIBLE);
        mathProblemTextView.setVisibility(View.VISIBLE);

        answer = 999; correctAnswers = 0; numQuestions = 0;
        isCorrect = false; gameIsActive = false;


        if(timer != null){
            gameIsActive = true;
            getNewQuestion();
            timer.start();
        }
    }

    public void stop(){
        playAgainButton.setVisibility(View.VISIBLE);

        answerButtonGridLayout.setVisibility(View.INVISIBLE);
        scoreTextView.setVisibility(View.INVISIBLE);
        timerTextView.setVisibility(View.INVISIBLE);
        mathProblemTextView.setVisibility(View.INVISIBLE);
        answeredTextView.setVisibility(View.INVISIBLE);

        showEndGameResults(scoreTextView.getText().toString());
        if(timer != null){
            gameIsActive = false;
            timer.cancel();
            scoreTextView.setText(R.string.initial_score);
        }
    }

    public void selectAnswer(View view) {

        if(gameIsActive) {
            Button buttonSelected = (Button) view;
            int selectedAnswer = Integer.parseInt(buttonSelected.getText().toString());

            isCorrect = (selectedAnswer == answer) ? true : false;
            processAnswer();
        }
    }

    private void getNewQuestion(){
        if(gameIsActive) {
            getRandomSum(MAX_BOUND);
            setAnswerButtons();
        }
    }

    private void setAnswerButtons(){
        int answerButtonIndex = random.nextInt(NUM_BUTTONS);
        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add((Button) findViewById(R.id.answerButton0));
        buttons.add((Button) findViewById(R.id.answerButton1));
        buttons.add((Button) findViewById(R.id.answerButton2));
        buttons.add((Button) findViewById(R.id.answerButton3));

        ArrayList<Integer> answers = new ArrayList<>();


        for(int i = 0; i < NUM_BUTTONS; i++){
            if(answerButtonIndex == i){
                answers.add(answer);
            } else {
                int wrongAnswer = random.nextInt(answer * 2);
                while(wrongAnswer == answer || answers.contains(wrongAnswer)){
                    wrongAnswer = random.nextInt(answer * 2);
                }

                answers.add(wrongAnswer);
            }

            buttons.get(i).setText(Integer.toString(answers.get(i)));
        }
    }

    private void getRandomSum(int bound) {
        int a = random.nextInt(bound);
        int b = random.nextInt(bound);
        answer = a + b;

        mathProblemTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));
        setAnswerButtons();

    }

    private void processAnswer(){
        if(isCorrect) {
            correctAnswers++;
        }

        numQuestions++;
        updateAnsweredTextView();
        updateScoreTextView();
        getRandomSum(MAX_BOUND);
    }

    private void updateAnsweredTextView() {
        answeredTextView.setVisibility(View.VISIBLE);
        if(isCorrect)
            answeredTextView.setText("Correct!");
        else
            answeredTextView.setText("Wrong :(");

    }

    private void updateScoreTextView() {
        TextView scoreTextView = findViewById(R.id.scoreTextView);
        scoreTextView.setText(Integer.toString(correctAnswers) + " / " + Integer.toString(numQuestions));

    }

    private void updateTimerText(long remaining){
        long seconds = remaining / 1000;

        TextView timerTextView = findViewById(R.id.timerTextView);
        timerTextView.setText(Long.toString(seconds) + "s");
    }

    private void showEndGameResults(String scoreText){
        double correct = (double) correctAnswers, questions = (double) numQuestions;
        double ratio = correct / questions;
        double score = (double) (correctAnswers * SCORE_MULTIPLIER);
        score *= ratio;
        resultsTextView.setText("Correct: " + scoreText + " Score: " +  (int) score);

        resultsTextView.setVisibility(View.VISIBLE);
    }


}
