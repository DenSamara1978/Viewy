package ru.melandra.viewy.app;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.melandra.viewy.model.API.ApiService;
import ru.melandra.viewy.model.Model;

@Module
class AppModule {

    private final Application application;

    AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    ApiService provideApiService() {
        return new ApiService ();
    }

    @Singleton
    @Provides
    Model provideModel() {
        return new Model ();
    }

    @Singleton
    @Provides
    Gson provideGson() {
        return new GsonBuilder ()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }
}