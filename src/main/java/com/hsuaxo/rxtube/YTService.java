package com.hsuaxo.rxtube;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface YTService {

    @GET("search?part=snippet")
    Single<YTResponse> search(@Query("type") String type, @Query("q") String searchText, @Query("maxResults") int maxRecords);
}
