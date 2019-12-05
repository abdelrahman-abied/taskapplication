package com.kira.taskapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.kira.taskapplication.R;
import com.kira.taskapplication.pojo.MediaData;
import com.kira.taskapplication.pojo.ProfileData;
import com.kira.taskapplication.ui.viewmodel.GetMediaDataViewModel;
import com.kira.taskapplication.ui.viewmodel.GetProfileDataViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends AppCompatActivity {
    private CircleImageView mProfileImage;
    private TextView mProfileNameTV, mProfileLocationTV, mProfileBioTV;
    private TextView mPostsTV, mFollowersTV, mFollowingTv;
    private List<MediaData.Datum> mImageList;
    RecyclerView mImageRecyclerView;

    private GetMediaDataViewModel mMediaDataViewModel;
    private GetProfileDataViewModel mProfileDataViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        intializeFields();

        mImageRecyclerView = findViewById(R.id.images_recyclerview);
        mImageRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mImageRecyclerView.setHasFixedSize(true);

        final ImageRecyclerViewAdapter imageRecyclerViewAdapter = new ImageRecyclerViewAdapter();


        mMediaDataViewModel = ViewModelProviders.of(this).get(GetMediaDataViewModel.class);
        mMediaDataViewModel.getMediaData();
        mMediaDataViewModel.mediaDataMutableLiveData.observe(this, new Observer<List<MediaData.Datum>>() {
            @Override
            public void onChanged(List<MediaData.Datum> data) {

                imageRecyclerViewAdapter.setListItem(data);
                mImageRecyclerView.setAdapter(imageRecyclerViewAdapter);

            }
        });


        mProfileDataViewModel = ViewModelProviders.of(this).get(GetProfileDataViewModel.class);
        mProfileDataViewModel.getProfileData();
        mProfileDataViewModel.profileDataMutableLiveData.observe(this, new Observer<ProfileData>() {
            @Override
            public void onChanged(ProfileData profileData) {

                String profileImageUrl = profileData.getData().getProfilePicture();
                String profileFullName = profileData.getData().getFullName();
                String profileLocation = profileData.getData().getLocation();
                String profileBio = profileData.getData().getBio();
                String postsCount = profileData.getData().getCounts().getPosts().toString();
                String followersCount = profileData.getData().getCounts().getFollowers().toString();
                String followingCount = profileData.getData().getCounts().getFollowing().toString();

                mProfileNameTV.setText(profileFullName);
                mProfileLocationTV.setText(profileLocation);
                mProfileBioTV.setText(profileBio);
                mPostsTV.setText(postsCount);
                mFollowersTV.setText(followersCount);
                mFollowingTv.setText(followingCount);
                Picasso.get().load(profileImageUrl)
                        .resize(120, 120)
                        .into(mProfileImage);

            }
        });


    }

    private void intializeFields() {
        mProfileNameTV = findViewById(R.id.profile_full_name);
        mProfileLocationTV = findViewById(R.id.profile_location);
        mProfileBioTV = findViewById(R.id.profile_bio);
        mProfileImage = findViewById(R.id.profile_image);
        mPostsTV = findViewById(R.id.postsTV);
        mFollowersTV = findViewById(R.id.followersTV);
        mFollowingTv = findViewById(R.id.followingTV);
    }

}
