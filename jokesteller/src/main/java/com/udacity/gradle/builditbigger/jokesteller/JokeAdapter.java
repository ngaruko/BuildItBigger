package com.udacity.gradle.builditbigger.jokesteller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by itl on 14/07/2015.
 */
public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.ViewHolderJokes> {

    private LayoutInflater layoutInflater;
    public ArrayList<String> listJokes=new ArrayList<>();



    public JokeAdapter(Context context) {
        layoutInflater=LayoutInflater.from(context);

    }

    //Set joke list
    public void setJokeList(ArrayList<String> listJokes){
        this.listJokes=listJokes;
        notifyItemRangeChanged(0,listJokes.size());

    }

    @Override
    public ViewHolderJokes onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=   layoutInflater.inflate(R.layout.joke_item_layout,parent,false);
        ViewHolderJokes viewHolder=new ViewHolderJokes(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ViewHolderJokes holder, int position) {

        //set data on individual item

        String currentJoke = listJokes.get(position);

        holder.jokeText.setText(currentJoke);


    }



    /**
     * Returns the total number of items in the data set hold by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return listJokes.size();
    }



    public class ViewHolderJokes extends RecyclerView.ViewHolder {

        ImageView jokeIcon;
        TextView jokeText;


        public ViewHolderJokes(View itemView) {
            super(itemView);

            jokeIcon = (ImageView) itemView.findViewById(R.id.item_icon);
            jokeText = (TextView) itemView.findViewById(R.id.item_joke);

        }
    }


}