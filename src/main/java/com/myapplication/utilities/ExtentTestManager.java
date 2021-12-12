package com.myapplication.utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports extent = ExtentManager.getReporter();

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized void endTest() {
        extent.endTest(extentTestMap.get((int) Thread.currentThread().getId()));
    }

    public static synchronized void startTest(String testName) {
        ExtentTest test = extent.startTest(testName);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
    }
}