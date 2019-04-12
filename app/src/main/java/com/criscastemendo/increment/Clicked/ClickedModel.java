package com.criscastemendo.increment.Clicked;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class ClickedModel implements ClickedContract.Model {

    public static String TAG = ClickedModel.class.getSimpleName();

    public ClickedModel() {

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "Hello";
    }
}
