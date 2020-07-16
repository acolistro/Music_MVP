package com.example.music_mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.music_mvp.model.MusicResponse;
import com.example.music_mvp.model.Track;
import com.example.music_mvp.presenters.IMusicListContract;
import com.example.music_mvp.presenters.MusicListImplPresenter;

import java.util.List;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

public class MainActivity extends AppCompatActivity implements IMusicListContract.IMusicListView {

    MusicListImplPresenter musicListImplPresenter;
    IMusicListContract.IMusicListPresenter iMusicListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        Log.i("Music Response", results.get(0).getArtistName());
    }

    @Override
    public void setPresenter(IMusicListContract.IMusicListPresenter presenter) {
        iMusicListPresenter = checkNotNull(presenter);
    }
}