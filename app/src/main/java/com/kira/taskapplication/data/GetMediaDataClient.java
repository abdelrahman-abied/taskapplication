package com.kira.taskapplication.data;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetMediaDataClient {

  private static final String BASE_URL = "http://i0sa.com/bit/task/";
    private static GetMediaDataClient mInstance;
    private Retrofit retrofit;

    private GetMediaDataClient() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized GetMediaDataClient getInstance() {
        if (mInstance == null) {
            mInstance = new GetMediaDataClient();
        }
        return mInstance;
    }

    public GetDataInterface getApi() {
        return retrofit.create(GetDataInterface.class);
    }
}
