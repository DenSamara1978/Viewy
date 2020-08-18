package ru.melandra.viewy.model.DB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import ru.melandra.viewy.model.API.Hit;

@Entity (tableName = "hits_tbl")
public class HitRecord
{
    @PrimaryKey (autoGenerate = true)
    int id;

    String previewUrl;
    String webformatUrl;

    HitRecord() {
    }

    public HitRecord(Hit hit) {
        webformatUrl = hit.webformatUrl;
        previewUrl = hit.previewUrl;
    }

    public Hit getHit() {
        Hit hit = new Hit ();
        hit.previewUrl = previewUrl;
        hit.webformatUrl = webformatUrl;
        return hit;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public String getWebformatUrl() {
        return webformatUrl;
    }
}
