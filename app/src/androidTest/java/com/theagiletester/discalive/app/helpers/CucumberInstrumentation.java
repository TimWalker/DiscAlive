package com.theagiletester.discalive.app.helpers;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnitRunner;
import android.support.test.runner.MonitoringInstrumentation;
import android.test.InstrumentationTestCase;
import android.test.InstrumentationTestRunner;
import android.util.Log;

import cucumber.api.android.CucumberInstrumentationCore;

public class CucumberInstrumentation extends InstrumentationTestRunner {

    private final CucumberInstrumentationCore instrumentationCore = new CucumberInstrumentationCore(this);

    @Override
    public void onCreate(final Bundle bundle) {
        try {
            super.onCreate(bundle);
            Log.d("CucumberInstrumentation: ", "Keys: " + bundle.keySet().toString() + "Class: " + bundle.getClass().toString());
            instrumentationCore.create(bundle);
        } catch(Exception e) { Log.d("Cucumber:", "onStart Exception" + e.getMessage()); }
    }

    @Override

    public void onStart() {
        try {
            waitForIdleSync();
            instrumentationCore.start();
        }
        catch(Exception e) { Log.d("Cucumber:", "onStart Exception" + e.getMessage()); }
    }

}

