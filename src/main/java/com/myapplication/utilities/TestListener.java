package com.myapplication.utilities;

import com.myapplication.engine.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TestListener extends BaseTest implements ITestListener {


    public void onStart(ITestContext context) {
        Log.info("*** Test Suite " + context.getName() + " started ***");
    }

    public void onTestStart(ITestResult result) {
        Log.info(("*** Running test method " + result.getMethod().getMethodName() + " ***"));
    }

    public void onTestSuccess(ITestResult result) {
        Log.info("*** Executed " + result.getMethod().getMethodName() + " test successfully ***");
    }

    public void onTestFailure(ITestResult result) {
        Log.error("*** Test execution " + result.getMethod().getMethodName() + " failed ***");
    }


    public void onTestSkipped(ITestResult result) {
        Log.info("*** Test " + result.getMethod().getMethodName() + " skipped ***");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        Log.info("*** Test failed but within percentage % " + result.getMethod().getMethodName() + " ***");
    }

    public void onFinish(ITestContext context) {
        Log.info(("*** Test Suite " + context.getName() + " ending ***"));
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
        File htmlFile = new File(Constants.workingDir + "/extentreports/ExtentReportResults.html");
        try {
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            Log.error("*** Couldn't fire report " + e);
        }
    }
}