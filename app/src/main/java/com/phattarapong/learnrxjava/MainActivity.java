package com.phattarapong.learnrxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycleView;
    private PlanetsAdapter planetsAdapter;
    private Disposable planetsSubScription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleView = findViewById(R.id.recycleView);
        recycleView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        planetsAdapter = new PlanetsAdapter();
        recycleView.setAdapter(planetsAdapter);

        if (savedInstanceState == null) {
            requestApi();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("CheckValue", "onStop");
        if (planetsSubScription != null && !planetsSubScription.isDisposed()) {
            Log.d("CheckValue", "Success");
            planetsSubScription.dispose();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CheckValue", "onDestroy");
        if (planetsSubScription != null && !planetsSubScription.isDisposed()) {
            Log.d("CheckValue", "Success");
            planetsSubScription.dispose();
        }
    }

    private void requestApi() {
        planetsSubScription = getPlanets()
                .doOnNext(planets -> planetsAdapter.addItem(planets.getResults(), MainActivity.this))
                .doOnError(throwable -> Log.d("MainActivity", throwable.getMessage()))
                .subscribe();
    }

    private Observable<Planets> getPlanets() {
        Observable<Planets> planetsObservable = HttpManager.getInstance().getService().getPlanets()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return planetsObservable;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }
}
