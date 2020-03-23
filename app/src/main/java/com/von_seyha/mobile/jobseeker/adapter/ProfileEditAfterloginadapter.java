package com.von_seyha.mobile.jobseeker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.von_seyha.mobile.jobseeker.R;
import com.von_seyha.mobile.jobseeker.holder.ViewTypeCvHomeHolder;
import com.von_seyha.mobile.jobseeker.model.ViewTypeCvHomeModel;

import java.util.ArrayList;

public class ProfileEditAfterloginadapter extends RecyclerView.Adapter<ViewTypeCvHomeHolder> {

    Context context;
    ArrayList<ViewTypeCvHomeModel> listCVHomeModel;

    public ProfileEditAfterloginadapter(Context context, ArrayList<ViewTypeCvHomeModel> listCVHomeModel) {
        this.context = context;
        this.listCVHomeModel = listCVHomeModel;
    }

    @NonNull
    @Override
    public ViewTypeCvHomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_viewitemcvhome , null);
        return new ViewTypeCvHomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewTypeCvHomeHolder holder, int position) {
        //Picasso.get().load(listCVHomeModel.get(position).getProfile_cv_post()).into(holder.profile_cv_post);
        holder.profile_cv_post.setImageResource(listCVHomeModel.get(position).getProfile_cv_post());
        holder.btn_view.setImageResource(listCVHomeModel.get(position).getBtn_view());
        holder.name_cv_post.setText(listCVHomeModel.get(position).getName_cv_post());
        holder.last_update_cv_post.setText(listCVHomeModel.get(position).getLast_update_cv_post());
        holder.function_cv_home.setText(listCVHomeModel.get(position).getFunction_cv_home());
        holder.experience_cv_home.setText(listCVHomeModel.get(position).getExperience_cv_home());
        holder.email_cv_home.setText(listCVHomeModel.get(position).getEmail_cv_home());
        holder.password_cv_home.setText(listCVHomeModel.get(position).getPassword_cv_home());
        holder.view_cv.setText(listCVHomeModel.get(position).getView_cv());
    }

    @Override
    public int getItemCount() {
        return listCVHomeModel.size();
    }
}
