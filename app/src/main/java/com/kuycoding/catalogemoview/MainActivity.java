package com.kuycoding.catalogemoview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.kuycoding.catalogemoview.Adapter.MovieAdapter;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private String[] dataTitile, dataImdb, dataGenre, dataOverview, dataLanguage, dataRelease, dataRuntime, dataYear;
    private TypedArray dataPoster, dataCover;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent moveDetail = new Intent(MainActivity.this,MovieDetailActivity.class);

                ArrayList<Movie> movies = new ArrayList<Movie>();

                Movie movie = new Movie();
                movie.setPoster(dataPoster.getResourceId(i, -1));
                movie.setCover(dataCover.getResourceId(i,0));
                movie.setTitle(dataTitile[i]);
                movie.setGenre(dataGenre[i]);
                movie.setImdb(dataImdb[i]);
                movie.setOverview(dataOverview[i]);
                movie.setLanguage(dataLanguage[i]);
                movie.setYear(dataYear[i]);
                movie.setRuntime(dataRuntime[i]);

                movies.add(movie);

                moveDetail.putParcelableArrayListExtra(MovieDetailActivity.EXTRA_MOVIE, movies);
                startActivity(moveDetail);

//                Toast.makeText(MainActivity.this, movies.get(i).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void addItem() {
        movies = new ArrayList<>();

        for (int i = 0; i < dataTitile.length; i++) {
            Movie movie = new Movie();
            movie.setPoster(dataPoster.getResourceId(i, -1));
            movie.setTitle(dataTitile[i]);
            movie.setGenre(dataGenre[i]);
            movie.setImdb(dataImdb[i]);
            movie.setOverview(dataOverview[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare(){
        dataTitile = getResources().getStringArray(R.array.data_title);
        dataGenre = getResources().getStringArray(R.array.data_genre);
        dataImdb = getResources().getStringArray(R.array.data_imdb);
        dataLanguage = getResources().getStringArray(R.array.data_language);
        dataYear = getResources().getStringArray(R.array.data_year);
        dataRuntime = getResources().getStringArray(R.array.data_runtime);
        dataOverview = getResources().getStringArray(R.array.data_overview);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
        dataCover = getResources().obtainTypedArray(R.array.data_cover);
    }

    @Override
    public void onClick(View view) {

    }
}
