package com.von_seyha.mobile.jobseeker.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.von_seyha.mobile.jobseeker.R;

public class ViewTypeCvHomeHolder extends RecyclerView.ViewHolder {
    public ImageView profile_cv_post,btn_view;
    public TextView name_cv_post,
            last_update_cv_post,
            function_cv_home,
            experience_cv_home
            ,email_cv_home,
            password_cv_home,
            view_cv;

    public ViewTypeCvHomeHolder(@NonNull View itemView) {
        super(itemView);
        this.profile_cv_post = itemView.findViewById(R.id.profile_cv_post);
        this.btn_view = itemView.findViewById(R.id.btn_view_cv);
        this.name_cv_post = itemView.findViewById(R.id.name_cv_post);
        this.last_update_cv_post = itemView.findViewById(R.id.last_update_cv_post);
        this.function_cv_home = itemView.findViewById(R.id.function_cv_home);
        this.experience_cv_home = itemView.findViewById(R.id.experience_cv_home);
        this.email_cv_home = itemView.findViewById(R.id.email_cv_home);
        this.password_cv_home = itemView.findViewById(R.id.password_cv_home);
        this.view_cv = itemView.findViewById(R.id.view_cv);

    }
}
