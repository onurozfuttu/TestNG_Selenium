package com.krafttechnologie.tests.day18_ExtentReports;

import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C02_WrongUsernameTest extends TestBase {

    @Test
    public void wrongUserEmail(){
        LoginPage loginPage = new LoginPage();
        extentLogger = report.createTest("Wrong User Email Test");

        extentLogger.info("Go to Krafttech Login Page");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Enter Wrong User Email");
        loginPage.emailInputBox.sendKeys("wrongEmail1@gmail.com");
        extentLogger.info("Enter User Password");
        loginPage.passwordInputBox.sendKeys(ConfigurationReader.get("userPassword"));
        extentLogger.info("Click login button");
        loginPage.loginButton.click();
        String actualMessage= loginPage.usernameErrorMessage.getText();
        extentLogger.info("Verify that NOT login");
        //Assert.assertEquals(actualMessage,"Email address is1 incorrect. Please check"); //For fail
        Assert.assertEquals(actualMessage,"Email address is incorrect. Please check");
        extentLogger.pass("PASSED");

    }

    @Test
    public void wrongPassword(){
        LoginPage loginPage = new LoginPage();
        extentLogger = report.createTest("Wrong User Password Test");

        extentLogger.info("Go to Krafttech Login Page");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Enter Valid User Email");
        loginPage.emailInputBox.sendKeys(ConfigurationReader.get("userEmail"));
        extentLogger.info("Enter Wrong User Password");
        loginPage.passwordInputBox.sendKeys("wrong password");
        extentLogger.info("Click login button");
        loginPage.loginButton.click();
        String actualMessage= loginPage.passwordErrorMessage.getText();
        extentLogger.info("Verify that NOT login");
        //Assert.assertEquals(actualMessage,"111Password is incorrect. Please check"); //For fail
        Assert.assertEquals(actualMessage,"Password is incorrect. Please check");
        extentLogger.pass("PASSED");

    }
}
