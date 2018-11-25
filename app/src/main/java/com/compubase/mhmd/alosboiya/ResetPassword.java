package com.compubase.mhmd.alosboiya;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ResetPassword extends AppCompatActivity {
    Button restpass;
    EditText restemail;
    String GET_JSON_DATA_HTTP_URL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        restemail = findViewById(R.id.reset_email);
        restpass =findViewById(R.id.reset_pass);



        restpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    private void volleyConnection()
    {
        GET_JSON_DATA_HTTP_URL = "http://alosboiya.com.sa /webs.asmx/return_password?";
        // http://atlas.alosboiya.com.sa/atlas.asmx?op=login_campany

        StringRequest stringRequest = new StringRequest(Request.Method.POST, GET_JSON_DATA_HTTP_URL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showMessage(response);
                        if (Objects.equals(response, "False"))
                        {

                            showMessage("Invalid email ");

                        }else {
                            Intent intent = new Intent(ResetPassword.this,Login.class);
                            startActivity(intent);
                            // tinyDB.putString("userID",response);
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
                params.put("email", restemail.getText().toString());

                return params;
            }



        };

        RequestHandler.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }
    private void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_LONG).show();
    }
}
