package com.von_seyha.mobile.jobseeker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.von_seyha.mobile.jobseeker.adapter.ViewTypeCvHomeAdapter;
import com.von_seyha.mobile.jobseeker.model.ViewTypeCvHomeModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class activity_viewcvhome extends AppCompatActivity {

    RecyclerView recyclerView_type_cv_home;
    ViewTypeCvHomeAdapter adapter_type_cv_home;
    ArrayList<ViewTypeCvHomeModel> listCvHomeModel;

    ImageView btn_back ;
    Button PostCv ;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcvhome);

        recyclerView_type_cv_home = findViewById(R.id.recyclerview_type_cv_home);
        btn_back = findViewById(R.id.button_back_in_home_list_cv);
        PostCv = findViewById(R.id.btn_postcv);

        bottomNavigationView = findViewById(R.id.tab_button);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),grid_viewitemhome.class);
                startActivity(intent);
            }
        });
        PostCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PostCv.class);
                startActivity(intent);
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_profile:
                        startActivity(new Intent(getApplicationContext(),activity_viewtype_job.class));
                        overridePendingTransition(0,0);
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

        listCvHomeModel = new ArrayList<>();
        String[][] Info = {
                {"Von Seyha", "Korn Sanit", "Try Chanty", "Soy Sin", "Meng Visal","Tang Eamseng","Seb Bunly","Poth Vothha"},
                {"Post: 10/12/2020","Post: 01/03/2020","Post: 11/02/2020","Post: 15/06/2020","Post: 10/12/2020","Post: 01/03/2020","Post: 11/02/2020","Post: 15/06/2020"},
                {"Mobile Developer", "Web Developer", "Accounting", "Digital Markating", "Teacher","Database","Accounting", "Digital Markating", "Teacher","Database",},
                {"2-3 Years","2-3 Years","2-3 Years","2-3 Years","2-3 Years","2-3 Years","2-3 Years","2-3 Years"},
                {"seyha@gmail.com","seyha1@gmail.com","seyha2@gmail.com","seyha3@gmail.com","seyha@gmail.com","seyha1@gmail.com","seyha2@gmail.com","seyha3@gmail.com"},
                {"0969840040/01245783","0969840040/01245783","0969840040/01245783","0969840040/01245783","0969840040/01245783","0969840040/01245783","0969840040/01245783","0969840040/01245783"},
        };

        int[] Image = {
                R.drawable.circle_profileb,
                R.drawable.circle_profilea,
                R.drawable.circle_profilec,
                R.drawable.circle_profiled,
                R.drawable.circle_profilee,
                R.drawable.circle_profilef,
                R.drawable.circle_profileg,
                R.drawable.circle_profilei,
        };

        for (int i = 0 ; i < 8 ; i++ ){
            ViewTypeCvHomeModel model = new ViewTypeCvHomeModel();
            model.setProfile_cv_post(Image[i]);
            model.setBtn_view(R.drawable.rectanglee);
            model.setName_cv_post(Info[0][i]);
            model.setLast_update_cv_post(Info[1][i]);
            model.setFunction_cv_home(Info[2][i]);
            model.setExperience_cv_home(Info[3][i]);
            model.setEmail_cv_home(Info[4][i]);
            model.setPassword_cv_home(Info[5][i]);
            model.setView_cv("View CV");
            listCvHomeModel.add(model);
        }

        recyclerView_type_cv_home.setLayoutManager(new GridLayoutManager(this,2));
        adapter_type_cv_home = new ViewTypeCvHomeAdapter(this ,listCvHomeModel );
        recyclerView_type_cv_home.setAdapter(adapter_type_cv_home);
    }

    private RequestQueue mRequestQueue;
    @Override
    protected void onPostResume() {
        super.onPostResume();
        mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        jsonRequest("http://192.168.43.210:8000/api/postcv/read");
    }

    private void jsonRequest(String url)
    {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,url,null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try
                {
                    int[] Image = {
                            R.drawable.circle_profileb,
                            R.drawable.circle_profilea,
                            R.drawable.circle_profilec,
                            R.drawable.circle_profiled,
                            R.drawable.circle_profilee,
                            R.drawable.circle_profilef,
                            R.drawable.circle_profileg,
                            R.drawable.circle_profilei,
                    };
                    listCvHomeModel = new ArrayList<>();
                    for(int i=0 ; i<response.length(); i++){
                        JSONObject jsonObject = response.getJSONObject(i);
                        ViewTypeCvHomeModel model = new ViewTypeCvHomeModel();
                        //int a = jsonObject.getInt("Icon");
                        model.setProfile_cv_post(Image[i]);
                        model.setName_cv_post(jsonObject.getString("Fullname"));
                        model.setLast_update_cv_post(jsonObject.getString("Lastdate"));
                        model.setFunction_cv_home(jsonObject.getString("Interest"));
                        model.setExperience_cv_home(jsonObject.getString("Experience"));
                        model.setEmail_cv_home(jsonObject.getString("Email"));
                        model.setPassword_cv_home(jsonObject.getString("Language"));
                        model.setView_cv("View CV");
                        model.setBtn_view(R.drawable.rectanglee);
                        listCvHomeModel.add(model);
                        Log.e("RESPONE DATA", model.toString());
                    }
                }catch (Exception e){
                    Log.e("Error Exception",e.toString());
                }
                recyclerView_type_cv_home.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
                adapter_type_cv_home = new ViewTypeCvHomeAdapter(getApplicationContext(),listCvHomeModel);
                recyclerView_type_cv_home.setAdapter(adapter_type_cv_home);
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

