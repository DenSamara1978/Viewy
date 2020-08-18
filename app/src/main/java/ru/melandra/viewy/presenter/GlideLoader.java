package ru.melandra.viewy.presenter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import ru.melandra.viewy.app.App;

public class GlideLoader
{
    public static void loadImage ( ImageView view, String url) {
        Glide.with ( App.getContext()).load ( url ).into ( view );
    }
}
