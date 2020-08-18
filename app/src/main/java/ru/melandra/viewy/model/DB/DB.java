package ru.melandra.viewy.model.DB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database (entities = {HitRecord.class}, version = 1, exportSchema = false)
public abstract class DB extends RoomDatabase
{
    public abstract HitDao hitDao();
}
