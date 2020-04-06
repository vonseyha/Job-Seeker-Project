package com.von_seyha.mobile.jobseeker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LongSummaryStatistics;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.widget.Toast.LENGTH_LONG;
import static com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.TIMEOUT;

public class PostJob extends AppCompatActivity implements View.OnClickListener {

    Button btn_back;
    TextView clk_post;

    ImageView profile_post_job;
    TextView uploade_photo_post_job;
    TextInputLayout companyname_post_job,
            term_post_job,
            title_post_job,
            requirement_post_job,
            experience_post_job,
            email_post_job,
            address_post_job,
            lastdate_post_job,
            phone_number_post_job;

    private final int IMG_REQUEST = 1;
    RequestQueue mRequestQueue;
    private Bitmap bitmap;
    String getId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_job);

        btn_back = findViewById(R.id.btn_back_post_job);
        clk_post = findViewById(R.id.btn_post_job );

        profile_post_job = findViewById(R.id.profile_post_job);
        uploade_photo_post_job = findViewById(R.id.uploade_photo_post_job);
        companyname_post_job = findViewById(R.id.companyname_post_job);
        term_post_job = findViewById(R.id.term_post_job);
        title_post_job = findViewById(R.id.title_post_job);
        requirement_post_job = findViewById(R.id.requirement_post_job);
        experience_post_job = findViewById(R.id.experience_post_job);
        email_post_job = findViewById(R.id.email_post_job);
        address_post_job = findViewById(R.id.address_post_job);
        lastdate_post_job = findViewById(R.id.lastdate_post_job);
        phone_number_post_job = findViewById(R.id.phone_number_post_job);

        uploade_photo_post_job.setOnClickListener(this);
        clk_post.setOnClickListener(this);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),grid_viewitemhome.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.uploade_photo_post_job:
                selectImage();
                break;
            case R.id.btn_post_job:
                String Companyname = companyname_post_job.getEditText().getText().toString().trim();
                String Term = term_post_job.getEditText().getText().toString().trim();
                String Title = title_post_job.getEditText().getText().toString().trim();
                String Requirement = requirement_post_job.getEditText().getText().toString().trim();
                String Experience = experience_post_job.getEditText().getText().toString().trim();
                String Email = email_post_job.getEditText().getText().toString().trim();
                String Address = address_post_job.getEditText().getText().toString().trim();
                String Lastdate = lastdate_post_job.getEditText().getText().toString().trim();
                String PhoneNumber = phone_number_post_job.getEditText().getText().toString().trim();
                if(TextUtils.isEmpty(Companyname)){
                    Toast.makeText(getApplicationContext(),"Name Company is Empty", LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(Term)){
                    Toast.makeText(getApplicationContext(),"Term is Empty", LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(Title)){
                    Toast.makeText(getApplicationContext(),"Name Company is Empty", LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(Requirement)){
                    Toast.makeText(getApplicationContext(),"Title is Empty", LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(Experience)){
                    Toast.makeText(getApplicationContext(),"Experience is Empty", LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(Email)){
                    Toast.makeText(getApplicationContext(),"Email is Empty", LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(Address)){
                    Toast.makeText(getApplicationContext(),"Address is Empty", LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(Lastdate)){
                    Toast.makeText(getApplicationContext(),"Lastdate is Empty", LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(PhoneNumber)){
                    Toast.makeText(getApplicationContext(),"PhoneNumber is Empty", LENGTH_LONG).show();
                }
                    mRequestQueue = Volley.newRequestQueue(getApplicationContext());
                    HashMap data = new HashMap();
                    data.put("CompanyName",Companyname);
                    data.put("Term",Term);
                    data.put("Title",Title);
                    data.put("Requirement",Requirement);
                    data.put("Experience",Experience);
                    data.put("Email",Email);
                    data.put("Address",Address);
                    data.put("Lastdate",Lastdate);
                    data.put("Phone",PhoneNumber);
                    //.put("Icon","ahsfdj");
                    data.put("Icon",getStringImage(bitmap));
                    Log.e("OOOOOOOOOO",data.toString());
                    String url = "http://192.168.43.210:8000/api/postjob/create";
                    uploadImge(url,data);
                    Toast.makeText(getApplicationContext(),"Post Success", LENGTH_LONG).show();
                break;
        }
    }

    private void selectImage(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent.createChooser(intent,"Select Picture"),IMG_REQUEST);
    }

    public void uploadImge(String url, HashMap data){
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == IMG_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            Uri path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),path);
                profile_post_job.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public String getStringImage(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,byteArrayOutputStream);
        byte[] imageByte = byteArrayOutputStream.toByteArray();
        String ecodeImage = Base64.encodeToString(imageByte,Base64.DEFAULT);
        return ecodeImage;
    }
}
