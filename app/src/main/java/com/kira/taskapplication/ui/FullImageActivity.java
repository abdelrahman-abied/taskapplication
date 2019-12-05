package com.kira.taskapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.kira.taskapplication.R;
import com.squareup.picasso.Picasso;

public class FullImageActivity extends AppCompatActivity {
private ImageView mImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        String imageUrl =getIntent().getStringExtra("URL");
        mImage=findViewById(R.id.full_ٍscreen_image);
        Picasso.get().load(imageUrl).into(mImage);

    }
}
