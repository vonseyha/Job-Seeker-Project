package com.von_seyha.mobile.jobseeker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DetailJobPost extends AppCompatActivity {

    ImageView btn_back,btn_Setting,getImg_back  ;
    TextView Job_Title_detail , input_term , input_last_date,input_req,input_exp,input_email,input_tel ,apply_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_job_post);
        btn_back = findViewById(R.id.row_back);
        btn_Setting = findViewById(R.id.setting_img);

        getImg_back = findViewById(R.id.Image_detail_Job);
        Job_Title_detail = findViewById(R.id.Job_Title_detail);
        input_term = findViewById(R.id.input_term);
        input_last_date = findViewById(R.id.input_last_date);
        input_req = findViewById(R.id.input_req);
        input_exp = findViewById(R.id.input_exp);
        input_email = findViewById(R.id.input_email);
        input_tel = findViewById(R.id.input_tel);
        apply_email = findViewById(R.id.apply_email);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String term = intent.getStringExtra("term");
        String lastdate = intent.getStringExtra("lastdate");
        String requirement = intent.getStringExtra("requirement");
        String experience = intent.getStringExtra("experience");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");

        getImg_back.setImageResource(R.drawable.choosed);
        Job_Title_detail.setText(title);
        input_term.setText(term);
        input_last_date.setText(lastdate);
        input_req.setText(requirement);
        input_exp.setText(experience);
        input_email.setText(email);
        input_tel.setText(phone);
        apply_email.setText(email);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),grid_viewitemhome.class);
                startActivity(intent);
            }
        });

        btn_Setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),EmployerProfile.class);
                startActivity(intent);
            }
        });
    }
}
