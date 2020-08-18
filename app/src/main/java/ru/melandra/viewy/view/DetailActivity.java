package ru.melandra.viewy.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.melandra.viewy.Constants;
import ru.melandra.viewy.DetailInfo;
import ru.melandra.viewy.R;
import ru.melandra.viewy.presenter.DetailPresenter;

public class DetailActivity extends MvpAppCompatActivity implements DetailView, Constants {

    @BindView (R.id.detailImageView)
    ImageView detailImageView;

    @InjectPresenter
    DetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            extras.getParcelable(DETAIL_ARGUMENTS);
            DetailInfo info = extras.getParcelable(DETAIL_ARGUMENTS);
            Log.d(DBG_TAG, "DetailActivity: number is " + info.position);
        }
        detailImageView.setImageResource (R.drawable.ic_sample_image);
    }
}