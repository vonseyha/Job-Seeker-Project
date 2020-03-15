package com.von_seyha.mobile.jobseeker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.von_seyha.mobile.jobseeker.adapter.ViewTypeCvAdapter;
import com.von_seyha.mobile.jobseeker.adapter.ViewTypeJobAdapter;
import com.von_seyha.mobile.jobseeker.model.ViewTypeCvModel;
import com.von_seyha.mobile.jobseeker.model.ViewTypeJobModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Button btn_goApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_goApp = findViewById(R.id.btn_start);
        btn_goApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),grid_viewitemhome.class);
                startActivity(intent);
            }
        });
    }
}
