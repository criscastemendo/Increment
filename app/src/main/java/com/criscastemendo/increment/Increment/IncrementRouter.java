package com.criscastemendo.increment.Increment;

import android.content.Intent;
import android.content.Context;
import com.criscastemendo.increment.Mediator.AppMediator;

public class IncrementRouter implements IncrementContract.Router {

    public static String TAG = IncrementRouter.class.getSimpleName();

    private AppMediator mediator;

    public IncrementRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, IncrementActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(IncrementState state) {
        mediator.setIncrementState(state);
    }

    @Override
    public IncrementState getDataFromPreviousScreen() {
        IncrementState state = mediator.getIncrementState();
        return state;
    }
}
