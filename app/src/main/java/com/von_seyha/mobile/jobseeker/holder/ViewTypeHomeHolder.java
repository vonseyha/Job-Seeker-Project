package com.von_seyha.mobile.jobseeker.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.von_seyha.mobile.jobseeker.R;

public class ViewTypeHomeHolder extends RecyclerView.ViewHolder {

    public ImageView image_background , image_button_show;
    public TextView Title , Term , Email , Password , show_more , clk_post;
    //Addmore
    public TextView requirement , experience,lastdate ,address;

    public ViewTypeHomeHolder(@NonNull View itemView) {
        super(itemView);
        this.image_background = itemView.findViewById(R.id.image_post_job);
        this.image_button_show = itemView.findViewById(R.id.btn_job_show_more);
        this.Title = itemView.findViewById(R.id.job_title);
        this.Term = itemView.findViewById(R.id.job_term);
        this.Email = itemView.findViewById(R.id.job_email);
        this.Password = itemView.findViewById(R.id.job_phone);
        this.show_more = itemView.findViewById(R.id.txt_job_show_more);
        this.clk_post = itemView.findViewById(R.id.btn_post_job );
        //Addmore
        this.requirement = itemView.findViewById(R.id.input_reqs);
        this.experience = itemView.findViewById(R.id.input_exps);
        this.lastdate = itemView.findViewById(R.id.input_last_dates);
        this.address = itemView.findViewById(R.id.input_address);
    }
}
