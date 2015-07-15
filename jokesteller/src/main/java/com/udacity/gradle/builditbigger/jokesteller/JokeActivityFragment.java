package com.udacity.gradle.builditbigger.jokesteller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class JokeActivityFragment extends Fragment {

    private static final String STATE_JOKES = "state_jokes";
    private JokeAdapter jokeAdapter;


    ArrayList<String> listJokes;


    private RecyclerView jokeView;


    public JokeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_joke, container, false);


        jokeView = (RecyclerView) rootView.findViewById(R.id.list_jokes_view);
        jokeView.setLayoutManager(new LinearLayoutManager(getActivity()));


        jokeAdapter = new JokeAdapter(getActivity());
        jokeView.setAdapter(jokeAdapter);


        //Restore data on rotation for example
        if (savedInstanceState != null) {
            listJokes = savedInstanceState.getStringArrayList(STATE_JOKES);



        } else {

            Intent intent = getActivity().getIntent();
            listJokes = intent.getStringArrayListExtra("joke_extra");
        }

        //update your Adapter to containg the retrieved jokes
        jokeAdapter.setJokeList(listJokes);

        return rootView;

    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putStringArrayList(STATE_JOKES, listJokes);
    }
}
