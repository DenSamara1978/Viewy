package ru.melandra.viewy;

public class MainPresenter implements Constants {
    private Model model;

    public MainPresenter(){
        model = new Model();
    }

    public void onClickImage(){
        model.fixAction();
    }
}
