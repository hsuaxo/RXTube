package com.hsuaxo.rxtube;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface YTService {

    @GET("search?part=snippet&maxResults=50")
    Single<YTResponse> search(@Query("type") String type, @Query("q") String searchText);
}
