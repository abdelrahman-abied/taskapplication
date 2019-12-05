package com.kira.taskapplication.ui.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kira.taskapplication.data.GetMediaDataClient;
import com.kira.taskapplication.pojo.MediaData;
import com.kira.taskapplication.pojo.ProfileData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetMediaDataViewModel extends ViewModel {
    public MutableLiveData<List<MediaData.Datum>> mediaDataMutableLiveData = new MutableLiveData<>();


    public void getMediaData() {
        Call<MediaData> mediaDataCall = GetMediaDataClient
                .getInstance().getApi().getMediaData();
        mediaDataCall.enqueue(new Callback<MediaData>() {
            @Override
            public void onResponse(Call<MediaData> call, Response<MediaData> response) {
              mediaDataMutableLiveData.setValue(response.body().getData());
            }

            @Override
            public void onFailure(Call<MediaData> call, Throwable t) {

            }
        });

    }

}
