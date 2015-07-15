package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.jokeApi.JokeApi;
import com.udacity.gradle.builditbigger.jokesteller.JokeActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by itl on 13/07/2015.
 */
public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, List<String>> {

    public AsyncResponse delegate = null;
    private static JokeApi myApiService = null;
    public Context context;
    public List<String> jokeList=new ArrayList<>();
    private static final String EXTRA_JOKE = "joke_extra";
    private Intent intent;

    public EndpointsAsyncTask(AsyncResponse delegate, Context context) {
        this.delegate = delegate;
        this.context = context;//.getApplicationContext();
    }


    @Override
    protected List<String> doInBackground(Pair<Context, String>... params) {


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
        context = params[0].first;
        String joke = params[0].second;

        try {
          // jokeList = new ArrayList<>();
            String newJoke = myApiService.grabJoke(joke).execute().getJoke();
            jokeList.add(newJoke);

            return jokeList;

        } catch (IOException e) {

            return null;
        }
    }

    @Override
    protected void onPostExecute(List<String> result) {

        super.onPostExecute(result);
        Toast.makeText(context, result.get(0), Toast.LENGTH_LONG).show();
      //  delegate.processFinish(result);


        intent = new Intent(context, JokeActivity.class);

        intent.putStringArrayListExtra(EXTRA_JOKE, (ArrayList<String>) result);
        context.startActivity(intent);


    }
}