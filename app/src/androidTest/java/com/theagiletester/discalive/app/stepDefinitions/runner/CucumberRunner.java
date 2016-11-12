package com.theagiletester.discalive.app.stepDefinitions.runner;

import junit.framework.TestCase;
import cucumber.api.CucumberOptions;

/**
 * Created by timwalker on 11/11/16.
 */
@CucumberOptions(
        glue = "com.theagiletester.discalive.stepDefinitions",
        plugin = {
                "pretty",
                "html:" + CucumberRunner.REPORT_PATH + "cucumber-html-report",
                "pretty:" + CucumberRunner.REPORT_PATH + "cucumber-report.json",
                "junit:" + CucumberRunner.REPORT_PATH + "cucumber.xml"
        },
        features = "assets.features",
        tags = "@shortSanity")

public class CucumberRunner extends TestCase
{
        public static final String REPORT_PATH = "data/data/cucumber-reports/";
}
