package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.udacity.gradle.builditbigger.backend.jokeApi.model.Joke;
import com.udacity.gradle.builditbigger.jokesteller.JokeActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AsyncResponse {
    private static final String EXTRA_JOKE = "joke_extra";
    //    public static List<Joke> dataFromAsyncTask;
    public EndpointsAsyncTask asyncTask;
    private ArrayList<String> jokeList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //asyncTask.delegate = this;
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        asyncTask = new EndpointsAsyncTask(this, this);
        asyncTask.execute();

    }

    @Override
    public void processFinish(List<Joke> output) {


        jokeList = new ArrayList<>();


        String myJoke = output.get(0).getJoke();
        Log.e("async", myJoke);
        for (Joke outputJoke : output) {
            jokeList.add(outputJoke.getJoke());

        }
        Intent intent = new Intent(this, JokeActivity.class);

        intent.putStringArrayListExtra(EXTRA_JOKE, jokeList);
        startActivity(intent);


    }


}
