package com.von_seyha.mobile.jobseeker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.von_seyha.mobile.jobseeker.adapter.ViewTypeCvHomeAdapter;
import com.von_seyha.mobile.jobseeker.model.ViewTypeCvHomeModel;

import java.util.ArrayList;

public class ShowTypecv extends AppCompatActivity {

    RecyclerView recyclerView_type_cv_home;
    ViewTypeCvHomeAdapter adapter_type_cv_home;
    ArrayList<ViewTypeCvHomeModel> listCvHomeModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_typecv);
        recyclerView_type_cv_home = findViewById(R.id.recyclerview_show_typecv);
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
                R.drawable.circle_profileg,
                R.drawable.circle_profilec,
                R.drawable.circle_profiled,
                R.drawable.circle_profilee,
                R.drawable.circle_profilef,
                R.drawable.circle_profileg,
                R.drawable.circle_profilei,
        };

        for (int i = 0 ; i < 8 ; i++ ){

            ViewTypeCvHomeModel model = new ViewTypeCvHomeModel();
            model.setProfile_cv_post( Image[i]);
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
}
