package com.theagiletester.discalive.test;

import android.content.Context;
import android.os.Bundle;
import android.support.test.runner.AndroidJUnitRunner;
import android.support.test.runner.MonitoringInstrumentation;
import android.support.test.InstrumentationRegistry;
import android.test.InstrumentationTestCase;
import android.test.InstrumentationTestRunner;
import android.util.Log;
import cucumber.api.android.CucumberInstrumentationCore;

public class CucumberInstrumentation extends AndroidJUnitRunner {

    private final CucumberInstrumentationCore instrumentationCore = new CucumberInstrumentationCore(this);

    @Override
    public void onCreate(final Bundle bundle) {
        try {
            super.onCreate(bundle);

            Context context = this.getContext();
            Log.d("Cucumber: ", "This Context Package " + context.getPackageName());

            Context inst_context = InstrumentationRegistry.getTargetContext();
            Log.d("Cucumber: ", "Instrumentation Context Package " + context.getPackageName());

            Log.d("Cucumber: ", "Package " + context.getPackageName());
            Log.d("CucumberInstrumentation onCreate: ", "Keys: " + bundle.keySet().toString() + "Class: " + bundle.getClass().toString());
            instrumentationCore.create(bundle);
        } catch(Exception e) {
            Log.d("Cucumber:", "Cucumber onCreate Exception: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void onStart() {
        try {
            waitForIdleSync();
            Log.d("CucumberInstrumentation onStart: ", "Calling instumentationCore.Start");
            instrumentationCore.start();
        } catch (Exception e) {
            Log.d("Cucumber:", "Cucumber onStart Exception: " + e.getMessage() + "," + e.fillInStackTrace());
        }
    }
}

