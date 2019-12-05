package com.kira.taskapplication.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.kira.taskapplication.R;
import com.kira.taskapplication.pojo.MediaData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ImageRecyclerViewAdapter extends RecyclerView.Adapter<ImageRecyclerViewAdapter.ImageViewHolder> {

    private List<MediaData.Datum> mImageList = new ArrayList<>();
    private Context mContext;

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
mContext=parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_card_item, parent, false);

        return new ImageViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull final ImageViewHolder holder, final int position) {
        String imageUrl = mImageList.get(position).getImage();
        Picasso.get().load(imageUrl)
                .resize(200,200)
                .into(holder.mImageView);
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String imageUrl=   mImageList.get(position).getImage();
                Intent intent=new Intent(mContext,FullImageActivity.class);
                intent.putExtra("URL",imageUrl);
                mContext.startActivity(intent);
            }
        });
    }

    public void setListItem(List<MediaData.Datum> listItem) {
        this.mImageList = listItem;
    }

    @Override
    public int getItemCount() {
        return mImageList.size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        CardView mCardView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageIV);
            mCardView = itemView.findViewById(R.id.cardview_id);
        }
    }


}
