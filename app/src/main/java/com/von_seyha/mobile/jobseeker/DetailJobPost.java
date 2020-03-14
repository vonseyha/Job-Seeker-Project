package com.von_seyha.mobile.jobseeker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DetailJobPost extends AppCompatActivity {

    ImageView btn_back,btn_Setting;

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_job_post);
        btn_back = findViewById(R.id.row_back);
        btn_Setting = findViewById(R.id.setting_img);
        bottomNavigationView = findViewById(R.id.tab_button);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),grid_viewitemhome.class);
                startActivity(intent);
            }
        });

//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                switch (item.getItemId()){
//                    case R.id.nav_profile:
////                        startActivity(new Intent(getApplicationContext(),activity_viewtype_job.class));
////                        overridePendingTransition(0,0);
//                        return  true;
//
//                    case R.id.nav_job:
//                        Intent typeJob = new Intent(getApplicationContext(),activity_viewtype_job.class);
//                        startActivity(typeJob);
//                        overridePendingTransition(0,0);
//                        return  true;
//
//                    case R.id.nav_home:
//                        Intent typeCv = new Intent(getApplicationContext(),grid_viewitemhome.class);
//                        startActivity(typeCv);
//                        overridePendingTransition(0,0);
//                        return  true;
//
//                    case R.id.nav_cv:
//                        Intent intent3 = new Intent(getApplicationContext(),activity_viewtype_cv.class);
//                        startActivity(intent3);
//                        overridePendingTransition(0,0);
//                        return  true;
//                }
//
//                return false;
//            }
//        });


        btn_Setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),EmployerProfile.class);
                startActivity(intent);
            }
        });
    }
}
