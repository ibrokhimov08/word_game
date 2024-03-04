package com.hikmatillo.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.BreakIterator;

public class ResultActivity extends AppCompatActivity {
    private final TextView coins = new TextView(this);
    private final TextView trueAnswer = new TextView(this);
    private final TextView falseAnswer = new TextView(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String trueAns = getIntent().getStringExtra("TRUE_ANSWER");
        String falseAns = getIntent().getStringExtra("FALSE_ANSWER");
        String coin = getIntent().getStringExtra(Constant.COIN);


        loadView();
        loadDataToView(trueAns, falseAns, coin);

    }



    private void loadDataToView(String tA, String fA, String coin ) {

        trueAnswer.setText(tA);
        falseAnswer.setText(fA);
        coins.setText(coin);
    }

    private void loadView() {
        trueAnswer.findViewById(R.id.trueAnswer);
        falseAnswer.findViewById(R.id.falseAnswer);
        coins.findViewById(R.id.sadsc);
    }
}