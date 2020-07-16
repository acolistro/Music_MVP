package com.example.music_mvp.presenters;

import android.util.Log;

import com.example.music_mvp.model.MusicResponse;
import com.example.music_mvp.model.Track;
import com.example.music_mvp.service.IApiHelper;
import com.example.music_mvp.service.ServiceHelper;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MusicListImplPresenter implements IMusicListContract.IMusicListPresenter {

    IApiHelper iApiHelper = ServiceHelper.getClient().create(IApiHelper.class);
    IMusicListContract.IMusicListView iMusicListView;

    public MusicListImplPresenter(IMusicListContract.IMusicListView iMusicListView) {
        this.iMusicListView = iMusicListView;
    }

    @Override
    public void callMusicListAPI() {
        iApiHelper.getMusic()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MusicResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MusicResponse musicResponse) {
                        iMusicListView.displayDataInRecyclerview(musicResponse.getResults());
                    }


                    @Override
                    public void onError(Throwable e) {
                        iMusicListView.displayErrorMsg();
                    }

                    @Override
                    public void onComplete() {

                    }
                });



        };

    @Override
    public void start() {
        iMusicListView.setPresenter(this);
    }
}

