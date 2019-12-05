package com.kira.taskapplication.data;

import com.kira.taskapplication.pojo.MediaData;
import com.kira.taskapplication.pojo.ProfileData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface  GetDataInterface {
    @GET("home")
    Call<MediaData>getMediaData();

    @GET("profile")
    Call<ProfileData>getProfileData();
}
