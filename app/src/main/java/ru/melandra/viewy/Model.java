package ru.melandra.viewy;

import android.util.Log;

import static ru.melandra.viewy.Constants.DBG_TAG;

public class Model implements Constants {
    private int counter = 0;

    public void fixAction() {
        ++counter;
        Log.d(DBG_TAG, "Counter is equal " + counter);
    }
}
