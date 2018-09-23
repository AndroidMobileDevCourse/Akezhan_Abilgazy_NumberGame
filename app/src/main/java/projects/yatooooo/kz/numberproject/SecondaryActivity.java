package projects.yatooooo.kz.numberproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondaryActivity extends AppCompatActivity {

    TextView taskTextView = null;
    TextView scoreTextView = null;
    Button lessButton = null;
    Button equalButton = null;
    Button moreButton = null;
    private final int ANSWER_LESS = -1;
    private final int ANSWER_EQUALS = 0;
    private final int ANSWER_BIGGER = 1;
    int max = 99;
    int min = 1;
    int answer;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        init();
        lessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(ANSWER_LESS);
            }
        });
        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(ANSWER_EQUALS);
            }
        });
        moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(ANSWER_BIGGER);
            }
        });
        this.generateTask();
    }

    private void init(){
        taskTextView = findViewById(R.id.taskTextView);
        lessButton = findViewById(R.id.lessButton);
        equalButton = findViewById(R.id.equalButton);
        moreButton = findViewById(R.id.moreButton);
        scoreTextView = findViewById(R.id.scoreTextView);
    }

    private void checkAnswer(int answer) {
        if (answer == this.answer) {
            this.score = this.score + 1;
        } else {
            this.score = this.score - 1;
        }
        this.scoreTextView.setText("Score = " + this.score);
        this.generateTask();
    }

    private void generateTask() {
        int first = this.getRandomNumber();
        int second = this.getRandomNumber();

        if(first==second){
            answer = ANSWER_EQUALS;
        }else if(first>second){
            answer = ANSWER_BIGGER;
        }else{
            answer = ANSWER_LESS;
        }
        this.taskTextView.setText(first + " ? " + second);
    }

    private int getRandomNumber() {
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }
}
