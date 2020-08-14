package ru.melandra.viewy.presenter;

import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.melandra.viewy.Constants;
import ru.melandra.viewy.model.Model;
import ru.melandra.viewy.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> implements Constants {

    private Model model;

    public MainPresenter(){
        this.model = new Model();
    }

    public void onClickImage(){
        model.fixAction();
        getViewState().showCount(model.getCount());
    }
}
