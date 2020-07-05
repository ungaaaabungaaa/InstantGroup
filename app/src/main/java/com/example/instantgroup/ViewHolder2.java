package com.example.instantgroup;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ViewHolder2 extends RecyclerView.ViewHolder {
    View mView;

    public ViewHolder2(@NonNull View itemView) {
        super(itemView);
        mView = itemView;
    }


    public void setDetails(Context applicationContext, String name, String imageUrl) {
        TextView mTitleTv = mView.findViewById(R.id.text_view_name);
        ImageView mImageIv = mView.findViewById(R.id.image_view_upload);
        mTitleTv.setText(name);
        Picasso.get().load(imageUrl).into(mImageIv);

    }
}
