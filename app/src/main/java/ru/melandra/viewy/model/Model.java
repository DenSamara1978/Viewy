package ru.melandra.viewy.model;

import ru.melandra.viewy.Constants;

public class Model implements Constants {
    private int counter = 0;

    public void fixAction() {
        ++counter;
    }

    public int getCount() {
        return counter;
    }
}
