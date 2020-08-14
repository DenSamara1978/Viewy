package ru.melandra.viewy.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;
import ru.melandra.viewy.Constants;
import ru.melandra.viewy.presenter.MainPresenter;
import ru.melandra.viewy.presenter.MainRecyclerViewAdapter;
import ru.melandra.viewy.R;

public class MainActivity extends MvpAppCompatActivity implements MainView, Constants {

    @InjectPresenter
    MainPresenter presenter;

//    @ProvidePresenter
  //  public MainPresenter providePresenter() {
    //    return new MainPresenter();
 //   }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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