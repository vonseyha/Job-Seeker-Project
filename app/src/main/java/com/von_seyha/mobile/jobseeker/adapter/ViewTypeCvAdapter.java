package com.von_seyha.mobile.jobseeker.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.von_seyha.mobile.jobseeker.R;
import com.von_seyha.mobile.jobseeker.ShowTypecv;
import com.von_seyha.mobile.jobseeker.holder.ViewTypeCvHolder;
import com.von_seyha.mobile.jobseeker.holder.ViewTypeJobHolder;
import com.von_seyha.mobile.jobseeker.model.ViewTypeCvModel;
import java.util.ArrayList;
public class ViewTypeCvAdapter extends RecyclerView.Adapter<ViewTypeCvHolder> {

    Context context;
    ArrayList<ViewTypeCvModel> listType_cv_model;

    public ViewTypeCvAdapter(Context context, ArrayList<ViewTypeCvModel> listType_cv_model) {
        this.context = context;
        this.listType_cv_model = listType_cv_model;
    }

    @NonNull
    @Override
    public ViewTypeCvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_itemviewtypecv , null);
        return new ViewTypeCvHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewTypeCvHolder holder, int position) {
        holder.imageView.setImageResource(listType_cv_model.get(position).getImage());
        holder.textView.setText(listType_cv_model.get(position).getTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(context, ShowTypecv.class);
               context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listType_cv_model.size();
    }
}
