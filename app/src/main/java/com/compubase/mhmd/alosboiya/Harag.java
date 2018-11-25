package com.compubase.mhmd.alosboiya;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Harag extends AppCompatActivity {
    RecyclerView rvitems , sallesrv ;
    RecyclerView.Adapter rvadapter;
    ArrayList<ItemList> itemLists ;


    RecyclerView.LayoutManager rvLayoutManager;
    RecyclerView.Adapter salleslistAdapter;
    ArrayList<SalesItems> salesitems;

    ImageButton adde ;
    Button allcity ;

    String URL = "http://alosboiya.com.sa/webs.asmx/select_haraj?";
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harag);
        adde = findViewById(R.id.addee);
/*

*/
        /////////////////////////////////////////////////////////////////////////////////////////////////////////



        rvitems = findViewById(R.id.items_tyeps);
        rvitems.setHasFixedSize(true);
        //rvLayoutManager =new LinearLayoutManager(this);
        rvitems.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , true));
        rvadapter = new IteamListAdapter(itemLists);
        itemLists = new ArrayList<ItemList>();
        itemLists.add(new ItemList(R.drawable.akarat));
        itemLists.add(new ItemList(R.drawable.cars));
        itemLists.add(new ItemList(R.drawable.devices));
        itemLists.add(new ItemList(R.drawable.athath));
        itemLists.add(new ItemList(R.drawable.service));
        itemLists.add(new ItemList(R.drawable.clothes));
        itemLists.add(new ItemList(R.drawable.animals));
        itemLists.add(new ItemList(R.drawable.monsf));
        rvadapter = new IteamListAdapter(itemLists);
        rvitems.setAdapter(rvadapter);



        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        sallesrv = findViewById(R.id.sales_list);
        sallesrv.setHasFixedSize(false);
        sallesrv.setLayoutManager(new LinearLayoutManager(this ,LinearLayoutManager.VERTICAL, true));
        salleslistAdapter = new SalesAdapter(salesitems);
        JSON_DATA_WEB_CALL();

        salesitems = new ArrayList<SalesItems>();
        salleslistAdapter = new SalesAdapter(salesitems);
        sallesrv.setAdapter(salleslistAdapter);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        adde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Harag.this ,AddSales.class );
                startActivity(intent);
            }
        });
        //////////////////////////////////////////////////////////////////////////////

        allcity =findViewById(R.id.all_city);
        allcity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Harag.this , SalesDetails.class);
                startActivity(intent);

            }
        });
    }



////////////////////////////////////////////////////////////////////////
public void JSON_DATA_WEB_CALL(){

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


    requestQueue = Volley.newRequestQueue(this);

    requestQueue.add(stringRequest);
}

    public void JSON_PARSE_DATA_AFTER_WEBCALL(String Jobj) {

        try {
            JSONArray js = new JSONArray(Jobj);

            for (int i = 0; i < js.length(); i++) {

                final JSONObject childJSONObject = js.getJSONObject(i);

                SalesItems oursales = new SalesItems();


                if (childJSONObject.getString("Image") != null) {

                    if (childJSONObject.getString("Image").contains("~")) {
                        String replaced = childJSONObject.getString("Image").replace("~", "");
                        String finalstring = "http://alosboiya.com.sa" + replaced;
                        oursales.setSellseimage(finalstring);

                    } else {
                        oursales.setSellseimage(childJSONObject.getString("Image"));
                    }

                } else {
                    oursales.setSellseimage("Images/imageposting.png");

                }


                oursales.setLocation(childJSONObject.getString("City"));

                oursales.setSalesdate(childJSONObject.getString("datee"));

                oursales.setSalesname(childJSONObject.getString("Title"));

                oursales.setSallername(childJSONObject.getString("NameMember"));

                //oursales.setSellseimage(childJSONObject.getString("Image"));

                salesitems.add(oursales);


                String item_id ;
                item_id = childJSONObject.getString("Id");



            }

            salleslistAdapter = new SalesAdapter(salesitems);
            sallesrv.setAdapter(salleslistAdapter);

            salleslistAdapter.notifyDataSetChanged();




        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////






    private void showMessage( String s) {
        Toast.makeText(getApplicationContext(), "No Connection", Toast.LENGTH_LONG).show();
    }


}
