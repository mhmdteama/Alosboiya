package com.compubase.mhmd.alosboiya;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class SalesDetails extends AppCompatActivity {

    TextView dtitle , ddate , dsname,dlocation ,ddescripe,callnum ;
    ImageView share ;
    RecyclerView commentsRv;
    RecyclerView.Adapter salesitemcommentsAdapter;
    ArrayList<SallesCommentItems> commentsItems;
    RecyclerView.LayoutManager layoutManager;
    SliderLayout imgslider ;
    RecyclerView suggestRv ;
    RecyclerView.Adapter sugRvAdapter;
    ArrayList<SuggestionItems> suggestionItems;
    RequestQueue requestQueue;
    String URL;

    String title ,description,city,saller_name,saller_phone,datee,img1,img2,img3,img4,img5,img6,img7,img8,item_id ,user_country;


    String post_id;

    TinyDB tinyDB ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_details);
        /////////////////////////////////////////////////////////////////////////////////////////
        dtitle = findViewById(R.id.d_sales_title);
        ddate = findViewById(R.id.d_sales_date);
        dsname = findViewById(R.id.d_saller_name);
        dlocation =findViewById(R.id.d_sales_location);
        ddescripe = findViewById(R.id.d_sales_disc);
        callnum = findViewById(R.id.call_number);
        share= findViewById(R.id.share_sales);



        dtitle.setText(title);
        ddate.setText(datee);
        dsname.setText(saller_name);
        dlocation.setText(city);
        callnum.setText(saller_phone);
        ddescripe.setText(description);
        JSON_DATA_WEB_CALL();
/////////////////////////////////////////////////////////////////////////////////////////////////////
//        Bundle extras = getIntent().getExtras();








        /////////////////////////////////////////////////////////////////////////////////
        imgslider = findViewById(R.id.myslider);
        HashMap<String , Integer> myimages = new HashMap<>();
        myimages.put("first",R.drawable.omara);
        myimages.put("second" ,R.drawable.nokia);
        myimages.put("third0" ,R.drawable.car);
        for(String name : myimages.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(myimages.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);


            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            imgslider.addSlider(textSliderView);
        }
        ///////////////////////////////////////////////////////////////////////////////
        commentsRv = findViewById(R.id.sales_comments_rv);
        commentsRv.setHasFixedSize(true);
        commentsRv.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , true));
        salesitemcommentsAdapter = new SalesCommentAdapter(commentsItems);
        commentsItems = new ArrayList<SallesCommentItems>();
        commentsItems.add(new SallesCommentItems("7/7/2007","mhmd","رائع"));
        commentsItems.add(new SallesCommentItems("7/7/2007","mhmd","رائع"));
        commentsItems.add(new SallesCommentItems("7/7/2007","mhmd","رائع"));
        commentsItems.add(new SallesCommentItems("7/7/2007","mhmd","رائع"));
        salesitemcommentsAdapter = new SalesCommentAdapter(commentsItems);
        commentsRv.setAdapter(salesitemcommentsAdapter);
        commentsRv.stopScroll();
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        suggestRv = findViewById(R.id.sug_sales_Rv);
        suggestRv.setHasFixedSize(true);
        suggestRv.setLayoutManager(new GridLayoutManager(this,GridLayoutManager.chooseSize(4,2,2)));
        sugRvAdapter = new SugesstionAdapter(suggestionItems);
        suggestionItems = new ArrayList<SuggestionItems>();
        suggestionItems.add(new SuggestionItems(R.drawable.omara,"عمارة جديدة ممتازة جدا","مكة المكرمة"));
        suggestionItems.add(new SuggestionItems(R.drawable.nokia,"عمارة جديدة ممتازة جدا","مكة المكرمة"));
        suggestionItems.add(new SuggestionItems(R.drawable.omara,"عمارة جديدة ممتازة جدا","مكة المكرمة"));
        suggestionItems.add(new SuggestionItems(R.drawable.car,"عمارة جديدة ممتازة جدا","مكة المكرمة"));
        suggestionItems.add(new SuggestionItems(R.drawable.omara,"عمارة جديدة ممتازة جدا","مكة المكرمة"));
        sugRvAdapter =new SugesstionAdapter(suggestionItems);
        suggestRv.setAdapter(sugRvAdapter);
    }





    //////////////////////////////////////////////////////////////////////////////////////////////////////


    public void JSON_DATA_WEB_CALL(){
        String id;
        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("item_id");
        URL = "http://alosboiya.com.sa/webs.asmx/select_post_by_id?"+id;

        StringRequest stringRequest = new StringRequest(Request.Method.GET,URL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {



                        JSON_PARSE_DATA_AFTER_WEBCALL(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        showMessage("");


                    }
                }
        );

        requestQueue = Volley.newRequestQueue(getApplication());

        requestQueue.add(stringRequest);
    }

    public void JSON_PARSE_DATA_AFTER_WEBCALL(String Jobj){

        try {
            JSONArray js = new JSONArray(Jobj);

            for(int i = 0; i<js.length(); i++) {

                JSONObject details = js.getJSONObject(i);
                title = details.getString("Title");
                description = details.getString("Des");
                saller_name = details.getString("NameMember");
                saller_phone = details.getString("Phone");
                city = details.getString("City");
                datee = details.getString("datee");

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }



    private void showMessage(String s) {
        Toast.makeText(getApplicationContext(), "No Connection", Toast.LENGTH_LONG).show();
    }

}
