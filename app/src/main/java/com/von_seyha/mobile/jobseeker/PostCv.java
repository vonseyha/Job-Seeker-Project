package com.von_seyha.mobile.jobseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PostCv extends AppCompatActivity {

    Button btn_back;
    TextView clk_post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_cv);

        btn_back = findViewById(R.id.btn_back_post_cv);
        clk_post = findViewById(R.id.btn_post_cv );

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),activity_viewcvhome.class);
                startActivity(intent);
            }
        });
        clk_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),activity_viewcvhome.class);
                startActivity(intent);
            }
        });

    }
}
