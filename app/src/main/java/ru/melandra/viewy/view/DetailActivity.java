package ru.melandra.viewy.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ru.melandra.viewy.R;
import ru.melandra.viewy.presenter.DetailPresenter;

public class DetailActivity extends AppCompatActivity {

    private DetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        presenter = new DetailPresenter();
    }
}