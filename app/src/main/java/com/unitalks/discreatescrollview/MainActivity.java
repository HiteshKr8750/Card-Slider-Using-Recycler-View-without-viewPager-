package com.unitalks.discreatescrollview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<MovieModel> MovieModelList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =findViewById(R.id.recycler_view);
        mAdapter = new MoviesAdapter(MovieModelList);

        /*custom linear layout manager to scaling between items*/
        CenterZoomLayoutManager centerZoomLayoutManager=new CenterZoomLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(centerZoomLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        /*Snap helper for focus on center item while scrolling*/
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        recyclerView.setAdapter(mAdapter);

        /*list of recycler view item*/
        prepareMovieModelData();
    }

    private void prepareMovieModelData() {
        MovieModel MovieModel = new MovieModel("Mad Max: Fury Road", "Action & Adventure", "2015");
        MovieModelList.add(MovieModel);

        MovieModel = new MovieModel("Inside Out", "Animation, Kids & Family", "2015");
        MovieModelList.add(MovieModel);

        MovieModel = new MovieModel("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        MovieModelList.add(MovieModel);

        MovieModel = new MovieModel("Shaun the Sheep", "Animation", "2015");
        MovieModelList.add(MovieModel);

        MovieModel = new MovieModel("The Martian", "Science Fiction & Fantasy", "2015");
        MovieModelList.add(MovieModel);

        MovieModel = new MovieModel("Mission: Impossible Rogue Nation", "Action", "2015");
        MovieModelList.add(MovieModel);

        MovieModel = new MovieModel("Up", "Animation", "2009");
        MovieModelList.add(MovieModel);

        MovieModel = new MovieModel("Star Trek", "Science Fiction", "2009");
        MovieModelList.add(MovieModel);

        MovieModel = new MovieModel("The LEGO MovieModel", "Animation", "2014");
        MovieModelList.add(MovieModel);

        MovieModel = new MovieModel("Iron Man", "Action & Adventure", "2008");
        MovieModelList.add(MovieModel);

        MovieModel = new MovieModel("Aliens", "Science Fiction", "1986");
        MovieModelList.add(MovieModel);

        MovieModel = new MovieModel("Chicken Run", "Animation", "2000");
        MovieModelList.add(MovieModel);

        MovieModel = new MovieModel("Back to the Future", "Science Fiction", "1985");
        MovieModelList.add(MovieModel);

        MovieModel = new MovieModel("Raiders of the Lost Ark", "Action & Adventure", "1981");
        MovieModelList.add(MovieModel);

        MovieModel = new MovieModel("Goldfinger", "Action & Adventure", "1965");
        MovieModelList.add(MovieModel);

        MovieModel = new MovieModel("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        MovieModelList.add(MovieModel);

        mAdapter.notifyDataSetChanged();
    }
}