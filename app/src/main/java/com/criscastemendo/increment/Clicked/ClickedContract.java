package com.criscastemendo.increment.Clicked;

import java.lang.ref.WeakReference;

interface ClickedContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(ClickedViewModel viewModel);
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

        void passDataToNextScreen(ClickedState state);

        ClickedState getDataFromPreviousScreen();
    }
}
