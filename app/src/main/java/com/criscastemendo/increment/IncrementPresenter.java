package com.criscastemendo.increment;

import android.util.Log;

import java.lang.ref.WeakReference;

public class IncrementPresenter implements IncrementContract.Presenter {

    public static String TAG = IncrementPresenter.class.getSimpleName();

    private WeakReference<IncrementContract.View> view;
    private IncrementViewModel viewModel;
    private IncrementContract.Model model;
    private IncrementContract.Router router;

    public IncrementPresenter(IncrementState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<IncrementContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(IncrementContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(IncrementContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        IncrementState state = router.getDataFromPreviousScreen();
        if (state != null) {
            viewModel.numb = state.numb;
        }

        if (viewModel.numb == "9") {
            // call the model
            String numb = model.fetchData();

            // set initial state
            viewModel.numb = numb;
        }

        // update the view
        view.get().displayData(viewModel);

    }


}
