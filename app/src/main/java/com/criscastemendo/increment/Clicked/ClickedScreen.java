package com.criscastemendo.increment.Clicked;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

public class ClickedScreen {

    public static void configure(ClickedContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        ClickedState state = mediator.getClickedState();

        ClickedContract.Router router = new ClickedRouter(mediator);
        ClickedContract.Presenter presenter = new ClickedPresenter(state);
        ClickedContract.Model model = new ClickedModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
