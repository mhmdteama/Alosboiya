package com.compubase.mhmd.alosboiya;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Login extends AppCompatActivity {
    String GET_JSON_DATA_HTTP_URL;
    TinyDB tinyDB ;
    Button do5ol;
    EditText logemail , logpass ;
    TextView forgetpass ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        do5ol =findViewById(R.id.do5oool);
        logemail = findViewById(R.id.login_email);
        logpass = findViewById(R.id.login_pass);
        tinyDB = new TinyDB(getApplicationContext());
        forgetpass = findViewById(R.id.forget_pass);


        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this ,ResetPassword.class);
                startActivity(intent);
            }
        });



        do5ol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volleyConnection();
            }
        });

    }



    private void volleyConnection()
    {
        GET_JSON_DATA_HTTP_URL = "http://alosboiya.com.sa/webs.asmx/login?";
        // http://atlas.alosboiya.com.sa/atlas.asmx?op=login_campany

        StringRequest stringRequest = new StringRequest(Request.Method.POST, GET_JSON_DATA_HTTP_URL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showMessage(response);
                        if (Objects.equals(response, "False"))
                        {

                            showMessage("Invalid email or password ");

                        }
                        else
                        {
                            Intent intent = new Intent(Login.this , MyAccount.class);
                            startActivity(intent);
                            try {
                                JSONObject userdate = new JSONObject(response);

                                String user_id =  userdate.getString("Id");
                                String user_name =  userdate.getString("Name");
                                String user_email =  userdate.getString("Email");
                                String user_pass =  userdate.getString("Password");
                                String user_phone=  userdate.getString("Phone");
                                String user_country =  userdate.getString("Country");
                                String user_city =  userdate.getString("City");
                                String user_url =  userdate.getString("URL");
                                String user_img =  userdate.getString("ImageProfile");
                                String user_balance =  userdate.getString("Balance");

                                tinyDB.putString("user_id",user_id);
                                tinyDB.putString("user_name",user_name);
                                tinyDB.putString("user_email",user_email);
                                tinyDB.putString("user_pass",user_pass);
                                tinyDB.putString("user_phone",user_phone);
                                tinyDB.putString("user_country",user_country);
                                tinyDB.putString("user_city",user_city);
                                tinyDB.putString("user_url",user_url);
                                tinyDB.putString("user_img",user_img);
                                tinyDB.putString("user_balance",user_balance);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


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
                params.put("email", logemail.getText().toString());
                params.put("password", logpass.getText().toString());

                return params;
            }



        };

        RequestHandler.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }
    private void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_LONG).show();
    }
}
