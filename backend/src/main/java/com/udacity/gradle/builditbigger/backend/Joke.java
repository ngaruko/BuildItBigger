package com.udacity.gradle.builditbigger.backend;


import org.parceler.Parcel;

/**
 * Created by itl on 13/07/2015.
 */
@Parcel
public class Joke {

    public  Integer id;
    public  String joke;


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


    //make it parcelable




}
