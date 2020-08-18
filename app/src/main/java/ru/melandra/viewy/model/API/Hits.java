package ru.melandra.viewy.model.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Hits
{
    @Expose
    @SerializedName ( "hits" )
    public List< Hit > hits = new ArrayList<> ();
}
