package com.criscastemendo.increment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class IncrementActivity
        extends AppCompatActivity implements IncrementContract.View {

    public static String TAG = IncrementActivity.class.getSimpleName();

    private IncrementContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_increment);

        // do the setup
        IncrementScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(IncrementContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(IncrementViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.Number)).setText(viewModel.numb);
    }
}
