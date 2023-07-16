package com.krafttechnologie.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.ConfigurationReader;
import com.krafttechnologie.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    // this class is used for starting and building reports
    protected ExtentReports report;

    //this class is used to create html report file
    protected ExtentHtmlReporter htmlReporter;

    //this will define a test, enable adding logs, authors and test steps
    protected ExtentTest extentLogger;

    @BeforeTest
    public void setupTest(){
        //initialize the class
        report = new ExtentReports();

        //create a report path
        String projectPath = System.getProperty("user.dir");


        //to take dynamic reports
        /*String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path= projectPath+"/test-output/report"+date+".html";
        */
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

    @AfterTest
    public void tearDownTest(){
        report.flush(); // this is when the report is actually created
    }
    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = Driver.get();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        actions = new Actions(driver);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,15);

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        //if test fails
       if(result.getStatus() == ITestResult.FAILURE){
            //Record the name of the failed test
            extentLogger.fail(result.getName());
            //Take the screenshot and return the location of screenshot
            String screenshotPath = BrowserUtils.getScreenshot(result.getName());
            //add the screenshot to the report
            extentLogger.addScreenCaptureFromPath(screenshotPath);
            //capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());

        }
        Thread.sleep(2000);
        Driver.closeDriver();
    }
}
