package com.von_seyha.mobile.jobseeker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.von_seyha.mobile.jobseeker.R;
import com.von_seyha.mobile.jobseeker.holder.ViewTypeJobHolder;
import com.von_seyha.mobile.jobseeker.model.ViewTypeJobModel;

import java.util.ArrayList;

public class ViewTypeJobAdapter extends RecyclerView.Adapter<ViewTypeJobHolder> {

    Context context;
    ArrayList<ViewTypeJobModel> listType_JOB_Model;

    public ViewTypeJobAdapter(Context context, ArrayList<ViewTypeJobModel> listType_JOB_Model) {
        this.context = context;
        this.listType_JOB_Model = listType_JOB_Model;
    }

    @NonNull
    @Override
    public ViewTypeJobHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_itemviewtypejob , null);
        return new ViewTypeJobHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewTypeJobHolder holder, int position) {
        holder.imageView.setImageResource(listType_JOB_Model.get(position).getImage_job());
        holder.textView.setText(listType_JOB_Model.get(position).getTitle_job());
    }

    @Override
    public int getItemCount() {
        return listType_JOB_Model.size();
    }
}
