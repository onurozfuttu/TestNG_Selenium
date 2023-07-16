package com.krafttechnologie.tests.day20_ddf;

import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import com.krafttechnologie.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_LoginTest extends TestBase {

    @DataProvider
    public Object[][] userData(){
        ExcelUtil excelUtil = new ExcelUtil("src/test/resources/Book1.xlsx","Sheet2");
        String[][] dataArrayWithoutFirstRow = excelUtil.getDataArrayWithoutFirstRow();
        return dataArrayWithoutFirstRow;
    }

    @Test(dataProvider = "userData")
    public void loginTestWithDataProvider(String username, String password, String name){
        driver.get(ConfigurationReader.get("url"));

        //create a login object
        LoginPage loginPage = new LoginPage();

        //Login withthe given credentials
        loginPage.emailInputBox.sendKeys(username);
        loginPage.passwordInputBox.sendKeys(password);
        loginPage.loginButton.click();

        String actual = loginPage.getUserAccountName();
        String expected = name;

        //verification
        Assert.assertEquals(actual,expected);

    }
}
