package com.theagiletester.discalive.app.stepDefinitions;

import cucumber.api.CucumberOptions;


@CucumberOptions(
        plugin = {
                "pretty",
                "html:"  + "cucumber-html-report",
                "pretty:" + "cucumber-report.json",
                "junit:"  + "cucumber.xml"
        },
        features = "features",
        tags = "@shortSanity")

public class Runner {
    public static final String REPORT_PATH = "data/data/cucumber-reports/";
}
