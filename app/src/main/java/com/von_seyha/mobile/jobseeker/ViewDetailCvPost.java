package com.von_seyha.mobile.jobseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ViewDetailCvPost extends AppCompatActivity {

    WebView webView;
    ProgressBar progressBar;
    ImageView btn_back ;
    Button btn_goProfile;
    TextView name_seeker_profile , email_seeker_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detail_cv_post);

        webView = findViewById(R.id.webView);
        progressBar = findViewById(R.id.progressbar);
        btn_back = findViewById(R.id.row_back_detail_cv);
        btn_goProfile = findViewById(R.id.setting_img_detail_cv);
        name_seeker_profile = findViewById(R.id.name_seeker_profile);
        email_seeker_profile = findViewById(R.id.email_seeker_profile);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");

        name_seeker_profile.setText(name);
        email_seeker_profile.setText(email);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),GridViewCvHomeUser.class);
                startActivity(intent);
            }
        });
        btn_goProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name_seeker_profile.getText().toString();
                String Email = email_seeker_profile.getText().toString();
                Intent intent = new Intent(getApplicationContext(),SeekerProfile.class);
                intent.putExtra("Name",Name);
                intent.putExtra("Email",Email);
                startActivity(intent);
            }
        });

        progressBar.setVisibility(View.VISIBLE); //display the progessbar

        String pdf = "http://www.adobe.com/devnet/acrobat/pdfs/pdf_open_parameters.pdf";
        String finalUrl = "https://drive.google.com/viewerng/viewer?embedded=true&url="+ pdf;

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);

        webView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if(newProgress == 100){
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
        webView.loadUrl(finalUrl);
    }
}
