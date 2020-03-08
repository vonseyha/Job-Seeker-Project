package com.von_seyha.mobile.jobseeker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.von_seyha.mobile.jobseeker.adapter.ViewTypeJobAdapter;
import com.von_seyha.mobile.jobseeker.model.ViewTypeJobModel;

import java.util.ArrayList;

public class activity_viewtype_job extends AppCompatActivity {

    RecyclerView recyclerView_type_job;
    ViewTypeJobAdapter adapter_type_job;
    ArrayList<ViewTypeJobModel> list_type_job_Model;


    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewtype_job);
        recyclerView_type_job = findViewById(R.id.recyclerview_type_of_job);
        bottomNavigationView = findViewById(R.id.tab_button);

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


        list_type_job_Model = new ArrayList<>();

        String[] Title = {
                "Mobile Developer",
                "Web Developer",
                "Accounting",
                "Digital Markating",
                "Teacher",
                "Project Management",
                "Designer",
                "Conteent Writing"
        };

        int [] Image = {
                R.drawable.mobile_background_icon,
                R.drawable.test_choicesa,
                R.drawable.web_choice_icon,
                R.drawable.test_choice,
                R.drawable.degital_marketing_choice,
                R.drawable.accounting_chioce,
                R.drawable.test_choicesa,
                R.drawable.test_choice

        };

        for (int i = 0 ; i < 8 ; i++ ){
            ViewTypeJobModel model = new ViewTypeJobModel();
            model.setImage_job(Image[i]);
            model.setTitle_job(Title[i]);
            list_type_job_Model.add(model);
        }

        recyclerView_type_job.setLayoutManager(new GridLayoutManager(this,2));
        adapter_type_job = new ViewTypeJobAdapter(this,list_type_job_Model);
        recyclerView_type_job.setAdapter(adapter_type_job);
    }
}
