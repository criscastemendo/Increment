package com.criscastemendo.increment.Clicked;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.criscastemendo.increment.R;

public class ClickedActivity
        extends AppCompatActivity implements ClickedContract.View {

    public static String TAG = ClickedActivity.class.getSimpleName();

    private ClickedContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked);

        // do the setup
        ClickedScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(ClickedContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(ClickedViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}
