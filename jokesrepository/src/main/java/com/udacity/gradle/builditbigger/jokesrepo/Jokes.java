package com.udacity.gradle.builditbigger.jokesrepo;




import java.util.ArrayList;
import java.util.List;

public class Jokes {


    public List<String> jokeList = new ArrayList<>();


    //Gotten here:http://thoughtcatalog.com/christopher-hudspeth/2013/09/50-terrible-quick-jokes-thatll-get-you-a-laugh-on-demand/


    String[] testJokes = new String[]{"It’s hard to explain puns to kleptomaniacs because they always take things literally.",
            "A farmer in the field with his cows counted 196 of them, but when he rounded them up he had 200.",
            "What is Bruce Lee’s favorite drink? Wataaaaah!",
            "What does a nosey pepper do? Get jalapeño business.",
            "he dyslexic devil worshipper sold his soul to Santa.",
            "You kill vegetarian vampires with a steak to the heart.",
            "There was a prison break and I saw a midget climb up the fence. As he jumped down her sneered at me and I thought, well that’s a little condescending.",
            "If you want to catch a squirrel just climb a tree and act like a nut.",
            "I used to think the brain was the most important organ. Then I thought, look what’s telling me that.",
            "The midget fortune teller who kills his customers is a small medium at large.",
            "So this guy with a premature ejaculation problem comes out of nowhere.",
            "A magician was walking down the street and turned into a grocery store.",
            "A blind man walks into a bar. And a table. And a chair.",
            "Why don’t you ever see hippopotamus hiding in trees? Because they’re really good at it."};

    public List<String> giveAllJokes() {

        if (testJokes!=null && testJokes.length>0)

         {
            for (int i = 0; i < testJokes.length; i++){

               jokeList.add(testJokes[i]);

            }
            return jokeList;
        } else {

            return null;
        }
    }



}
