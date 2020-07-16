package com.example.music_mvp.presenters;

public interface IMusicListContract {

    public interface IPresenter extends IBasePresenter{
        void callMusicListAPI();
    }

    public interface IMusicListView extends IBaseView<IPresenter>{
        void displayProgressDialog();
        void displayErrorMsg();
        void dismissProgressDialog();
        void displayDataInRecyclerview();
    }
}
