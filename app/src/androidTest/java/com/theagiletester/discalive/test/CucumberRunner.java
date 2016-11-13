package com.theagiletester.discalive.test;

import junit.framework.TestCase;

/**
 * Created by timwalker on 11/11/16.
 */

import cucumber.api.CucumberOptions;
@CucumberOptions(
        glue = "com.theagiletester.discalive.app.stepDefinitions",
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
