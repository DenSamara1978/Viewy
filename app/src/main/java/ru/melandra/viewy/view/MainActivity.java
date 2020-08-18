package ru.melandra.viewy.view;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.melandra.viewy.Constants;
import ru.melandra.viewy.DetailInfo;
import ru.melandra.viewy.app.App;
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
            DetailInfo info = new DetailInfo(position, presenter.getHit ( position ).webformatUrl);
            extras.putParcelable(DETAIL_ARGUMENTS, info);

            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtras(extras);
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void fillRecyclerView() {
        Objects.requireNonNull ( recyclerView.getAdapter () ).notifyDataSetChanged ();
    }

    @Override
    public void showCount(int count) {
        Log.d(DBG_TAG, "Counter is equal " + count);
    }
}