package com.von_seyha.mobile.jobseeker;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static android.widget.Toast.LENGTH_LONG;

public class PostCv extends AppCompatActivity implements View.OnClickListener {

    Button btn_back;
    TextView clk_post;
    ImageView profile_image_post_cv;
    TextView uploade_photo_post_cv;
    TextInputLayout  name_post_cv,
                    email_post_cv,
                    interest_post_cv,
                    experience_post_cv,
                    language_post_cv,
                    lastupdate_post_cv;
    Button uploade_pdf_post_cv;
    Bitmap bitmap ;
    WebView webView_postcv;
    private final int IMG_REQUEST = 1;
    private final int REQUESTCODE_PICK_Pdf=1;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_cv);

        btn_back = findViewById(R.id.btn_back_post_cv);
        clk_post = findViewById(R.id.btn_post_cv );
        profile_image_post_cv = findViewById(R.id.profile_image_post_cv);
        uploade_photo_post_cv = findViewById(R.id.uploade_photo_post_cv);
        name_post_cv = findViewById(R.id.name_post_cv);
        email_post_cv = findViewById(R.id.email_post_cv);
        interest_post_cv = findViewById(R.id.interest_post_cv);
        experience_post_cv = findViewById(R.id.experience_post_cv);
        lastupdate_post_cv = findViewById(R.id.lastupdate_post_cv);
        uploade_pdf_post_cv = findViewById(R.id.uploade_pdf_post_cv);
        language_post_cv = findViewById(R.id.language_post_cv);
        webView_postcv = findViewById(R.id.webView_postcv);

        clk_post.setOnClickListener(this);
        uploade_photo_post_cv.setOnClickListener(this);
        uploade_pdf_post_cv.setOnClickListener(this);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),activity_viewcvhome.class);
                startActivity(intent);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.uploade_photo_post_cv:
                selectImage();
                Toast.makeText(getApplicationContext(),"asdfasf", LENGTH_LONG).show();
                break;
            case R.id.btn_post_cv:
                String Fullname = name_post_cv.getEditText().getText().toString();
                String Email = email_post_cv.getEditText().getText().toString();
                String Interest = interest_post_cv.getEditText().getText().toString();
                String Experience = experience_post_cv.getEditText().getText().toString();
                String lastdate = lastupdate_post_cv.getEditText().getText().toString();
                String Address = email_post_cv.getEditText().getText().toString();
                String Language = language_post_cv.getEditText().getText().toString();
                if(TextUtils.isEmpty(Fullname)){
                    Toast.makeText(getApplicationContext(),"Fullname is Empty", LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(Email)){
                    Toast.makeText(getApplicationContext(),"Email is Empty", LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(Interest)){
                    Toast.makeText(getApplicationContext(),"Interest is Empty", LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(Experience)){
                    Toast.makeText(getApplicationContext(),"Experience is Empty", LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(lastdate)){
                    Toast.makeText(getApplicationContext(),"Last Date is Empty", LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(lastdate)){
                    Toast.makeText(getApplicationContext(),"Last Date is Empty", LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(Language)){
                    Toast.makeText(getApplicationContext(),"Language is Empty", LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(Address)){
                    Toast.makeText(getApplicationContext(),"Address is Empty", LENGTH_LONG).show();
                }
                else{
                    uploadImge();
                    Toast.makeText(getApplicationContext(),"Post Success", LENGTH_LONG).show();
                }
                break;
            case R.id.uploade_pdf_post_cv:
                openFile(uri);
                break;
        }
    }

    private void selectImage(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,IMG_REQUEST);
    }
    private void openFile(Uri pickerInitialUri) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("application/pdf");
        intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI, pickerInitialUri);
        startActivityForResult(intent, REQUESTCODE_PICK_Pdf);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Pick Image
        if (requestCode == IMG_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                profile_image_post_cv.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        if (requestCode == REQUESTCODE_PICK_Pdf) {
            Uri selectedPdf = data.getData();
            webView_postcv.setVisibility(View.VISIBLE);
            if (data != null) {
                selectedPdf = data.getData();
                System.out.println("Uri of selected pdf---->" + selectedPdf.toString());
            }
        }
    }

    private void uploadImge(){
        String url = "http://192.168.200.62:8000/api/postjob/create";
        StringRequest request = new StringRequest(Request.Method.POST,url, new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    if(success.equals("1")){
                        Toast.makeText(getApplicationContext(),"Success", LENGTH_LONG).show();
                        profile_image_post_cv.setImageResource(0);
                        profile_image_post_cv.setVisibility(View.GONE);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Not Success", LENGTH_LONG).show();
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
                Map<String,String> data = new HashMap<>();

                String Fullname = name_post_cv.getEditText().getText().toString();
                String Email = email_post_cv.getEditText().getText().toString();
                String Interest = interest_post_cv.getEditText().getText().toString();
                String Experience = experience_post_cv.getEditText().getText().toString();
                String lastdate = lastupdate_post_cv.getEditText().getText().toString();
                String Address = email_post_cv.getEditText().getText().toString();
                String Language = language_post_cv.getEditText().getText().toString();

                data.put("Fullname",Fullname);
                data.put("Email",Email);
                data.put("Address",Address);
                data.put("Interest",Interest);
                data.put("Experience",Experience);
                data.put("Language",Language);
                data.put("Lastdate",lastdate);
                //data.put("Demo_File",getBitmapFromUri(uri));
                data.put("Icon",imageToString(bitmap));
                Log.e("OOOOOOOOOO",data.toString());
                return super.getParams();
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    private String imageToString(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,byteArrayOutputStream);
        byte[] imageByte = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imageByte,Base64.DEFAULT);
    }


}
