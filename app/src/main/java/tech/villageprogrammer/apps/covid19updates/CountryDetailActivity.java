package tech.villageprogrammer.apps.covid19updates;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CountryDetailActivity extends AppCompatActivity {
    private int countryPostionInDataList;
    TextView tvCountryName,tvCases,tvRecovered,tvTodayRecovered, tvCritical,tvActive,tvTodayCases,
            tvTotalDeaths,tvTodayDeaths, tvContinent, tvCasesPerMillion;
    ImageView flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        Intent intent = getIntent();
        countryPostionInDataList = intent.getIntExtra("position",0);

        getSupportActionBar().setTitle("Country Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tvCountryName = findViewById(R.id.tvDCountryName);
        tvCases = findViewById(R.id.tvDCases);
        tvRecovered = findViewById(R.id.tvDRecovered);
        tvCritical = findViewById(R.id.tvDCritical);
        tvActive = findViewById(R.id.tvDActive);
        tvTodayCases = findViewById(R.id.tvDTodayCases);
        tvTotalDeaths = findViewById(R.id.tvDDeaths);
        tvTodayDeaths = findViewById(R.id.tvDTodayDeaths);
        tvTodayRecovered = findViewById(R.id.tvDTodayRecovered);
        tvContinent = findViewById(R.id.tvDContinent);
        tvCasesPerMillion = findViewById(R.id.casesPerMillionD);
        flag = findViewById(R.id.countryFlagD);

        Glide.with(getApplicationContext()).load(AffectedCountryListActivity.countryModelList.get(countryPostionInDataList)
                .getFlag()).into(flag);
        tvCountryName.setText(AffectedCountryListActivity.countryModelList.get(countryPostionInDataList).getCountryName());
        tvCases.setText(AffectedCountryListActivity.countryModelList.get(countryPostionInDataList).getCases());
        tvRecovered.setText(AffectedCountryListActivity.countryModelList.get(countryPostionInDataList).getRecovered());
        tvCritical.setText(AffectedCountryListActivity.countryModelList.get(countryPostionInDataList).getCritical());
        tvActive.setText(AffectedCountryListActivity.countryModelList.get(countryPostionInDataList).getActive());
        tvTodayCases.setText(AffectedCountryListActivity.countryModelList.get(countryPostionInDataList).getTodayCases());
        tvTotalDeaths.setText(AffectedCountryListActivity.countryModelList.get(countryPostionInDataList).getDeaths());
        tvTodayDeaths.setText(AffectedCountryListActivity.countryModelList.get(countryPostionInDataList).getTodayDeaths());
        tvTodayRecovered.setText(AffectedCountryListActivity.countryModelList.get(countryPostionInDataList).getTodayRecovered());
        tvContinent.setText(AffectedCountryListActivity.countryModelList.get(countryPostionInDataList).getContinent());
        tvCasesPerMillion.setText(AffectedCountryListActivity.countryModelList.get(countryPostionInDataList).getCasesPerMillion());

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}