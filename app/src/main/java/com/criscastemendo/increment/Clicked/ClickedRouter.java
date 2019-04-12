package com.criscastemendo.increment.Clicked;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class ClickedRouter implements ClickedContract.Router {

    public static String TAG = ClickedRouter.class.getSimpleName();

    private AppMediator mediator;

    public ClickedRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ClickedActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(ClickedState state) {
        mediator.setClickedState(state);
    }

    @Override
    public ClickedState getDataFromPreviousScreen() {
        ClickedState state = mediator.getClickedState();
        return state;
    }
}
