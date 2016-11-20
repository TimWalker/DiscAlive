package com.theagiletester.discalive.app.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.PendingException;

/**
 * Created by timwalker on 11/19/16.
 */

public class UtilitySteps {

    @Then("^I just admire the state for (\\d+) seconds$")
    public void i_just_admire_the_state_for_seconds(int seconds) throws Throwable {
        Thread.sleep(seconds * 1000);
    }
}
