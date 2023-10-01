package com.autospace.utils.ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	public static final ExtentReports extentReports = new ExtentReports();
	
    public synchronized static ExtentReports createExtentReports() {
        
    	ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        reporter.config().setReportName("Sample Extent Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Name", "QA AutoSpace");
        extentReports.setSystemInfo("Author", "Satish");
        return extentReports;
        
    }

}
