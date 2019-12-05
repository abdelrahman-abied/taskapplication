package com.kira.taskapplication.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.util.List;


public class MediaData {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;


    public List<Datum> getData() {
        return data;
    }


    public class Datum {


        @SerializedName("image")
        @Expose
        private String image;


        public String getImage() {
            return image;
        }


    }

}