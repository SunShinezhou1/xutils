package com.example.exam_oneday;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import org.xutils.common.Callback;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<mHolder> {
    private Context context;
    private bean b;

    public Adapter(Context context, bean b) {
        this.context = context;
        this.b = b;
    }

    @NonNull
    @Override
    public mHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout, null);
        mHolder mHolder = new mHolder(inflate);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull mHolder mHolder, int i) {
        List<bean.DataBean> data = b.getData();
        String pic = data.get(i).getPic();
        Picasso.with(context).load(pic).into(mHolder.iv);
    }

    @Override
    public int getItemCount() {
        List<bean.DataBean> data = b.getData();
        return data.size();
    }
}
