package com.kuycoding.catalogemoview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    TextView tvTitle, tvOverview, tvRuntime, tvIMDb, tvGenre, tvLanguage, tvYear;
    ImageView imgPoster,imgCover;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        tvTitle = findViewById(R.id.txt_title);
        tvOverview = findViewById(R.id.txt_overview);
        tvRuntime = findViewById(R.id.txt_runtime);
        tvIMDb = findViewById(R.id.txt_imdb);
        tvGenre = findViewById(R.id.txt_genre);
        tvLanguage = findViewById(R.id.txt_language);
        tvYear = findViewById(R.id.txt_year);
        imgPoster = findViewById(R.id.img_poster);
        imgCover = findViewById(R.id.img_cover);

        ArrayList<Movie> movie = this.getIntent().getParcelableArrayListExtra(EXTRA_MOVIE);

        int poster = movie.get(0).getPoster();
        imgPoster.setImageResource(poster);

        int cover = movie.get(0).getCover();
        imgCover.setImageResource(cover);

        String title = movie.get(0).getTitle();
        tvTitle.setText(title);

        String overview = movie.get(0).getOverview();
        tvOverview.setText(overview);

        String runtime = movie.get(0).getRuntime();
        tvRuntime.setText(runtime);

        String year = movie.get(0).getYear();
        tvYear.setText(year);

        String imdb = movie.get(0).getImdb();
        tvIMDb.setText(imdb);

        String genre = movie.get(0).getGenre();
        tvGenre.setText(genre);

        String lang = movie.get(0).getLanguage();
        tvLanguage.setText(lang);

    }
}
