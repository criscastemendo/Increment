package com.criscastemendo.increment;

public class IncrementModel implements IncrementContract.Model {

    public static String TAG = IncrementModel.class.getSimpleName();

    public IncrementModel() {

        int numb;

    }

    public void increaction() {

    

    }

    @Override
    public String fetchData() {
        // Log.e(TAG, "fetchData()");
        return "0";
    }
}
