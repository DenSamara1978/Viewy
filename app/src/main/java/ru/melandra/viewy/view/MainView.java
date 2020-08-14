package ru.melandra.viewy.view;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface MainView extends MvpView {

    @StateStrategyType(value = AddToEndSingleStrategy.class)
    void showCount(int count);
}
