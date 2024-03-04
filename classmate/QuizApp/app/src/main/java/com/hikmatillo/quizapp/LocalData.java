package com.hikmatillo.quizapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class LocalData {

    private static final ArrayList<SavolModel> data = new ArrayList<>();

    public static ArrayList<SavolModel> getAllData() {

        data.clear();

        //Savol1
        ArrayList<String> variant1 = new ArrayList<>();
        variant1.add("SOS");
        variant1.add("Take a Bow");
        variant1.add("Rude Boy");
        variant1.add("Umbrella");
        Collections.shuffle(variant1);
        SavolModel savol1 = new SavolModel(0, "For which Nominated work Rihanna won MTV Video MusicvAward in 2007 ?", "Umbrella", variant1);


        //Savol2
        ArrayList<String> variant2 = new ArrayList<>();
        variant2.add("What's My Name?");
        variant2.add("S&M");
        variant2.add("Fading");
        variant2.add("Man Down");
        Collections.shuffle(variant2);
        SavolModel savol2 = new SavolModel(1, "Which song of Rihannna contauns this lyric Sticks and stones may break my bones but chains and whips excite me ?", "S&M", variant2);


        //Savol3
        ArrayList<String> variant3 = new ArrayList<>();
        variant3.add("Talk That Talk");
        variant3.add("Music of the Sun");
        variant3.add("This is the End");
        variant3.add("Good Girl Gone Bad");
        Collections.shuffle(variant3);
        SavolModel savol3 = new SavolModel(2, "Which of these is not Rihanna's album", "This is the End", variant3);

        //Savol4
        ArrayList<String> variant4 = new ArrayList<>();
        variant4.add("Rebelle");
        variant4.add("Reb'l Fleur");
        variant4.add("Nude");
        variant4.add("GirlFriend");
        Collections.shuffle(variant4);
        SavolModel savol4 = new SavolModel(3, "What was the first fragrance for womon endorsed by Rihanna", "Reb'l Fleur", variant4);

        //Savol5
        ArrayList<String> variant5 = new ArrayList<>();
        variant5.add("Rizzoli");
        variant5.add("Kalmbach");
        variant5.add("SR Books");
        variant5.add("Urban Books");
        Collections.shuffle(variant5);
        SavolModel savol5 = new SavolModel(4, "Rihanna has released book Rihanna under which publicaiton", "Rizzoli", variant5);

        //Savol6
        ArrayList<String> variant6 = new ArrayList<>();
        variant6.add("Rush");
        variant6.add("Willing to Wait");
        variant6.add("Hypnotized");
        variant6.add("Pon De Replay");
        Collections.shuffle(variant6);
        SavolModel savol6 = new SavolModel(5, "Which song of Rihanna contains this lyric Run, run, run, run everybody move run ?", "Pon De Replay", variant6);

        //Savol7
        ArrayList<String> variant7 = new ArrayList<>();
        variant7.add("Music of the Sun");
        variant7.add("Unapologetic");
        variant7.add("Talk That Talk");
        variant7.add(" Rated R");
        Collections.shuffle(variant7);
        SavolModel savol7 = new SavolModel(6, "Rihanna's song name What Now was from which album ?", "Unapologetic", variant7);

        //Savol8
        ArrayList<String> variant8 = new ArrayList<>();
        variant8.add("February 15, 2012");
        variant8.add("January 25, 2011");
        variant8.add("July 26, 2012");
        variant8.add("November 23, 2012");
        Collections.shuffle(variant8);
        SavolModel savol8 = new SavolModel(7, "When was the fragrance Nude was released?", "November 23, 2012", variant8);

        //Savol9
        ArrayList<String> variant9 = new ArrayList<>();
        variant9.add("five");
        variant9.add("nine");
        variant9.add("seven");
        variant9.add("six");
        Collections.shuffle(variant9);
        SavolModel savol9 = new SavolModel(8, "How many Grammy awards Rihanna won up til 2012?", "seven", variant9);

        //Savol10
        ArrayList<String> variant10 = new ArrayList<>();
        variant10.add("sam");
        variant10.add("Marley");
        variant10.add("Hamster");
        variant10.add("Roggy");
        Collections.shuffle(variant10);
        SavolModel savol10 = new SavolModel(9, "Whate is Rihanna's dog's name?", "Marley", variant10);


        data.add(savol1);
        data.add(savol2);
        data.add(savol3);
        data.add(savol4);
        data.add(savol5);
        data.add(savol6);
        data.add(savol7);
        data.add(savol8);
        data.add(savol9);
        data.add(savol10);

        Collections.shuffle(data);

        return data;

    }
}
