package com.krafttechnologie.tests.day17_pom3;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class C01_DashBoardTest2 extends TestBase {
    LoginPage loginPage;
    @Test
    public void verifyList(){
        driver.get(ConfigurationReader.get("url"));
        loginPage = new LoginPage();
        loginPage.login();

        BrowserUtils.waitFor(2);

        DashboardPage dashboardPage = new DashboardPage();

        String expected = "Dashboard";
        String actual = dashboardPage.dashboardElement.getText();
        //first assertion
        Assert.assertEquals(actual,expected);
        List<String> expectedList = new ArrayList<>();
        expectedList.add("Dashboard");
        expectedList.add("Developers");
        expectedList.add("Components");
        expectedList.add("Forms");
        expectedList.add("JavaScript");
        expectedList.add("mike");

        List<String> actualList = new ArrayList<>();

        for (WebElement menu: dashboardPage.upTitles){
            actualList.add(menu.getText());
        }

        Assert.assertEquals(expectedList,actualList);
    }
}
