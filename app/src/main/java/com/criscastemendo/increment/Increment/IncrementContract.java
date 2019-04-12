package com.criscastemendo.increment.Increment;

import java.lang.ref.WeakReference;

interface IncrementContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(IncrementViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(IncrementState state);

        IncrementState getDataFromPreviousScreen();
    }
}
