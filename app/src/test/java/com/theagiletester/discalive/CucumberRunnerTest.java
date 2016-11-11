package com.theagiletester.discalive;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/java/com/theagiletester/discalive/features",
        format = {"pretty", "html:report"},
        tags = {"~@wip"} )

public class CucumberRunnerTest {
}
