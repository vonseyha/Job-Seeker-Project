package com.von_seyha.mobile.jobseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static android.widget.Toast.LENGTH_LONG;

public class EditProfileEmployer extends AppCompatActivity {

    Button btn_back_edit_profile_employer , take_photo_edit_profile_employer;
    TextView name_edit_employer_profile , address_edit_emloyer_profile;
    EditText fill_name_edit_emloyer_profile , fill_email_edit_emloyer_profile , fill_address_edit_emloyer_profile;
    Button btn_edit_emloyer_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_employer);

        btn_back_edit_profile_employer = findViewById(R.id.btn_back_edit_profile_employer);
        take_photo_edit_profile_employer  = findViewById(R.id.take_photo_edit_profile_employer);
        name_edit_employer_profile = findViewById(R.id.name_edit_employer_profile);
        address_edit_emloyer_profile = findViewById(R.id.address_edit_emloyer_profile);
        fill_name_edit_emloyer_profile = findViewById(R.id.fill_name_edit_emloyer_profile);
        fill_email_edit_emloyer_profile = findViewById(R.id.fill_email_edit_emloyer_profile);
        fill_address_edit_emloyer_profile = findViewById(R.id.fill_address_edit_emloyer_profile);
        btn_edit_emloyer_profile = findViewById(R.id.btn_edit_emloyer_profile);

        btn_back_edit_profile_employer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        btn_edit_emloyer_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_edit_employer_profile.setText("Von Seyha");
                String Name = name_edit_employer_profile.getText().toString();
                String Email = fill_email_edit_emloyer_profile.getText().toString();
                String Address = fill_address_edit_emloyer_profile.getText().toString();

                if (TextUtils.isEmpty(Name)){
                    Toast.makeText(getApplicationContext(),"Name is empty",Toast.LENGTH_LONG).show();
                }
                else if (TextUtils.isEmpty(Email)){
                    Toast.makeText(getApplicationContext(),"Email is empty",Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(Address)){
                    Toast.makeText(getApplicationContext(),"Address is empty",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
                    parseJSON("Von Seyha");
                    name_edit_employer_profile.setText("");
                    fill_email_edit_emloyer_profile.setText("");
                    fill_address_edit_emloyer_profile.setText("");
                }
            }
        });
    }

    public String parseJSON(final String username){
        String url = "http://192.168.43.210:8000/api/user/update/"+username;
        StringRequest request = new StringRequest(Request.Method.POST,url, new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    if(success.equals("1")){
                        Toast.makeText(getApplicationContext(),"Hello You are editor",LENGTH_LONG).show();
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
                String Name = name_edit_employer_profile.getText().toString();
                String Email = fill_email_edit_emloyer_profile.getText().toString();
                String Address = fill_address_edit_emloyer_profile.getText().toString();
                map.put("username",Name);
                map.put("email",Email);
                map.put("address",Address);
                return super.getParams();
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
        return username;
    }
}
