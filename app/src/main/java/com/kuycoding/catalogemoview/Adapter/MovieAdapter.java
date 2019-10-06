package com.kuycoding.catalogemoview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kuycoding.catalogemoview.Movie;
import com.kuycoding.catalogemoview.R;

import java.util.ArrayList;


public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie> movies;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup,false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Movie movies = (Movie) getItem(i);
        viewHolder.bind(movies);
        return view;
    }

    private class ViewHolder {
        private TextView tvTitle, tvImdb, tvGenre,tvOverview;
        private ImageView imgPoster;

        ViewHolder(View view) {
            imgPoster = view.findViewById(R.id.img_poster);
            tvTitle = view.findViewById(R.id.txt_title);
            tvImdb = view.findViewById(R.id.txt_imdb_home);
            tvGenre = view.findViewById(R.id.txt_genre);
            tvOverview = view.findViewById(R.id.txt_overview);
        }
        void bind(Movie movie) {
            imgPoster.setImageResource(movie.getPoster());
            tvTitle.setText(movie.getTitle());
            tvImdb.setText(movie.getImdb());
            tvGenre.setText(movie.getGenre());
            tvOverview.setText(movie.getOverview());
        }
    }
}
