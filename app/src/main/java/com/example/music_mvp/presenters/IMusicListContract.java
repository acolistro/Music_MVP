package com.example.music_mvp.presenters;

import com.example.music_mvp.model.Track;

import java.util.List;
import java.util.TreeMap;

public interface IMusicListContract {

    public interface IMusicListPresenter extends IBasePresenter{
        void callMusicListAPI();
    }

    public interface IMusicListView extends IBaseView<IMusicListPresenter>{
        void displayProgressDialog();
        void displayErrorMsg();
        void dismissProgressDialog();
        void displayDataInRecyclerview(List<Track> results);
    }
}
