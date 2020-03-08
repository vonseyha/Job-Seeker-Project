package com.von_seyha.mobile.jobseeker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.von_seyha.mobile.jobseeker.adapter.ViewTypeCvAdapter;
import com.von_seyha.mobile.jobseeker.model.ViewTypeCvModel;

import java.util.ArrayList;

public class activity_viewtype_cv extends AppCompatActivity {

    RecyclerView recyclerView_type_cv;
    ViewTypeCvAdapter adapter_type_cv;
    ArrayList<ViewTypeCvModel> list_type_cv_Model;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewtype_cv);
        recyclerView_type_cv = findViewById(R.id.recyclerview_type_of_cv);
        bottomNavigationView = findViewById(R.id.tab_button);
        list_type_cv_Model = new ArrayList<>();

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
                R.drawable.background_iconacv,
                R.drawable.background_iconacv,
                R.drawable.background_iconbcv,
                R.drawable.background_icondcv,
                R.drawable.background_iconfcv,
                R.drawable.background_iconccv,
                R.drawable.background_iconacv,
                R.drawable.background_icondcv

        };

        for (int i = 0 ; i < 8 ; i++ ){
            ViewTypeCvModel model = new ViewTypeCvModel();
            model.setImage(Image[i]);
            model.setTitle(Title[i]);
            list_type_cv_Model.add(model);
        }

        recyclerView_type_cv.setLayoutManager(new GridLayoutManager(this,2));
        adapter_type_cv = new ViewTypeCvAdapter(this,list_type_cv_Model);
        recyclerView_type_cv.setAdapter(adapter_type_cv);
    }
}
