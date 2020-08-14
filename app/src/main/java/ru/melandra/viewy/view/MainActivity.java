package ru.melandra.viewy.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import ru.melandra.viewy.Constants;
import ru.melandra.viewy.presenter.MainPresenter;
import ru.melandra.viewy.presenter.MainRecyclerViewAdapter;
import ru.melandra.viewy.R;

public class MainActivity extends AppCompatActivity implements MainView, Constants {

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.mainRecycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter(presenter);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showCount(int count) {
        Log.d(DBG_TAG, "Counter is equal " + count);
    }
}