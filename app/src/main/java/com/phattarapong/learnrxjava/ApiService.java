package com.phattarapong.learnrxjava;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Phattarapong on 10/9/2017.
 */

public interface ApiService {

    @GET("planets")
    Call<Planets> getPlanets();

}
