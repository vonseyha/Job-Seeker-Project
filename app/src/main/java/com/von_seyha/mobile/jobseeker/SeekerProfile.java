package com.von_seyha.mobile.jobseeker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.von_seyha.mobile.jobseeker.adapter.ViewTypeCvHomeAdapter;
import com.von_seyha.mobile.jobseeker.model.ViewTypeCvHomeModel;

import java.util.ArrayList;

public class SeekerProfile extends AppCompatActivity {
    RecyclerView recyclerView;
    ViewTypeCvHomeAdapter adapter;
    ArrayList<ViewTypeCvHomeModel> listCV_Model;

    Button btn_back , btn_clk_profile;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeker_profile);
        recyclerView = findViewById(R.id.recyclerview_seeker_profile);
        btn_back = findViewById(R.id.btn_back_profile_seeker);
        btn_clk_profile = findViewById(R.id.btn_CLK_profile_seeker);
        bottomNavigationView = findViewById(R.id.tab_button);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),activity_viewcvhome.class);
                startActivity(intent);
            }
        });
        btn_clk_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DetailProfileSeeker.class);
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


        listCV_Model = new ArrayList<>();

        String[][] Info = {
                {"Von Seyha", "Korn Sanit", "Try Chanty", "Soy Sin", "Meng Visal","Tang Eamseng","Seb Bunly","Poth Vothha"},
                {"Post: 10/12/2020","Post: 01/03/2020","Post: 11/02/2020","Post: 15/06/2020","Post: 10/12/2020","Post: 01/03/2020","Post: 11/02/2020","Post: 15/06/2020"},
                {"Mobile Developer", "Web Developer", "Accounting", "Digital Markating", "Teacher","Database","Accounting", "Digital Markating", "Teacher","Database",},
                {"2-3 Years","2-3 Years","2-3 Years","2-3 Years","2-3 Years","2-3 Years","2-3 Years","2-3 Years"},
                {"seyha@gmail.com","seyha1@gmail.com","seyha2@gmail.com","seyha3@gmail.com","seyha@gmail.com","seyha1@gmail.com","seyha2@gmail.com","seyha3@gmail.com"},
                {"0969840040/01245783","0969840040/01245783","0969840040/01245783","0969840040/01245783","0969840040/01245783","0969840040/01245783","0969840040/01245783","0969840040/01245783"},
        };

        int[] Image = {
                R.drawable.circle_profileb,
                R.drawable.circle_profilea,
                R.drawable.circle_profilec,
                R.drawable.circle_profiled,
                R.drawable.circle_profilee,
                R.drawable.circle_profilef,
                R.drawable.circle_profileg,
                R.drawable.circle_profilei,
        };

        for (int i = 0 ; i < 8 ; i++ ){

            ViewTypeCvHomeModel model = new ViewTypeCvHomeModel();
            model.setProfile_cv_post( Image[i]);
            model.setBtn_view(R.drawable.rectanglee);
            model.setName_cv_post(Info[0][i]);
            model.setLast_update_cv_post(Info[1][i]);
            model.setFunction_cv_home(Info[2][i]);
            model.setExperience_cv_home(Info[3][i]);
            model.setEmail_cv_home(Info[4][i]);
            model.setPassword_cv_home(Info[5][i]);
            model.setView_cv("View CV");
            listCV_Model.add(model);
        }
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new ViewTypeCvHomeAdapter(this ,listCV_Model );
        recyclerView.setAdapter(adapter);
    }
}
