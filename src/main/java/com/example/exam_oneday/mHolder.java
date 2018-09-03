package com.example.exam_oneday;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class mHolder extends RecyclerView.ViewHolder {
    public ImageView iv;
    public mHolder(@NonNull View itemView) {
        super(itemView);
        iv = itemView.findViewById(R.id.iv);
    }
}
