package com.theagiletester.discalive.app.stepDefinitions;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import com.theagiletester.discalive.MainActivity;
import com.theagiletester.discalive.NfcActivity;

import cucumber.api.java.en.Then;

import android.util.Log;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Created by timwalker on 11/27/16.
 */

public class NfcActivitySteps extends ActivityInstrumentationTestCase2<NfcActivity> {

    public NfcActivitySteps() {
        super(NfcActivity.class);
    }

    @Then("^I am on the NFCActivity$")
    public void i_am_on_the_NFCActivity() throws Throwable {
        //Activity activity = getActivity();
        //Log.d("Cucumber", "NFC Activity: " + activity);
        //assertThat(activity.getClass().getSimpleName(), containsString("NfcActivity"));
    }
}
