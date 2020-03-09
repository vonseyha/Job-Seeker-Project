package com.von_seyha.mobile.jobseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.von_seyha.mobile.jobseeker.db.DatabaseHelper;

public class Signup extends AppCompatActivity  {

    TextView CLK_Login;
    EditText name , email , password , address ;
    RadioGroup gender;
    Button register,btn_back;

    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        CLK_Login = findViewById(R.id.login_in_signup);
        name = findViewById(R.id.fill_name_signup);
        email = findViewById(R.id.fill_email_signup);
        password = findViewById(R.id.fill_password_signup);
        address = findViewById(R.id.fill_address_signup);
        register = findViewById(R.id.btn_signup);
        gender = findViewById(R.id.gender);

        btn_back = findViewById(R.id.btn_back_signup);

        databaseHelper = new DatabaseHelper(this);
        //Click to login page
        CLK_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , Login.class);
                startActivity(intent);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , grid_viewitemhome.class);
                startActivity(intent);
            }
        });
        //Click register button
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                String Address = address.getText().toString();
                RadioButton checkBtn = findViewById(gender.getCheckedRadioButtonId());
                String Gender = checkBtn.getText().toString();
                if(TextUtils.isEmpty(Name) && TextUtils.isEmpty(Email) && TextUtils.isEmpty(Password) && TextUtils.isEmpty(Address)) {
                    Toast.makeText(getApplication(), "Please Fill Information", Toast.LENGTH_LONG).show();
                }else if(TextUtils.isEmpty(Name)){
                    Toast.makeText(getApplication(), "Name Empty" , Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(Email)){
                    Toast.makeText(getApplication(), "Email Empty" , Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(Password)){
                    Toast.makeText(getApplication(),"Password Empty",Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(Address)) {
                    Toast.makeText(getApplication(), "Address Empty", Toast.LENGTH_LONG).show();
                }
                else {
                    if (Name.length() > 1) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("username", Name);
                        contentValues.put("email", Email);
                        contentValues.put("password", Password);
                        contentValues.put("address", Address);
                        contentValues.put("gender", Gender);
                        databaseHelper.insertUser(contentValues);
                        Toast.makeText(getApplicationContext(), "User Registered", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(getApplicationContext(), "Enter the Values", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


    }

}
