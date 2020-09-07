package com.gadspracticeproject;

import com.gadspracticeproject.Models.LeaderModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRepo {

    @GET("api/hours")
    Call<ArrayList<LeaderModel>> getHours();
    @GET("api/skilliq")
    Call<List<LeaderModel>> getIq();
}
