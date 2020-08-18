package ru.melandra.viewy.presenter;

import javax.inject.Inject;

import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.melandra.viewy.app.App;
import ru.melandra.viewy.model.API.ApiService;
import ru.melandra.viewy.view.DetailView;

@InjectViewState
public class DetailPresenter extends MvpPresenter<DetailView> {

    @Inject
    ApiService apiService;

    @Override
    protected void onFirstViewAttach() {
        App.getAppComponent().inject(this);
    }

}
