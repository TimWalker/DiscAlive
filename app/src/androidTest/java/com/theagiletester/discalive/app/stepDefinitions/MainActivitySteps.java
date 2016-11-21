package com.theagiletester.discalive.app.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.PendingException;

import android.content.res.Resources;
import android.text.Layout;
import android.util.Log;
import android.app.Instrumentation;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import com.theagiletester.discalive.DiscAliveEngine;
import com.theagiletester.discalive.DiscAliveReader;
import com.theagiletester.discalive.DiscAliveReaderInterface;
import com.theagiletester.discalive.MainActivity;
import com.theagiletester.discalive.R;
import com.theagiletester.discalive.test.mockNFCReaderServiceWhenRfidsPresent;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.graphics.drawable.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.theagiletester.discalive.DiscAliveNFCReader;

/**
 * Created by timwalker on 11/11/16.
 */

public class MainActivitySteps extends ActivityInstrumentationTestCase2<MainActivity> {
    ImageView imageView;
    private MainActivity mainActivity = null;

    DiscAliveEngine discAliveEngine;

    public MainActivitySteps() {
        super(MainActivity.class);
    }

    @Given("^there is an RFID enabled SmartDisc detected$")
    public void there_is_an_RFID_enabled_SmartDisc_detected() throws Throwable {
        discAliveEngine = new DiscAliveEngine(new DiscAliveNFCReader(this.mainActivity.getApplicationContext()));
    }

    @When("^I click on the DiscAlive! Button$")
    public void i_click_on_the_DiscAlive_Button() throws Throwable {
        ImageButton imageButton = (ImageButton) mainActivity.findViewById(R.id.comeAliveButton);
        imageButton.callOnClick();
        assertThat(discAliveEngine.getPayload(), is(notNullValue()));
    }

    @Then("^DiscAlive! will tell me all about the disc$")
    public void discalive_will_tell_me_all_about_the_disc() throws Throwable {
        if (discAliveEngine.readSmartDisc()) {
            Log.d("Cucumber", "DiscAlive! Read Success: " + discAliveEngine.getPayload());
        }
        //assertThat(discAliveEngine.getPayload(), is(equalTo("Innova Beast")));
    }

    //TODO: Move to Page or ScreenCast implementation. Solve for Singleton
    @Given("^I am on the DiscAlive! Main Activity$")
    public void i_am_on_the_DiscAlive_Main_Activity_Page() throws Throwable {
        Log.d("Cucumber Step", "MainActivityPage");
        if (mainActivity == null) {
            super.setUp();
            Log.d("Cucumber Step", "Get a new Main Activity");
            mainActivity = getActivity();
        }
        assertThat(mainActivity, is(notNullValue()));
    }

    @Then("^there is a cool image$")
    public void there_is_a_cool_image() throws Throwable {
        //Todo: Replace with better test for night
        LinearLayout l = (LinearLayout)mainActivity.findViewById(R.id.linearlayout);
        Drawable ld = l.getBackground();
        ld.isVisible();
        assertThat(ld.isVisible(), is(true));
    }

    @Then("^there is a cool button$")
    public void there_is_a_cool_button() throws Throwable {
        ImageButton imageButton = (ImageButton) mainActivity.findViewById(R.id.comeAliveButton);
        assertThat(imageButton, is(notNullValue()));
    }

    @Then("^there is a cool text that says \"([^\"]*)\"$")
    public void there_is_a_cool_text_that_says(String arg1) throws Throwable {
        TextView textView = (TextView) mainActivity.findViewById(R.id.comeAliveText);
        assertThat(textView, is(notNullValue()));
    }

}
