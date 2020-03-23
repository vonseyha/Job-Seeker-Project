package com.von_seyha.mobile.jobseeker.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.von_seyha.mobile.jobseeker.R;

public class ViewTypeJobHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView textView;
    public CardView cardView;

    public ViewTypeJobHolder(@NonNull View itemView) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.icon_type_job);
        this.textView = itemView.findViewById(R.id.title_type_of_job);
        this.cardView = itemView.findViewById(R.id.cardview_type_of_job);
    }
}
