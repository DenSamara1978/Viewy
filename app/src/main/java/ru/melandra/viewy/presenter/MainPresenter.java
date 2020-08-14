package ru.melandra.viewy.presenter;

import ru.melandra.viewy.Constants;
import ru.melandra.viewy.model.Model;
import ru.melandra.viewy.view.MainView;

public class MainPresenter implements Constants {

    private Model model;
    private MainView mainView;

    public MainPresenter(MainView mainView){
        this.mainView = mainView;
        this.model = new Model();
    }

    public void onClickImage(){
        model.fixAction();
        mainView.showCount(model.getCount());
    }
}
