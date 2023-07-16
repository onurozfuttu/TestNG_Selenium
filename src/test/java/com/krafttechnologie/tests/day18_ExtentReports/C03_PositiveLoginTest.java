package com.krafttechnologie.tests.day18_ExtentReports;

import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class C03_PositiveLoginTest extends TestBase {

    @Test
    public void loginTest1(){
        LoginPage loginPage = new LoginPage();
        extentLogger = report.createTest("Login Test");
        extentLogger.info("Go to Krafttech Login Page");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("login method");
        loginPage.login();
        System.out.println("1");
    }

    @Test
    public void loginTest2(){
        LoginPage loginPage = new LoginPage();
        extentLogger = report.createTest("Login Test 2");

        extentLogger.info("Go to Krafttech Login Page");
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("login method 2");
        loginPage.login();
        System.out.println("2");
    }

}
