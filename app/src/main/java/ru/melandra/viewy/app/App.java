package ru.melandra.viewy.app;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.squareup.leakcanary.LeakCanary;

import ru.melandra.viewy.model.DB.DB;

public class App extends Application
{
    private static DB database;
    private static AppComponent appComponent;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        initLeakCanary();

        generateDataBase ();
        generateAppComponent();

        context = getApplicationContext ();
    }

    private void initLeakCanary() {
        if ( LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public void generateAppComponent() {
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }

    private void generateDataBase() {
        database = Room.databaseBuilder(getApplicationContext(),
                DB.class, "room_database").build();
    }

    public static DB getDatabase() {
        return database;
    }
    public static Context getContext()
    {
        return context;
    }
}
