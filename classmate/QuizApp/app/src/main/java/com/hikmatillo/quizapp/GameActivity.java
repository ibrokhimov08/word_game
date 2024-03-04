package com.hikmatillo.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private TextView time, level, coin, question;

    private RadioGroup radioGroup;

    private Button nextbutton;
    private String javob;
    private final ArrayList<RadioButton> variantGroup = new ArrayList<>();

    private GameController gameController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        gameController = new GameController(LocalData.getAllData());

        loadView();
        loadActoin();
        loadDataToView();

    }

    private void loadActoin() {

        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!gameController.isFinished()) {
                    gameController.checkAnswer(javob);
                    loadDataToView();
                } else {

                    Intent intent = new Intent(GameActivity.this, ResultActivity.class);
                    intent.putExtra(Constant.TRUE_ANSWER , gameController.getTrueAnswer().toString());
                    intent.putExtra(Constant.FALSE_ANSWER, gameController.getFalseAnswer().toString());
                    intent.putExtra(Constant.COIN , gameController.getCoin().toString());
                    startActivity(intent);

                }

            }
        });

        for (int i = 0; i < radioGroup.getChildCount(); i++) {

            RadioButton button = (RadioButton) radioGroup.getChildAt(i);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    javob = button.getText().toString();

                }
            });
        }
    }

    private void loadDataToView() {
        for (int i = 0; i < variantGroup.size(); i++) {
            RadioButton button = variantGroup.get(i);
            button.setChecked(false);
        }
            time.setText("0");
            level.setText(gameController.getLevel() + "/" + gameController.getQuestoinSize());
            coin.setText(String.valueOf(gameController.getCoin()));
            question.setText(gameController.getSavol());

            for (int i = 0; i < variantGroup.size(); i++) {
                RadioButton button = variantGroup.get(i);
                String variant = gameController.getVariants().get(i);
                button.setText(variant);

            }

        }



        private void loadView () {
            time = findViewById(R.id.time);
            level = findViewById(R.id.level);
            nextbutton = findViewById(R.id.nextButton);
            coin = findViewById(R.id.coin);
            question = findViewById(R.id.question);
            radioGroup = findViewById(R.id.radioGroup);

            for (int i = 0; i < radioGroup.getChildCount(); i++) {

                RadioButton child = (RadioButton) radioGroup.getChildAt(i);
                variantGroup.add(child);

            }
        }
    }

