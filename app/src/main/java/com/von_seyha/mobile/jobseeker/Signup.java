package com.von_seyha.mobile.jobseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.von_seyha.mobile.jobseeker.db.DatabaseHelper;

import org.json.JSONObject;

import java.util.HashMap;

public class Signup extends AppCompatActivity  {
    TextView CLK_Login;
    EditText name , email , password , address ;
    RadioGroup gender;
    Button register,btn_back;
    RequestQueue mRequestQueue;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState){
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
                }else if (databaseHelper.isLoginValidSignup(Name,Email,Password,Address)){
                    Toast.makeText(getApplicationContext(),"Already Exist Account!",Toast.LENGTH_LONG).show();
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
                        name.setText("");
                        email.setText("");
                        password.setText("");
                        address.setText("");
                    } else {
                        Toast.makeText(getApplicationContext(), "Enter the Values", Toast.LENGTH_LONG).show();
                    }
                }
                mRequestQueue = Volley.newRequestQueue(getApplicationContext());
                HashMap data = new HashMap();
                data.put("username",Name);
                data.put("email",Email);
                data.put("password",Password);
                data.put("address",Address);
                data.put("gender",Gender);
                String url="http://192.168.200.62:8000/api/user/create";
                postData(url,data);
            }
        });
    }
    public void postData(String url, HashMap data){
        final RequestQueue requstQueue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonobj = new JsonObjectRequest(Request.Method.POST, url,new JSONObject(data),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("SUCC_onResponse",response.toString());
                        // do your business logic here.....
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("ERROR_onErrorResponse",error.toString());
                    }
                }
        ){

        };
        requstQueue.add(jsonobj);
    }


}
