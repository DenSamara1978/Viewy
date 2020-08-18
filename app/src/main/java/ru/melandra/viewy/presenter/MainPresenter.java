package ru.melandra.viewy.presenter;

import android.util.Log;

import java.util.Objects;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.melandra.viewy.Constants;
import ru.melandra.viewy.app.App;
import ru.melandra.viewy.model.API.ApiService;
import ru.melandra.viewy.model.API.Hit;
import ru.melandra.viewy.model.API.Hits;
import ru.melandra.viewy.model.DB.HitDao;
import ru.melandra.viewy.model.DB.HitRecord;
import ru.melandra.viewy.model.Model;
import ru.melandra.viewy.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> implements Constants {

    private Hits hits;
    private HitDao hitDao;

    @Inject
    ApiService apiService;

    @Inject
    Model model;

    public void onClickImage(){
        model.fixAction();
        getViewState().showCount(model.getCount());
    }

    @Override
    protected void onFirstViewAttach() {
        App.getAppComponent().inject(this);
        hitDao = App.getDatabase().hitDao();
        hits = new Hits ();
        loadDataFromDB ();
    }

    public int getHitsSize() {
        return hits.hits.size ();
    }

    public Hit getHit (int index) {
        return hits.hits.get ( index );
    }

    private void saveDataToDB () {
        for (int i = 0; i < hits.hits.size(); i++) {
            HitRecord hit = new HitRecord (hits.hits.get(i));
            Disposable disposable = hitDao.insert(hit).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(id -> {
                    }, throwable -> {
                        Log.d (DBG_TAG, "Error while saving to DB!");
                        Log.d (DBG_TAG, Objects.requireNonNull ( throwable.getMessage () ) );
                    });
        }
    }

    private void loadDataFromDB () {
        Disposable disposable = hitDao.getAll().subscribeOn( Schedulers.io())
                .subscribe(list -> {
                    hits.hits.clear ();
                    list.forEach ( hitRecord -> {
                        hits.hits.add(hitRecord.getHit ());
                    });
                    getViewState().fillRecyclerView();
                    if (list.size () == 0) {
                        requestApi ();
                    }
                }, throwable ->
                {
                    Log.d ( DBG_TAG, "Error while reading DB!" );
                    Log.d ( DBG_TAG, Objects.requireNonNull ( throwable.getMessage () ) );
                });

    }

    private void requestApi () {
        Observable<Hits> single = apiService.requestServer();

        Disposable disposable = single.observeOn( AndroidSchedulers.mainThread()).subscribe( hits ->
        {
            this.hits = hits;
            getViewState ().fillRecyclerView ();
            saveDataToDB ();
        }, throwable -> {
            Log.d (DBG_TAG, "Error while requesting server!");
            Log.d (DBG_TAG, Objects.requireNonNull ( throwable.getMessage () ) );
        });
    }
}
