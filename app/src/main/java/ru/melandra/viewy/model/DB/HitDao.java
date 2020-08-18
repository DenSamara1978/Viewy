package ru.melandra.viewy.model.DB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface HitDao
{
    @Query ("SELECT * FROM hits_tbl")
    Single< List<HitRecord> > getAll();

    @Insert
    Single<Long> insert(HitRecord record);
}
