package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokeApi",
        version = "v1",
        resource = "joke",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class JokeEndpoint {

    private static final Logger logger = Logger.getLogger(JokeEndpoint.class.getName());
    public static List<Joke> jokeList;// = new ArrayList<>();


   // public List<String> jokes;


    /**
     * This method gets the <code>Joke</code> object associated with the specified <code>id</code>.
     *
     * @param id The id of the object to be returned.
     * @return The <code>Joke</code> associated with <code>id</code>.
     */
    @ApiMethod(name = "getJoke")
    public Joke getJoke(@Named("id") Long id) {
        // TODO: Implement this function
        logger.info("Calling getJoke method");
        return null;
    }

    @ApiMethod(name = "grabJoke")
    public Joke grabJoke(@Named("joke") String joke) {
        Joke response = new Joke();
        response.setJoke(joke);
        return response;
    }


    /**
     * This inserts a new <code>Joke</code> object.
     *
     * @param joke The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "insertJoke")
    public Joke insertJoke(Joke joke) {
        jokeList.add(joke);
        logger.info("Calling insertJoke method");
        return joke;
    }

    @ApiMethod(name="getAllJokes")
      public List<Joke> getAllJokes() {
//if (!jokes.isEmpty()) jokes.clear();
//        jokes=new Jokes().giveAllJokes();
//        for (String s:jokes){
//
//         Joke   joke=new Joke();
//            joke.setJoke(s);
//            joke.setId(jokes.indexOf(s));
//            jokeList.add(joke);
//
//        }

        return jokeList;
    }


}