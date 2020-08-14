package ru.melandra.viewy.model;

import ru.melandra.viewy.Constants;

import static ru.melandra.viewy.Constants.DBG_TAG;

public class Model implements Constants {
    private int counter = 0;

    public void fixAction() {
        ++counter;
    }

    public int getCount() {
        return counter;
    }
}
