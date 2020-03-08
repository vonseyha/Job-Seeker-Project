package com.von_seyha.mobile.jobseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.von_seyha.mobile.jobseeker.db.DatabaseHelper;

import static android.widget.Toast.LENGTH_LONG;

public class Login extends AppCompatActivity {
    TextView CLK_Register , forgotpassword;
    EditText email,password;
    Button Btnlogin,btn_back;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        CLK_Register = findViewById(R.id.register_in_login);
        email = findViewById(R.id.fill_email_login);
        password = findViewById(R.id.fill_password_login);
        Btnlogin = findViewById(R.id.btn_login);
        btn_back = findViewById(R.id.btn_back_login);
        databaseHelper = new DatabaseHelper(this);


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),grid_viewitemhome.class);
                startActivity(intent);
            }
        });

        CLK_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Signup.class);
                startActivity(intent);
            }
        });

        Btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                if (TextUtils.isEmpty(Email) && TextUtils.isEmpty(Password)){
                    Toast.makeText(getApplication(), "Please Fill Information!" , Toast.LENGTH_LONG).show();
                }
                if(TextUtils.isEmpty(Email)){
                    Toast.makeText(getApplication(), " Email Empty " , Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(Password)){
                    Toast.makeText(getApplication(), "Password Empty" , Toast.LENGTH_LONG).show();
                }
                else if (databaseHelper.isLoginValid(Email,Password)){
                    Toast.makeText(getApplicationContext(),"Login Successful" , Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),ViewitemhomeProfileAfterLogin.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Invalide Email and Password", LENGTH_LONG).show();
                }
            }
        });
    }
}
