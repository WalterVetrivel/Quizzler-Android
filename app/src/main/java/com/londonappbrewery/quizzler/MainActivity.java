package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    // TODO: Declare member variables here:
    private Button mTrueButton;
    private Button mFalseButton;
    private TextView mScore;
    private TextView mQuestion;
    private int mCurrentQuestion;
    private int mCurrentScore;
    private ProgressBar mProgressBar;

    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13, true)
    };

    // TODO: Declare constants here
    private final int NUMBER_OF_QUESTIONS = mQuestionBank.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mScore = (TextView) findViewById(R.id.score);
        mQuestion = (TextView) findViewById(R.id.question_text_view);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);

        mCurrentQuestion = 0;
        mCurrentScore = 0;

        mProgressBar.setMax(NUMBER_OF_QUESTIONS);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentQuestion < NUMBER_OF_QUESTIONS) {
                    checkAnswer(true);
                    nextQuestion();
                    updateScore();
                }
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentQuestion < NUMBER_OF_QUESTIONS) {
                    String toastText;
                    checkAnswer(false);
                    nextQuestion();
                    updateScore();
                }
            }
        });
    }

    public void checkAnswer(boolean answer) {
        String toastText;
        if (mQuestionBank[mCurrentQuestion].isAnswer() == answer) {
            toastText = "Correct!";
            mCurrentScore++;
        } else {
            toastText = "Wrong";
        }
        Toast toast = Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void nextQuestion() {
        mCurrentQuestion++;
        if(mCurrentQuestion < NUMBER_OF_QUESTIONS) {
            mQuestion.setText(mQuestionBank[mCurrentQuestion].getQuestionNumber());
        }
        if(mCurrentQuestion <= NUMBER_OF_QUESTIONS) {
            mProgressBar.setProgress(mCurrentQuestion);
        }
    }

    public void updateScore() {
        String score = mCurrentScore + " / 13";
        mScore.setText(score);
    }
}
