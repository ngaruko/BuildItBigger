package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.jokeApi.JokeApi;
import com.udacity.gradle.builditbigger.backend.jokeApi.model.Joke;
import com.udacity.gradle.builditbigger.jokesrepo.Jokes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by itl on 13/07/2015.
 */
class EndpointsAsyncTask extends AsyncTask<Context, Void, List<Joke>> {

    public AsyncResponse delegate = null;
    private static JokeApi myApiService = null;
    private Context context;


    public List<Joke> jokes = new ArrayList<Joke>();

    public EndpointsAsyncTask(AsyncResponse delegate, Context context) {
        this.delegate = delegate;
        this.context = context;
    }


    @Override
    protected List<Joke> doInBackground(Context... params) {
        if (myApiService == null) {  // Only do this once
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.3.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }



        try {

            if(jokes!=null || !jokes.isEmpty()) jokes.clear();
            new Jokes().giveAllJokes();
            jokes = myApiService.getAllJokes().execute().getItems();
            if (jokes != null) Log.e("JOKES FROM LIB", jokes.toString());
            return jokes;

        } catch (IOException e) {

            return null;
        }
    }

    @Override
    protected void onPostExecute(List<Joke> result) {


        if (!result.isEmpty())
            Log.e("Joke", result.get(0).getJoke());

      //  Toast.makeText(context, result.get(0).getJoke(), Toast.LENGTH_LONG).show();
        delegate.processFinish(result);


    }
}