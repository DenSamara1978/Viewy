package ru.melandra.viewy.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.melandra.viewy.Constants;
import ru.melandra.viewy.R;
import ru.melandra.viewy.presenter.DetailPresenter;

public class DetailActivity extends MvpAppCompatActivity implements DetailView, Constants {

    @InjectPresenter
    DetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }
}