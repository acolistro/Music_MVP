package com.example.music_mvp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.music_mvp.adapter.RecyclerViewMusicAdapter;
import com.example.music_mvp.model.MusicResponse;
import com.example.music_mvp.model.Track;
import com.example.music_mvp.presenters.IMusicListContract;
import com.example.music_mvp.presenters.MusicListImplPresenter;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

public class MainActivity extends AppCompatActivity implements IMusicListContract.IMusicListView {

    private RecyclerView recyclerView;
    private RecyclerViewMusicAdapter recyclerViewMusicAdapter;
    private List<Track> trackList;

    MusicListImplPresenter musicListImplPresenter;
    IMusicListContract.IMusicListPresenter iMusicListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        recyclerViewMusicAdapter = new RecyclerViewMusicAdapter(MainActivity.this, trackList);
        musicListImplPresenter = new MusicListImplPresenter(this);
        musicListImplPresenter.start();
        musicListImplPresenter.callMusicListAPI();
    }

    @Override
    public void displayProgressDialog() {

    }

    @Override
    public void displayErrorMsg() {

    }

    @Override
    public void dismissProgressDialog() {

    }

    @Override
    public void displayDataInRecyclerview(List<Track> results) {
        recyclerView.setAdapter(new RecyclerViewMusicAdapter(this, results));
        Log.i("Music Response", results.get(0).getArtistName());
    }

    @Override
    public void setPresenter(IMusicListContract.IMusicListPresenter presenter) {
        iMusicListPresenter = checkNotNull(presenter);
    }
}