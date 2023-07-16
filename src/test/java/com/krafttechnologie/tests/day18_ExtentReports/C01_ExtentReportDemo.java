package com.krafttechnologie.tests.day18_ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C01_ExtentReportDemo {
    // this class is used for starting and building reports
    ExtentReports report;

    //this class is used to create html report file
    ExtentHtmlReporter htmlReporter;

    //this will define a test, enable adding logs, authors and test steps
    ExtentTest extentLogger;


    @BeforeMethod
    public void setUP(){
        //initialize the class
        report = new ExtentReports();

        //create a report path
        String projectPath = System.getProperty("user.dir");
        String path= projectPath+"/test-output/report.html";

        // initialize the html report with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to the report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("Krafttech smoke test");

        // set environment information
        report.setSystemInfo("Environment","Production ");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer","Onur");

    }

    @Test
    public void test1() {
        extentLogger=report.createTest("TC001 Login Test");

        extentLogger.info("Open The Browser");
        extentLogger.info("Go to url https://www.krafttechexlab.com/login");
        extentLogger.info("Login as user");
        extentLogger.info("Enter user username");
        extentLogger.info("Enter user password");
        extentLogger.info("Click login button");
        extentLogger.info("Verify logged in");
        extentLogger.info("TC001 Login test is Passed");

    }

    @AfterMethod
    public void tearDown(){
        report.flush(); // this is when the report is actually created
    }
}
