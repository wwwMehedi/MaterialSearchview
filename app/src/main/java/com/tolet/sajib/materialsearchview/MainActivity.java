package com.tolet.sajib.materialsearchview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;

import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.tolet.sajib.materialsearchview.adapter.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private List<String> countries;
    private RecyclerAdapter adapter;
    private Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toobarid);
        setSupportActionBar(toolbar);
        RecyclerView list = findViewById(R.id.list);



        populateCounties();
        list.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(countries, this);
        list.setAdapter(adapter);
        setupSearch();


    }

    private void setupSearch() {
        MaterialSearchView searchView=findViewById(R.id.searchview);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                processQuery(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {
                adapter.setCountries(countries);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        MaterialSearchView searchView=findViewById(R.id.searchview);
        searchView.setMenuItem(item);
        return true;
    }

    private void populateCounties() {
        countries = new ArrayList<>();
        countries.add("Afghanistan");
        countries.add("Albania");
        countries.add("Algeria");
        countries.add("dfhdf");
        countries.add("eyrtyrt");
        countries.add("gfjhfgj");
        countries.add("fgjfgjmn");
        countries.add("vbn");
        countries.add("vnjn");
        countries.add("vcng");
        countries.add("try");
        countries.add("jklhj");
        countries.add("tryh");
        countries.add("jgyj");
        countries.add("ytj");
    }
    private void processQuery(String query) {
        // in real app you'd have it instantiated just once
        ArrayList<String> result = new ArrayList<>();

        // case insensitive search
        for (String country : countries) {
            if (country.toLowerCase().contains(query.toLowerCase())) {
                result.add(country);
            }
        }

        adapter.setCountries(result);
    }


}
