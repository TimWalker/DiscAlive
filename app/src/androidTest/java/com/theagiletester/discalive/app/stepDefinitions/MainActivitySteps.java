package com.theagiletester.discalive.app.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.PendingException;

import android.util.Log;
import android.app.Instrumentation;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import com.theagiletester.discalive.MainActivity;


/**
 * Created by timwalker on 11/11/16.
 */

public class MainActivitySteps extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivitySteps() {
        super(MainActivity.class);
    }

    @Given("^I am on the Login Screen$")
    public void i_am_on_the_Login_Screen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I login with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_login_with_and(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I am on the DiscAlive! Main Activity$")
    public void i_am_on_the_DiscAlive_Main_Activity_Page() throws Throwable {
        MainActivity mainActivity;
        String textToEnter = "test text";

        Log.d("Cucumber Step", "MainActivityPage");

        super.setUp();
        mainActivity = getActivity();

        //textView = (TextView) mainActivity.findViewById(com.example.testapp.R.id.edit_message);
        //button = (Button) mainActivity.findViewById(com.example.testapp.R.id.button);

        assertTrue("mainACtivity is null",mainActivity != null);



    }

    @Then("^there is a cool image$")
    public void there_is_a_cool_image() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^there is a cool text that says \"([^\"]*)\"$")
    public void there_is_a_cool_text_that_says(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
