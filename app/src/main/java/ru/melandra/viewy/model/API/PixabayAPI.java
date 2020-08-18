package ru.melandra.viewy.model.API;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PixabayAPI
{
    @GET ("api")
    Observable< Hits > loadHits( @Query ("key") String key);
}
