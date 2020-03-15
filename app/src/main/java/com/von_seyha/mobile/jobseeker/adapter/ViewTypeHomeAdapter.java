package com.von_seyha.mobile.jobseeker.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.von_seyha.mobile.jobseeker.DetailJobPost;
import com.von_seyha.mobile.jobseeker.DetailProfileSeeker;
import com.von_seyha.mobile.jobseeker.R;
import com.von_seyha.mobile.jobseeker.SeekerProfile;
import com.von_seyha.mobile.jobseeker.holder.ViewTypeHomeHolder;
import com.von_seyha.mobile.jobseeker.model.ViewTypeHomeModel;

import java.util.ArrayList;

public class ViewTypeHomeAdapter extends RecyclerView.Adapter<ViewTypeHomeHolder> {

    Context context;
    ArrayList<ViewTypeHomeModel> list_Home_Model;

    public ViewTypeHomeAdapter(Context context, ArrayList<ViewTypeHomeModel> list_Home_Model) {
        this.context = context;
        this.list_Home_Model = list_Home_Model;
    }

    @NonNull
    @Override
    public ViewTypeHomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_viewitemhome , null);
        return new ViewTypeHomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewTypeHomeHolder holder, final int position) {
        //Picasso.get().load(list_Home_Model.get(position).getImage_background()+toString()).into(holder.image_background);
        holder.image_background.setImageResource(list_Home_Model.get(position).getImage_background());
        holder.image_button_show.setImageResource(list_Home_Model.get(position).getImage_button_show());
        holder.Title.setText(list_Home_Model.get(position).getTitle());
        holder.Term.setText(list_Home_Model.get(position).getTerm());
        holder.Email.setText(list_Home_Model.get(position).getEmail());
        holder.Password.setText(list_Home_Model.get(position).getPassword());
        holder.show_more.setText(list_Home_Model.get(position).getShow_more());

        //Addmore
        holder.requirement.setText(list_Home_Model.get(position).getRequirement());
        holder.experience.setText(list_Home_Model.get(position).getExperience());
        holder.lastdate.setText(list_Home_Model.get(position).getLastdate());

        holder.image_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailJobPost.class);
                intent.putExtra("image",R.drawable.chooseb);
                intent.putExtra("title",list_Home_Model.get(position).getTitle());
                intent.putExtra("term",list_Home_Model.get(position).getTerm());
                intent.putExtra("lastdate",list_Home_Model.get(position).getLastdate());
                intent.putExtra("requirement",list_Home_Model.get(position).getRequirement());
                intent.putExtra("experience",list_Home_Model.get(position).getExperience());
                intent.putExtra("email",list_Home_Model.get(position).getEmail());
                intent.putExtra("phone",list_Home_Model.get(position).getPassword());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return list_Home_Model.size();
    }
}
