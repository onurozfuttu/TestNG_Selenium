package com.krafttechnologie.tests.day17_pom3;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.EditProfilePage;
import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.pages.UserProfilePage;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

/** Class Task
 * THIS TASK WILL BE IMPLEMENTED USING POM
 * which means we will have one test class for the test
 * and one corresponding page having all locators and actions for the page
 * go to https://www.krafttechexlab.com/login
 * enter valid credentials
 *      --> testerbfour@gmail.com
 *      --> Tester333
 * go to John --> myProfile
 * create a method that navigate you to specific module based on the given parameter
 * go to Edit Profile page using the method just mentioned above
 * fill out the fields
 *      -->about --> SDET programme , graduated from KraftTech
 *      -->Company --> Google
 *      -->Job  --> QA Automation Engineer
 *      -->Website --> www.google.com
 *      -->Location --> Istanbul
 *      -->Skills --> Java,Selenium, TestNG
 *      click save changes button
 *      verify that "profile updated" appears
 */
public class C02_EditProfileTest extends TestBase {
    @Test
    public void editProfile() {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        UserProfilePage userProfilePage = new UserProfilePage();
        EditProfilePage editProfilePage = new EditProfilePage();

        driver.get("https://www.krafttechexlab.com/login");
        loginPage.login(ConfigurationReader.get("userEmail"),ConfigurationReader.get("userPassword"));

        BrowserUtils.waitForVisibility(dashboardPage.userAccountName,2);

        dashboardPage.navigateToModule("TesterBFour","My Profile");

        userProfilePage.navigateToOverviewMenu("Edit Profile");

        editProfilePage.aboutInputBox.clear();
        editProfilePage.aboutInputBox.sendKeys("I am learning POM");

        editProfilePage.companyInputBox.clear();
        editProfilePage.companyInputBox.sendKeys("Google");

        editProfilePage.selectJob("QA Automation Engineer");

        editProfilePage.websiteInputBox.clear();
        editProfilePage.websiteInputBox.sendKeys("www.google.com");

        editProfilePage.locationInputBox.clear();
        editProfilePage.locationInputBox.sendKeys("Istanbul");

        editProfilePage.skillsInputBox.clear();
        editProfilePage.skillsInputBox.sendKeys("SDET", "QA");

        BrowserUtils.waitFor(2);

        //editProfilePage.saveButton.click();
        BrowserUtils.clickWithJS(editProfilePage.saveButton);

        String actual = "Profile Updated";
        String expected = editProfilePage.updateMessage.getText();

        Assert.assertEquals(actual,expected);







    }
}
