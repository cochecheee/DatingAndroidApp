package com.example.datingappandroid.utils;

import androidx.databinding.BindingAdapter;

import com.facebook.drawee.view.SimpleDraweeView;

public class BindingUtils {
    @BindingAdapter("image")
    public static void loadImage(SimpleDraweeView view, String url) {
        view.setImageURI(url);
    }
}
