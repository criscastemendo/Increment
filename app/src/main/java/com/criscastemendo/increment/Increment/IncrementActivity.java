package com.criscastemendo.increment.Increment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.criscastemendo.increment.R;

public class IncrementActivity
        extends AppCompatActivity implements IncrementContract.View, View.OnClickListener {

    public static String TAG = IncrementActivity.class.getSimpleName();

    private IncrementContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_increment);


        findViewById(R.id.button2).setOnClickListener(this);
        // do the setup
        IncrementScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        findViewById(R.id.button2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
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
        ((TextView) findViewById(R.id.click)).setText(viewModel.click);
    }

}
