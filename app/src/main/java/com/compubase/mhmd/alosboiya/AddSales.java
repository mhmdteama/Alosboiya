package com.compubase.mhmd.alosboiya;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AddSales extends AppCompatActivity {
    private static final String[] elmadena ={"الرياض" ,"مكة المكرمة" ,  "الدمام",
            "المدينة المنورة","جدة"};
    Spinner add_madena;
    TinyDB tinyDB;
    final int PICK_IMAGE_REQUEST = 71;
    FirebaseStorage storage;
    StorageReference storageReference;
    Button add_post;
    String user_id ,GET_JSON_DATA_HTTP_URL;
    EditText title,pic,department,phone,desc;
    String pic1;
    Uri filePath;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sales);

        title =findViewById(R.id.add_title);
        pic =findViewById(R.id.add_imgs);
        department =findViewById(R.id.add_depart);
        phone =findViewById(R.id.add_phone);
        desc =findViewById(R.id.add_desc);

        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPicturDialog();
            }
        });

        add_post = findViewById(R.id.add_post);
        add_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volleyConnection();
            }
        });



        elmadenaSpiner();
        tinyDB =new TinyDB(getApplicationContext());
        user_id = tinyDB.getString("user_id");



    }


    private   void  showPicturDialog()
    {
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle("Select Action");
        String[] pictureDlialogItem={"Select From Gallery" ,
                "Capture From Camera"};
        pictureDialog.setItems(pictureDlialogItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0 :
                        choosePhotoFromGallary();
                        break;
                    case 1:
                        takePhotoFromCamera();
                        break;
                }
            }
        });
        pictureDialog.show();
    }

    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent,71);
    }
    private void takePhotoFromCamera() {

        //From Camera

        Intent pictureIntent = new Intent(
                MediaStore.ACTION_IMAGE_CAPTURE
        );
        if(pictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(pictureIntent,
                    PICK_IMAGE_REQUEST);
        }

    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
private void uploadImage(Uri customfilepath) {

    if(customfilepath != null)
    {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading...");
        progressDialog.show();

        StorageReference ref = storageReference.child("images/"+ UUID.randomUUID().toString());
        ref.putFile(customfilepath)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        progressDialog.dismiss();
                        Toast.makeText(AddSales.this, "Uploaded", Toast.LENGTH_SHORT).show();
                        Uri downloadUrl = taskSnapshot.getUploadSessionUri(); //getDownloadUrl not found
                        assert downloadUrl != null;
                        if(pic1.isEmpty() )
                        {
                            pic1 = downloadUrl.toString();
                            showMessage(pic1);
                        }


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(AddSales.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                        double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                .getTotalByteCount());
                        progressDialog.setMessage("Uploaded "+(int)progress+"%");
                    }
                });
    }
}
*/

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

 /*   @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if((requestCode == PICK_IMAGE_REQUEST) && (resultCode == RESULT_OK)
                && (data != null) && (data.getData() != null))
        {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                if(pic1.isEmpty() )
                {
                    uploadImage(filePath);
                }

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }*/


/////////////////////////////////////////////////////////////////////////////////////////////////////

    public void volleyConnection()
    {
        GET_JSON_DATA_HTTP_URL = "http://alosboiya.com.sa/webs.asmx/register?";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, GET_JSON_DATA_HTTP_URL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showMessage(response);
                        if(Objects.equals(response, "True")){
                            showMessage("your post added Successful");







                        }else {
                            showMessage("Failed pleas Try Again ");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                showMessage(error.toString());

            }
        }) {

            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<>();
                params.put("title", title.getText().toString());
                params.put("tel", phone.getText().toString());
                params.put("password", pic.getText().toString());
                params.put("phone", add_madena.getSelectedItem().toString());
                params.put("des", desc.getText().toString());
                params.put("category", department.getText().toString());


                return params;
            }



        };

        RequestHandler.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }
    private void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_LONG).show();
    }











    public void elmadenaSpiner()
    {
        add_madena = findViewById(R.id.add_madena);
        ArrayAdapter<String> add_madenaAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item, elmadena);
        add_madenaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        add_madena.setAdapter(add_madenaAdapter);
    }
}
