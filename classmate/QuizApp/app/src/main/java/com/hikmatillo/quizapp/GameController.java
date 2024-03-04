package com.hikmatillo.quizapp;

import java.util.ArrayList;

public class GameController {

    public GameController(ArrayList<SavolModel> data) {

        this.data = data;
    }

    public ArrayList<SavolModel> getData() {
        return data;
    }

    private int coin = 0;
    private int trueAnswer = 0;
    private int falseAnswer = 0;
    private int currentQuestion = 0;

    private final ArrayList<SavolModel> data;

    public Integer getQuestoinSize() {
        return data.size();
    }


    public int getLevel() {
        return currentQuestion + 1;
    }

    public SavolModel getCurrentQuestion() {
        return data.get(currentQuestion);

    }

    public String getSavol() {
        return getCurrentQuestion().getSavol();
    }

    public ArrayList<String> getVariants() {
        return getCurrentQuestion().getVariantlar();
    }

    public String getJavob() {
        return getCurrentQuestion().getJavob();

    }

    public void checkAnswer(String userAnswer) {

        if (userAnswer.equals(getJavob())) {
            coin += 5;
            trueAnswer++;
        } else {
            falseAnswer++;

        }
        currentQuestion++;
    }

    public boolean isFinished() {
        return data.size() == currentQuestion + 1;
    }

    public Integer getTrueAnswer() {
        return trueAnswer;
    }

    public Integer getFalseAnswer() {
        return falseAnswer;
    }

    public Integer getCoin() {
        return coin;
    }
}


