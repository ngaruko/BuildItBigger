package com.udacity.gradle.builditbigger.backend;




import java.util.List;


public class Joke {

    public  Integer id;
    public  String joke;
    public List<Joke> jokeList;


    public Joke() {
    }

    public Joke(Integer id, String joke) {
        this.id = id;
        this.joke = joke;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }


    public List<Joke> getJokeList() {
        return jokeList;
    }

    public void setJokeList(List<Joke> jokeList) {
        this.jokeList = jokeList;
    }
}
