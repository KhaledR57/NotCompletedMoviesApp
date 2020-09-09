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

public class BestMoviesAdapter extends RecyclerView.Adapter<BestMoviesAdapter.BestMoviesHolder> {

    private Context context;
    private List<Movies> moviesList;
    private MovieItemClickListener listener;


    public BestMoviesAdapter(Context context, List<Movies> moviesList, MovieItemClickListener listener) {
        this.context = context;
        this.moviesList = moviesList;
        this.listener = listener;

    }

    @NonNull
    @Override
    public BestMoviesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.best_movies_slide,parent,false);
        return new BestMoviesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BestMoviesHolder holder, final int position) {
        holder.poster.setImageResource(moviesList.get(position).getPoster());
        holder.title.setText(moviesList.get(position).getTitle());
        //holder.year.setText(moviesList.get(position).getYear());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onMovieClick(moviesList.get(position),holder.poster);
            }
        });
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class BestMoviesHolder extends RecyclerView.ViewHolder{
        private ImageView poster;
        private TextView title;
        public BestMoviesHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.best_movie_poster);
            title = itemView.findViewById(R.id.best_movie_name);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    listener.onMovieClick(moviesList.get(getAdapterPosition()),poster);
//                }
//            });
        }
    }
}
