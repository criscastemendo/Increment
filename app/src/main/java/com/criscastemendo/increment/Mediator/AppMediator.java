package com.criscastemendo.increment.Mediator;

import android.app.Application;

import com.criscastemendo.increment.Increment.IncrementState;

public class AppMediator extends Application {


  public void setIncrementState(IncrementState state) {
    IncrementState IncrementState = state;
  }

  public IncrementState getIncrementState() {

    IncrementState IncrementState= new IncrementState();
    return IncrementState;
  }
}
