package com.example.music_mvp.service;

import com.example.music_mvp.model.Constants;
import com.example.music_mvp.model.MusicResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IApiHelper {
    @GET(Constants.RELATIVE_URL)
    Observable<MusicResponse> getMusic();
}
