package com.theagiletester.discalive.app.stepDefinitions.runner;

import junit.framework.TestCase;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        glue = "com.theagiletester.discalive.stepDefinitions",
        plugin = {
                "pretty",
                "html:" + CucumberInstrumentedTestRunner.REPORT_PATH + "cucumber-html-report",
                "pretty:" + CucumberInstrumentedTestRunner.REPORT_PATH + "cucumber-report.json",
                "junit:" + CucumberInstrumentedTestRunner.REPORT_PATH + "cucumber.xml"
        },
        features = "features",
        tags = "@shortSanity")
public class CucumberInstrumentedTestRunner extends TestCase {
    public static final String REPORT_PATH = "data/data/cucumber-reports/";
}



//package com.theagiletester.discalive.app.stepDefinitions;
//
//import android.app.Application;
//import android.content.Context;
//import android.os.Bundle;
//import android.support.test.runner.MonitoringInstrumentation;
//
//import com.theagiletester.discalive.app.helpers.CucumberInstrumentation;
//
//import cucumber.api.android.CucumberInstrumentationCore;
//
//import cucumber.api.CucumberOptions;
//
//@CucumberOptions(
//        features = "./assets.features",
//        glue = {"com.theagiletester.discalive.app.stepDefinitions"},
//        format = {"pretty",
//                "html:/data/data/my.package/cucumber-reports/cucumber-html-report",
//                "json:/data/data/my.package/cucumber-reports/cucumber.json",
//                "junit:/data/data/my.package/cucumber-reports/cucumber.xml"
//        }
//)
//public class CucumberInstrumentedTest extends CucumberInstrumentation {
//
//    private final CucumberInstrumentationCore mInstrumentationCore = new CucumberInstrumentationCore(this);
//
//    @Override
//    public void onCreate(Bundle arguments) {
//        super.onCreate(arguments);
//        mInstrumentationCore.create(arguments);
//        start();
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//
//        waitForIdleSync();
//        mInstrumentationCore.start();
//    }
//}
//    @Override
//    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
//        return super.newApplication(cl, InstrumentedTestExampleApplication.class.getName(), context);
//    }
//}

//package com.theagiletester.discalive;
//
//import cucumber.api.CucumberOptions;
//import android.app.Application;
//import android.test.ApplicationTestCase;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import android.util.Log;
//
//import cucumber.api.android.CucumberInstrumentation;
//
//@CucumberOptions(
//        plugin = {
//                "pretty",
//                "html:" + "cucumber-html-report",
//                "pretty:" + "cucumber-report.json",
//                "junit:" + "cucumber.xml"
//        },
//        features = "features",
//        tags = "~@wip")
//
//public class CucumberInstrumentedTest {
//    @Test
//    public void useAppContext() throws Exception {
//        Log.d("Test", "Test");
//    }
//}


//package com.theagiletester.discalive;
//
//import android.content.Context;
//import android.support.test.InstrumentationRegistry;
//import android.support.test.runner.AndroidJUnit4;

//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import static org.junit.Assert.*;
//
///**
// * CucumberInstrumentation test, which will execute on an Android device.
// *
// * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
// */
//@RunWith(AndroidJUnit4.class)
//public class ExampleInstrumentedTest {
//    @Test
//    public void useAppContext() throws Exception {
//        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getTargetContext();
//
//        assertEquals("com.theagiletester.discalive", appContext.getPackageName());
//    }
//}

