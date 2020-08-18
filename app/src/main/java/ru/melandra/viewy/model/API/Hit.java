package ru.melandra.viewy.model.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hit
{

    @Expose
    @SerializedName ( "id" )
    public int id;

    @Expose
    @SerializedName ( "previewURL" )
    public String previewUrl;

    @Expose
    @SerializedName ( "webformatURL" )
    public String webformatUrl;
}
