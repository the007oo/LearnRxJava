package com.phattarapong.learnrxjava;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Phattarapong on 10/9/2017.
 */

public interface ApiService {

    @GET("planets")
    Observable<Planets> getPlanets();

}
