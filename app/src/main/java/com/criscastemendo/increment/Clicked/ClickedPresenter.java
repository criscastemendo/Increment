package com.criscastemendo.increment.Clicked;

import android.util.Log;

import java.lang.ref.WeakReference;

public class ClickedPresenter implements ClickedContract.Presenter {

    public static String TAG = ClickedPresenter.class.getSimpleName();

    private WeakReference<ClickedContract.View> view;
    private ClickedViewModel viewModel;
    private ClickedContract.Model model;
    private ClickedContract.Router router;

    public ClickedPresenter(ClickedState state) {
        viewModel = state;
    }

    @Override
    public void injectView(WeakReference<ClickedContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(ClickedContract.Model model) {
        this.model = model;
    }

    @Override
    public void injectRouter(ClickedContract.Router router) {
        this.router = router;
    }

    @Override
    public void fetchData() {
        // Log.e(TAG, "fetchData()");

        // set passed state
        ClickedState state = router.getDataFromPreviousScreen();
        if (state != null) {
            viewModel.data = state.data;
        }

        if (viewModel.data == null) {
            // call the model
            String data = model.fetchData();

            // set initial state
            viewModel.data = data;
        }

        // update the view
        view.get().displayData(viewModel);

    }


}
