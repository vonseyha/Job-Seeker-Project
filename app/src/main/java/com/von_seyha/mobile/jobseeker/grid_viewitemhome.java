package com.von_seyha.mobile.jobseeker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.von_seyha.mobile.jobseeker.adapter.ViewTypeHomeAdapter;
import com.von_seyha.mobile.jobseeker.model.ViewTypeHomeModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class grid_viewitemhome extends AppCompatActivity {

    RecyclerView recyclerView_type_home;
    ViewTypeHomeAdapter adapter_type_home;
    ArrayList<ViewTypeHomeModel> list_type_home_Model;

    ImageView Employer_function,Seeker_function,job_want ;
    Button postjob;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_viewitemhome);
        recyclerView_type_home = findViewById(R.id.recyclerview_type_home);
        Employer_function = findViewById(R.id.employer_function);
        Seeker_function = findViewById(R.id.seeker_function);
        job_want = findViewById(R.id.go_jobwant);
        postjob = findViewById(R.id.btn_postjob);
        bottomNavigationView = findViewById(R.id.tab_button);

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

        Employer_function.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(),Login.class );
               startActivity(intent);
            }
        });

        Seeker_function.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

        job_want.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),activity_viewcvhome.class);
                startActivity(intent);
            }
        });
        postjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PostJob.class);
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
    }

    private RequestQueue mRequestQueue;
    @Override
    protected void onPostResume() {
        super.onPostResume();
        mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        jsonRequest("http://192.168.200.64:8000/api/postjob/read");
    }

    private void jsonRequest(String url)
    {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,url,null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try
                {
                    list_type_home_Model = new ArrayList<>();
                    for(int i=0 ; i<response.length(); i++){
                       JSONObject jsonObject = response.getJSONObject(i);
                        ViewTypeHomeModel model = new ViewTypeHomeModel();
                        //int a = jsonObject.getInt("Icon");
                        model.setImage_background(R.drawable.choosed);
                        model.setTitle(jsonObject.getString("Title"));
                        model.setTerm(jsonObject.getString("Term"));
                        model.setEmail(jsonObject.getString("Email"));
                        model.setPassword(jsonObject.getString("Phone"));
                        //Addmore
                        model.setRequirement(jsonObject.getString("Requirement"));
                        model.setExperience(jsonObject.getString("Experience"));
                        model.setLastdate(jsonObject.getString("Lastdate"));
                        model.setImage_button_show(R.drawable.rectanglee);
                        model.setShow_more("Show More");
                        list_type_home_Model.add(model);
                        Log.e("RESPONE DATA", model.toString());
                    }
                }catch (Exception e){
                    Log.e("Error Exception",e.toString());
                }
                recyclerView_type_home.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));
                adapter_type_home = new ViewTypeHomeAdapter(getApplicationContext(),list_type_home_Model);
                recyclerView_type_home.setAdapter(adapter_type_home);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("TESTING",error.getMessage());
            }
        });
        mRequestQueue.add(request);
    }
}
