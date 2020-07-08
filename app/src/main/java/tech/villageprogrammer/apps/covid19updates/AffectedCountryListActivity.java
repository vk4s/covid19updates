package tech.villageprogrammer.apps.covid19updates;
import tech.villageprogrammer.apps.covid19updates.adapters.CountryDetailsAdapter;
import tech.villageprogrammer.apps.covid19updates.models.CountryModel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AffectedCountryListActivity extends AppCompatActivity {
    EditText searchCountry;
    ListView searchedCountryList;
    SimpleArcLoader searchLoader;

    public static List<CountryModel> countryModelList = new ArrayList<>();
    CountryModel countryModel;
    CountryDetailsAdapter countryDetailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);

        searchCountry = findViewById(R.id.searchCountry);
        searchedCountryList = findViewById(R.id.searchedCountries);
        searchLoader = findViewById(R.id.searchLoader);

        getSupportActionBar().setTitle("Affected Countries");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        fetchData();
        searchedCountryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(),CountryDetailActivity.class)
                        .putExtra("position",position));
            }
        });

        searchCountry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                countryDetailsAdapter.getFilter().filter(s);
                countryDetailsAdapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void fetchData() {

        String url  = "https://corona.lmao.ninja/v2/countries/";

        searchLoader.start();

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for(int i=0; i<jsonArray.length(); i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String countryName = jsonObject.getString("country");
                                String cases = jsonObject.getString("cases");
                                String todayCases = jsonObject.getString("todayCases");
                                String deaths = jsonObject.getString("deaths");
                                String todayDeaths = jsonObject.getString("todayDeaths");
                                String recovered = jsonObject.getString("recovered");
                                String todayRecovered = jsonObject.getString("todayRecovered");
                                String active = jsonObject.getString("active");
                                String critical = jsonObject.getString("critical");
                                String continent = jsonObject.getString("continent");
                                String casesPerMillion = jsonObject.getString("casesPerOneMillion");

                                JSONObject jsonObjectC = jsonObject.getJSONObject("countryInfo");
                                String flag = jsonObjectC.getString("flag");

                                countryModel = new CountryModel(flag, countryName, cases,
                                        todayCases, deaths, todayDeaths, recovered,todayRecovered,
                                        active, critical, continent,casesPerMillion );
                                countryModelList.add(countryModel);

                            } // out of for(...)
                            countryDetailsAdapter = new CountryDetailsAdapter(AffectedCountryListActivity.this,countryModelList);
                            searchedCountryList.setAdapter(countryDetailsAdapter);
                            searchLoader.stop();
                            searchLoader.setVisibility(View.GONE);
                        } catch (JSONException e) {
                            searchLoader.stop();
                            searchLoader.setVisibility(View.GONE);
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(AffectedCountryListActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}