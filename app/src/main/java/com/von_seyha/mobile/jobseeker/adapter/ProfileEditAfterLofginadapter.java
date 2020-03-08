package com.von_seyha.mobile.jobseeker.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.von_seyha.mobile.jobseeker.DetailJobPost;
import com.von_seyha.mobile.jobseeker.R;
import com.von_seyha.mobile.jobseeker.holder.ViewTypeHomeHolder;
import com.von_seyha.mobile.jobseeker.model.ViewTypeHomeModel;

import java.util.ArrayList;

public class ProfileEditAfterLofginadapter extends RecyclerView.Adapter<ViewTypeHomeHolder> {

    Context context;
    ArrayList<ViewTypeHomeModel> list_Home_Model;

    public ProfileEditAfterLofginadapter(Context context, ArrayList<ViewTypeHomeModel> list_Home_Model) {
        this.context = context;
        this.list_Home_Model = list_Home_Model;
    }

    @NonNull
    @Override
    public ViewTypeHomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_view_edit_job_profile , null);
        return new ViewTypeHomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewTypeHomeHolder holder, int position) {
        holder.image_background.setImageResource(list_Home_Model.get(position).getImage_background());
        holder.image_button_show.setImageResource(list_Home_Model.get(position).getImage_button_show());
        holder.Title.setText(list_Home_Model.get(position).getTitle());
        holder.Term.setText(list_Home_Model.get(position).getTerm());
        holder.Email.setText(list_Home_Model.get(position).getEmail());
        holder.Password.setText(list_Home_Model.get(position).getPassword());
        holder.show_more.setText(list_Home_Model.get(position).getShow_more());

        holder.show_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailJobPost.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list_Home_Model.size();
    }
}
