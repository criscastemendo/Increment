package com.criscastemendo.increment;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import com.criscastemendo.increment.Mediator.AppMediator;

public class IncrementScreen {

    public static void configure(IncrementContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        IncrementState state = mediator.getIncrementState();

        IncrementContract.Router router = new IncrementRouter(mediator);
        IncrementContract.Presenter presenter = new IncrementPresenter(state);
        IncrementContract.Model model = new IncrementModel();
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
