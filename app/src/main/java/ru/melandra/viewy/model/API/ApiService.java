package ru.melandra.viewy.model.API;

import com.google.gson.Gson;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.*;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.melandra.viewy.app.App;

public class ApiService
{
    @Inject
    Gson gson;

    public Observable< Hits > requestServer() {
        App.getAppComponent().inject(this);
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);
        PixabayAPI api = new Retrofit.Builder()
                .baseUrl("https://pixabay.com/")
                .addCallAdapterFactory( RxJava2CallAdapterFactory.create())
                .addConverterFactory(gsonConverterFactory)
                .build()
                .create(PixabayAPI.class);

        return api.loadHits ( "17950388-57612c3563642601dba59688d" ).subscribeOn( Schedulers.io());
    }
}
