package com.von_seyha.mobile.jobseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.von_seyha.mobile.jobseeker.db.DatabaseHelper;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static android.widget.Toast.LENGTH_LONG;
public class Login extends AppCompatActivity {
    TextView CLK_Register , forgotpassword , FULLNAME2 , ADDRESS2 , EMAIL2;
    EditText email1,password1;
    Button Btnlogin,btn_back;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        CLK_Register = findViewById(R.id.register_in_login);
        email1 = findViewById(R.id.fill_email_login);
        password1 = findViewById(R.id.fill_password_login);
        Btnlogin = findViewById(R.id.btn_login);
        btn_back = findViewById(R.id.btn_back_login);
        databaseHelper = new DatabaseHelper(this);

        FULLNAME2 = findViewById(R.id.fullname);
        ADDRESS2 = findViewById(R.id.address);
        EMAIL2 = findViewById(R.id.email);


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
                String Email = email1.getText().toString();
                String Password = password1.getText().toString();

                if (TextUtils.isEmpty(Email) && TextUtils.isEmpty(Password)){
                    Toast.makeText(getApplication(), "Please Fill Information!",Toast.LENGTH_LONG).show();
                }
                if(TextUtils.isEmpty(Email)){
                    Toast.makeText(getApplication(), " Email Empty ",Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(Password)){
                    Toast.makeText(getApplication(), "Password Empty",Toast.LENGTH_LONG).show();
                }
                else if (databaseHelper.isLoginValid(Email,Password)){
                    String fullname = FULLNAME2.getText().toString();
                    String email3 = EMAIL2.getText().toString();
                    String address3 = ADDRESS2.getText().toString();
                    Toast.makeText(getApplicationContext(),"Login Successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),grid_viewitemhome.class);
                    intent.putExtra("username_l",fullname);
                    intent.putExtra("email_l",email3);
                    intent.putExtra("address_l",address3 );
                    startActivity(intent);
                    email1.setText("");
                    password1.setText("");
                }
                else {
                    Toast.makeText(getApplicationContext(),"Invalide Email and Password", LENGTH_LONG).show();
                }
                parseJSON(Email,Password);
            }
        });
    }

    public String parseJSON(final String email , final String password){
        String url = "http://192.168.200.62:8000/api/user/login/"+email+"/"+password;
        StringRequest request = new StringRequest(Request.Method.GET,url, new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    if(success.equals("1")){
                        Intent intent = new Intent(getApplicationContext(),grid_viewitemhome.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Invalide Email and Password", LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("email",email1.getText().toString());
                map.put("password",password1.getText().toString());
                return super.getParams();
            }
        };
        String EMAIL_LO = email1.getText().toString();
        readJSON(EMAIL_LO);

        RequestQueue requestQueue =Volley.newRequestQueue(this);
        requestQueue.add(request);
        return email;
    }

    public String readJSON(final String email){
        String url = "http://192.168.200.62:8000 n/api/user/show/"+email;
        StringRequest request = new StringRequest(Request.Method.GET,url, new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    if(success.equals("1")){
                        String fullname = FULLNAME2.getText().toString();
                        String email3 = EMAIL2.getText().toString();
                        String address3 = ADDRESS2.getText().toString();

                        Intent intent = new Intent(getApplicationContext(),grid_viewitemhome.class);
                        intent.putExtra("username_l",fullname);
                        intent.putExtra("email_l",email3);
                        intent.putExtra("address_l",address3 );
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"Success", LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Invalide Email and Password", LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("username",FULLNAME2.getText().toString());
                map.put("email",EMAIL2.getText().toString());
                map.put("address",ADDRESS2.getText().toString());
                return super.getParams();
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
        return email;
    }
}
