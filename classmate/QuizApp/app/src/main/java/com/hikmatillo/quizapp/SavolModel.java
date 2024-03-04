package com.hikmatillo.quizapp;

import java.util.ArrayList;

import kotlin.reflect.KProperty;

public class SavolModel {

    private int id;
    private String savol;
    private String javob;
    private ArrayList<String> variantlar;

    @Override
    public String toString() {
        return "SavolModel{" +
                "id=" + id +
                ", savol='" + savol + '\'' +
                ", javob='" + javob + '\'' +
                ", variantlar=" + variantlar +
                '}';
    }

    public SavolModel(int id, String savol, String javob, ArrayList<String> variantlar) {

        this.id = id;
        this.savol = savol;
        this.javob = javob;
        this.variantlar = variantlar;

    }

    public int getId() {
        return id;
    }

    public String getSavol() {
        return savol;
    }

    public String getJavob() {
        return javob;
    }

    public ArrayList<String> getVariantlar() {
        return variantlar;
    }
}
