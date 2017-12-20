package com.phattarapong.learnrxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    public static final String SAVE_PLANERS = "save_planets";

    private RecyclerView recycleView;
    private PlanetsAdapter planetsAdapter;
    private Planets planets;
    private Disposable planetsDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleView = (RecyclerView) findViewById(R.id.recycleView);
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
        if (planetsDisposable != null && !planetsDisposable.isDisposed()) {
            planetsDisposable.dispose();
        }
    }

    private void requestApi() {
        planetsDisposable = getPlanets()
                .doOnNext(planets -> {
                    planetsAdapter.addItem(planets.getResults(), MainActivity.this);
                    this.planets = planets;
                })
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
        outState.putParcelable(SAVE_PLANERS, planets);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        planets = savedInstanceState.getParcelable(SAVE_PLANERS);
        planetsAdapter.addItem(planets.getResults(), MainActivity.this);
    }

}
