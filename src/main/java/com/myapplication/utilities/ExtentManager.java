package com.myapplication.utilities;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            // set HTML report file location
            extent = new ExtentReports(Constants.workingDir
                    + "/extentreports/ExtentReportResults.html", true);
        }
        return extent;
    }
}