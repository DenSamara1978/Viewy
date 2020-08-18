package ru.melandra.viewy.view;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.melandra.viewy.Constants;
import ru.melandra.viewy.DetailInfo;
import ru.melandra.viewy.presenter.DetailPresenter;
import ru.melandra.viewy.presenter.MainPresenter;
import ru.melandra.viewy.R;

public class MainActivity extends MvpAppCompatActivity implements MainView, Constants {

    @BindView ( R.id.mainRecycler )
    RecyclerView recyclerView;

    @InjectPresenter
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind ( this );

        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager (this, 2);
        recyclerView.setLayoutManager(layoutManager);
        MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter(presenter, (adapterView, view, position, id) ->
        {
            Bundle extras = new Bundle();
            DetailInfo info = new DetailInfo(position);
            extras.putParcelable(DETAIL_ARGUMENTS, info);

            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtras(extras);
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showCount(int count) {
        Log.d(DBG_TAG, "Counter is equal " + count);
    }
}