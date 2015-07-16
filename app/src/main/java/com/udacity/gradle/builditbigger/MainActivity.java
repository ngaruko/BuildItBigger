package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.udacity.gradle.builditbigger.jokesrepo.Jokes;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AsyncResponse {
    private static final String EXTRA_JOKE = "joke_extra";

    public  List<String> jokeList=new ArrayList<>();
    public List<String> jokeLibrary;
    public String returnedString;
    public Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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



        jokeLibrary = new Jokes().giveAllJokes();

        if (jokeLibrary==null){
            Log.e("Nothing", "no data");
            Toast.makeText(this, "NO JOKES WERE FOUND! ", Toast.LENGTH_LONG).show();
        }


       else {

                            //String sjoke;
                            new EndpointsAsyncTask(this, this).execute(new Pair<Context, String>(this, jokeLibrary.get(0)));


        }


    }

    @Override
    public void processFinish(List<String> output) {


        //Make a list here. Start intent from here
//        jokeList = new ArrayList<>();
//        jokeList.add(output);
//        intent = new Intent(this, JokeActivity.class);
//
//        intent.putStringArrayListExtra(EXTRA_JOKE, output);
//        startActivity(intent);


    }


}
