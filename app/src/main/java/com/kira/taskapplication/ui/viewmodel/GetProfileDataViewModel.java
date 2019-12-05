package com.kira.taskapplication.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kira.taskapplication.data.GetMediaDataClient;
import com.kira.taskapplication.pojo.ProfileData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetProfileDataViewModel extends ViewModel {
   public MutableLiveData<ProfileData> profileDataMutableLiveData = new MutableLiveData<>();

    public void getProfileData() {
        Call<ProfileData> profileDataCall = GetMediaDataClient
                .getInstance().getApi().getProfileData();
        profileDataCall.enqueue(new Callback<ProfileData>() {
            @Override
            public void onResponse(Call<ProfileData> call, Response<ProfileData> response) {
                profileDataMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ProfileData> call, Throwable t) {

            }
        });

    }
}
