package com.von_seyha.mobile.jobseeker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DetailProfileSeeker extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Button btn_back;
    TextView name_edit_employer_profile,
            address_edit_emloyer_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_profile_seeker);
        bottomNavigationView = findViewById(R.id.tab_button);
        btn_back = findViewById(R.id.btn_back_edit_profile_employer);
        name_edit_employer_profile = findViewById(R.id.name_edit_employer_profile);
        address_edit_emloyer_profile = findViewById(R.id.address_edit_emloyer_profile);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String address = intent.getStringExtra("Email");

        name_edit_employer_profile.setText(name);
        address_edit_emloyer_profile.setText(address);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SeekerProfile.class);
                startActivity(intent);
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_profile:
//                        startActivity(new Intent(getApplicationContext(),activity_viewtype_job.class));
//                        overridePendingTransition(0,0);
                        return  true;
                    case R.id.nav_job:
                        Intent typeJob = new Intent(getApplicationContext(),activity_viewtype_job.class);
                        startActivity(typeJob);
                        overridePendingTransition(0,0);
                        return  true;
                    case R.id.nav_home:
                        Intent typeCv = new Intent(getApplicationContext(),grid_viewitemhome.class);
                        startActivity(typeCv);
                        overridePendingTransition(0,0);
                        return  true;
                    case R.id.nav_cv:
                        Intent intent3 = new Intent(getApplicationContext(),activity_viewtype_cv.class);
                        startActivity(intent3);
                        overridePendingTransition(0,0);
                        return  true;
                }

                return false;
            }
        });

    }
}
