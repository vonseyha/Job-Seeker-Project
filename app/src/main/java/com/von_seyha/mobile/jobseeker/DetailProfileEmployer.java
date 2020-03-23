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

public class DetailProfileEmployer extends AppCompatActivity {

//    btn_back_detail_profile_employer
//            //profile_image_detail_profile_employer
//    name_detail_profile_employer
//            address_detail_profile_employer
//            des_email
//    des_com_location
//            des_com_about_company
//    des_edit_profile
//    logout(icon)
//    des_logout


    Button btn_back;
    BottomNavigationView bottomNavigationView;

    TextView name_detail_profile_employer ,
            address_detail_profile_employer,
            des_email, des_com_location ,
            des_com_about_company ,
            des_edit_profile ,
            des_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_profile_employer);
        btn_back = findViewById(R.id.btn_back_detail_profile_employer);
                name_detail_profile_employer  = findViewById(R.id.name_detail_profile_employer);
                address_detail_profile_employer = findViewById(R.id.address_detail_profile_employer);
                des_email = findViewById(R.id.des_com_email) ;
                des_com_location = findViewById(R.id.des_com_location);
                des_com_about_company = findViewById(R.id.des_com_about_company);
                des_edit_profile = findViewById(R.id.des_edit_profile);
                des_logout = findViewById(R.id.des_logout);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String address = intent.getStringExtra("Address");
        String email = intent.getStringExtra("Email");

        name_detail_profile_employer.setText(name);
        address_detail_profile_employer.setText(address);
        des_email.setText(email);
        des_com_location.setText(address);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),EmployerProfile.class);
                startActivity(intent);
            }
        });
    }
}
