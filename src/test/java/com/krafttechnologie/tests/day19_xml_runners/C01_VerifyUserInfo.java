package com.krafttechnologie.tests.day19_xml_runners;

import com.krafttechnologie.pages.EditProfilePage;
import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.pages.UserProfilePage;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

/** Class Task

 Login as a TesterBFour
 Verify that login is successful by using url
 Click on My profile
 Click on Edit Profile
 Verify that job is QA Automation Engineer
 */
public class C01_VerifyUserInfo extends TestBase {

    @Test
    public void verifyUserInfo(){
        LoginPage loginPage = new LoginPage();
        UserProfilePage userProfilePage = new UserProfilePage();
        EditProfilePage editProfilePage = new EditProfilePage();

        driver.get(ConfigurationReader.get("url"));
        extentLogger = report.createTest("Verifying User Info");

        extentLogger.info("Login as a TesterBFour");
        loginPage.login();

        extentLogger.info("Verify that login is successful by using url");
        String expected = driver.getCurrentUrl();
        String actual = "https://www.krafttechexlab.com/index";
        Assert.assertEquals(expected,actual);

        extentLogger.info("Click on My profile");
        loginPage.navigateToModule("TesterBFour","My Profile");

        extentLogger.info("Click on Edit Profile");
        userProfilePage.navigateToOverviewMenu("Edit Profile");

        extentLogger.info("Verify that job is QA Automation Engineer");
        String actualJob = editProfilePage.getSelectedJob();
        String expectedJob = "QA Automation Engineer";
        Assert.assertEquals(actualJob,expectedJob);

        extentLogger.pass("PASSED");
    }
}
