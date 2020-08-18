package ru.melandra.viewy.app;

import javax.inject.Singleton;

import dagger.Component;
import ru.melandra.viewy.model.API.ApiService;
import ru.melandra.viewy.presenter.DetailPresenter;
import ru.melandra.viewy.presenter.MainPresenter;

@Singleton
@Component (modules = {AppModule.class})
public interface AppComponent {
    void inject( MainPresenter mainPresenter);
    void inject( DetailPresenter detailPresenter);
    void inject( ApiService apiService);
}