package com.phattarapong.learnrxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recycleView;
    private PlanetsAdapter planetsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleView = (RecyclerView) findViewById(R.id.recycleView);
        recycleView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        planetsAdapter = new PlanetsAdapter();
        recycleView.setAdapter(planetsAdapter);

        

        HttpManager.getInstance().getService().getPlanets().enqueue(new Callback<Planets>() {
            @Override
            public void onResponse(Call<Planets> call, Response<Planets> response) {
                if (response != null) {
                    List<Planets.ResultsBean> planetsList = response.body().getResults();
                    planetsAdapter.addItem(planetsList, MainActivity.this);
                }
            }

            @Override
            public void onFailure(Call<Planets> call, Throwable t) {

            }
        });

    }

}
