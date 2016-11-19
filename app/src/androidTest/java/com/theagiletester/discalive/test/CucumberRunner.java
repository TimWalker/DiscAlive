package com.theagiletester.discalive.test;

import junit.framework.TestCase;

/**
 * Created by timwalker on 11/11/16.
 */

import cucumber.api.CucumberOptions;
@CucumberOptions(
        glue = "com.theagiletester.discalive.app.stepDefinitions",
        plugin = { "pretty" },
        features = "features",
        tags = "~@wip"
        )

public class CucumberRunner extends TestCase
{
        public static final String REPORT_PATH = "cucumber-reports/";
}
