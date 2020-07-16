package com.example.music_mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.music_mvp.model.MusicResponse;
import com.example.music_mvp.model.Track;
import com.example.music_mvp.presenters.IMusicListContract;
import com.example.music_mvp.presenters.MusicListImplPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMusicListContract.IMusicListView {

    MusicListImplPresenter musicListImplPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        musicListImplPresenter = new MusicListImplPresenter(this);
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

    }

    @Override
    public void setPresenter(IMusicListContract.IMusicListPresenter presenter) {

    }
}