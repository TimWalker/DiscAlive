package com.theagiletester.discalive.app.stepDefinitions;

import android.widget.ImageButton;

import com.theagiletester.discalive.DiscAliveEngine;
import com.theagiletester.discalive.DiscAliveReaderInterface;
import com.theagiletester.discalive.R;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.PendingException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by timwalker on 11/19/16.
 */

public class rfidAliveSteps
{

    @When("^I read the information on it$")
    public void i_read_the_information_on_it() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^There isn't an RFID enabled SmartDisc detected$")
    public void there_isn_t_an_RFID_enabled_SmartDisc_detected() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^DiscAlive! will let me know so I don't waste my time$")
    public void discalive_will_let_me_know_so_I_don_t_waste_my_time() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


}
