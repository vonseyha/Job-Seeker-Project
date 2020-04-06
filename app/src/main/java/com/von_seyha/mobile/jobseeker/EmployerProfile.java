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
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.von_seyha.mobile.jobseeker.adapter.ViewTypeHomeAdapter;
import com.von_seyha.mobile.jobseeker.model.ViewTypeHomeModel;

import java.util.ArrayList;

public class EmployerProfile extends AppCompatActivity {

    RecyclerView recyclerView_type_home;
    ViewTypeHomeAdapter adapter_type_home;
    ArrayList<ViewTypeHomeModel> list_type_home_Model;

    Button btn_back , btn_profileEmployer;
    BottomNavigationView bottomNavigationView;
    TextView name_employer_profile , address_emloyer_profile , email_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_profile);
        btn_back = findViewById(R.id.btn_back_profile_employer);
        btn_profileEmployer = findViewById(R.id.btn_CLK_profile_employer);
        recyclerView_type_home = findViewById(R.id.recyclerview_employer_profile);
        bottomNavigationView = findViewById(R.id.tab_button);
        name_employer_profile = findViewById(R.id.name_employer_profile);
        address_emloyer_profile = findViewById(R.id.address_emloyer_profile);
        email_detail = findViewById(R.id.email_detail);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Title");
        String address = intent.getStringExtra("Address");
        String email = intent.getStringExtra("Email");

        name_employer_profile.setText(name);
        address_emloyer_profile.setText(address);
        email_detail.setText(email);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DetailJobPost.class);
                startActivity(intent);
            }
        });

        btn_profileEmployer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name_employer_profile.getText().toString();
                String Address = address_emloyer_profile.getText().toString();
                String Email = email_detail.getText().toString();
                Intent intent = new Intent(getApplicationContext(),DetailProfileEmployer.class);
                intent.putExtra("Name",Name);
                intent.putExtra("Address",Address);
                intent.putExtra("Email",Email);
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


        list_type_home_Model = new ArrayList<>();

        String[][] Info = {
                {"Mobile Developer", "Web Developer", "Accounting", "Digital Markating", "Teacher",},
                {"Full Time","Part Time","Full Time","Part Time","Part Time"},
                {"seyha@gmail.com","seyha1@gmail.com","seyha2@gmail.com","seyha3@gmail.com","seyha4@gmail.com"},
                {"0969840040/01245783","0969840040/01245783","0969840040/01245783","0969840040/01245783","0969840040/01245783"}
        };

        int [] Image = {
                R.drawable.choosed,
                R.drawable.chooseg,
                R.drawable.chooseh,
                R.drawable.choosej,
                R.drawable.choosef,
        };

        for (int i = 0 ; i < 5 ; i++ ){
            ViewTypeHomeModel model = new ViewTypeHomeModel();
            //model.setImage_background();
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
