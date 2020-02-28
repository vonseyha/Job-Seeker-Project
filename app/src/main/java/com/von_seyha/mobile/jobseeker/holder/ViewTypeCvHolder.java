package com.von_seyha.mobile.jobseeker.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.von_seyha.mobile.jobseeker.R;

public class ViewTypeCvHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView textView;

    public ViewTypeCvHolder(@NonNull View itemView) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.icon_type_cv);
        this.textView = itemView.findViewById(R.id.title_type_of_cv);
    }
}
