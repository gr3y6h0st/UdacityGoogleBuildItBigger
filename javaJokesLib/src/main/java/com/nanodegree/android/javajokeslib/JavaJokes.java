package com.nanodegree.android.javajokeslib;

import java.util.Random;

public class JavaJokes {
    private static String magic_trick_joke = "Who wants to see a magic trick?!";
    private static String cat_joke = "Wanna hear a bad cat joke?...Just Kitten.";
    private static String knock_knock_heisenberg = "Knock, Knock! Who's There?...It's me, Heisenberg.";

    public static String[] jokesArray = {
            magic_trick_joke,
            cat_joke,
            knock_knock_heisenberg
    };
    public static String getJoke() {
        //TODO: provide an array of jokes. Randomize selection.
        int numOfJokes = jokesArray.length;

        //Randomize which joke gets pulled by array index.
        Random randomizer = new Random();
        int index = randomizer.nextInt(numOfJokes);

        return jokesArray[index];
    }
}
