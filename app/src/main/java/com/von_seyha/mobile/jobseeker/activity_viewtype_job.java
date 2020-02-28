package com.von_seyha.mobile.jobseeker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.von_seyha.mobile.jobseeker.adapter.ViewTypeJobAdapter;
import com.von_seyha.mobile.jobseeker.model.ViewTypeJobModel;

import java.util.ArrayList;

public class activity_viewtype_job extends AppCompatActivity {

    RecyclerView recyclerView_type_job;
    ViewTypeJobAdapter adapter_type_job;
    ArrayList<ViewTypeJobModel> list_type_job_Model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewtype_job);
        recyclerView_type_job = findViewById(R.id.recyclerview_type_of_job);

        list_type_job_Model = new ArrayList<>();

        String[] Title = {
                "Mobile Developer",
                "Web Developer",
                "Accounting",
                "Digital Markating",
                "Teacher",
                "Project Management",
                "Designer",
                "Conteent Writing"
        };

        int [] Image = {
                R.drawable.mobile_background_icon,
                R.drawable.test_choicesa,
                R.drawable.web_choice_icon,
                R.drawable.test_choice,
                R.drawable.degital_marketing_choice,
                R.drawable.accounting_chioce,
                R.drawable.test_choicesa,
                R.drawable.test_choice

        };

        for (int i = 0 ; i < 8 ; i++ ){
            ViewTypeJobModel model = new ViewTypeJobModel();
            model.setImage_job(Image[i]);
            model.setTitle_job(Title[i]);
            list_type_job_Model.add(model);
        }

        recyclerView_type_job.setLayoutManager(new GridLayoutManager(this,2));
        adapter_type_job = new ViewTypeJobAdapter(this,list_type_job_Model);
        recyclerView_type_job.setAdapter(adapter_type_job);
    }
}
