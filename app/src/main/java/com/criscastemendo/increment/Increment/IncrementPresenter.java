package com.criscastemendo.increment.Increment;

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
        if (state.numb != null) {
            viewModel.numb = state.numb;
            viewModel.click = state.click;
            if (viewModel.numb == "9") {
                // call the model
                String numb = model.fetchData();
                int click= Integer.parseInt(viewModel.click);
                click++;
                viewModel.click= String.valueOf(click);
                // set initial state
                viewModel.numb = numb;
                state.numb=viewModel.numb;
                state.click=viewModel.click;
            }
            else{

                int numero= Integer.parseInt(viewModel.numb);
                numero++;
                viewModel.numb= String.valueOf(numero);
                state.numb=viewModel.numb;

                int click= Integer.parseInt(viewModel.click);
                click++;
                viewModel.click= String.valueOf(click);
                state.click=viewModel.click;

            }
        }



        // update the view
        view.get().displayData(viewModel);

    }


}
