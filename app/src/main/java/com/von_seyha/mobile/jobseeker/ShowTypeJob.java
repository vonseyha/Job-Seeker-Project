package com.von_seyha.mobile.jobseeker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.von_seyha.mobile.jobseeker.adapter.ViewTypeHomeAdapter;
import com.von_seyha.mobile.jobseeker.model.ViewTypeHomeModel;

import java.util.ArrayList;

public class ShowTypeJob extends AppCompatActivity {

    RecyclerView recyclerView_type_home;
    ViewTypeHomeAdapter adapter_type_home;
    ArrayList<ViewTypeHomeModel> list_type_home_Model;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_type_job);
        recyclerView_type_home = findViewById(R.id.recyclerview_show_typejob);
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


        list_type_home_Model = new ArrayList<>();

        String[][] Info = {
                {"Mobile Developer", "Web Developer", "Accounting", "Digital Markating", "Teacher",},
                {"Full Time","Part Time","Full Time","Part Time","Part Time"},
                {"seyha@gmail.com","seyha1@gmail.com","seyha2@gmail.com","seyha3@gmail.com","seyha4@gmail.com"},
                {"0969840040/01245783","0969840040/01245783","0969840040/01245783","0969840040/01245783","0969840040/01245783"}
        };

        int [] Image = {
                R.drawable.background_image_job,
                R.drawable.background_image_job,
                R.drawable.background_image_job,
                R.drawable.background_image_job,
                R.drawable.background_image_job,

        };

        for (int i = 0 ; i < 5 ; i++ ){
            ViewTypeHomeModel model = new ViewTypeHomeModel();
            model.setImage_background(Image[i]);
            model.setImage_button_show(R.drawable.rectanglee);
            model.setTitle(Info[0][i]);
            model.setTerm(Info[1][i]);
            model.setEmail(Info[2][i]);
            model.setPassword(Info[3][i]);
            model.setShow_more("Show More");
            list_type_home_Model.add(model);
        }
        recyclerView_type_home.setLayoutManager(new GridLayoutManager(this,1));
        adapter_type_home = new ViewTypeHomeAdapter(this,list_type_home_Model);
        recyclerView_type_home.setAdapter(adapter_type_home);

    }
}
