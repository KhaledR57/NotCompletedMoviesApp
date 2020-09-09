package com.example.moviesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MoreMoviesAdapter extends RecyclerView.Adapter<MoreMoviesAdapter.MoreMoviesHolder> {

    private Context context;
    private List<Movies> moviesList;

    public MoreMoviesAdapter(Context context, List<Movies> moviesList) {
        this.context = context;
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public MoreMoviesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.best_movies_slide,parent,false);
        return new MoreMoviesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoreMoviesHolder holder, int position) {
        holder.poster.setImageResource(moviesList.get(position).getPoster());
        holder.title.setText(moviesList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MoreMoviesHolder extends RecyclerView.ViewHolder{
        private ImageView poster;
        private TextView title;
        public MoreMoviesHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.best_movie_poster);
            title = itemView.findViewById(R.id.best_movie_name);
        }
    }
}
