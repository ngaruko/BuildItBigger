package com.udacity.gradle.builditbigger;

import com.udacity.gradle.builditbigger.backend.jokeApi.model.Joke;

import java.util.List;

/**
 * Created by itl on 13/07/2015.
 */
public interface AsyncResponse {
    void processFinish(List<Joke> output);
}