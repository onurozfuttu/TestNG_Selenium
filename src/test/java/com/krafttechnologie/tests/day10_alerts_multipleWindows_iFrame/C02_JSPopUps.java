package com.krafttechnologie.tests.day10_alerts_multipleWindows_iFrame;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C02_JSPopUps {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test_jsPopUp_Accept() throws InterruptedException {
        // tap on click for Js Alert button
        WebElement clickForJsAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        clickForJsAlert.click();

        Thread.sleep(2000);

        //create alert object
        Alert alert = driver.switchTo().alert();
        //tap OK button
        alert.accept();

        //verification
        String actual = driver.findElement(By.cssSelector("#result")).getText();
        String expected = "You successfully clicked an alert";

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void test_jsPopUp_Dismiss() throws InterruptedException {
        WebElement clickForJsConfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        clickForJsConfirm.click();

        // create an alert object
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        //tap on cancel button by dismiss()
        alert.dismiss();

        String actual = driver.findElement(By.cssSelector("#result")).getText();
        String expected = "You clicked: Cancel";

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void test_jsPopUp_SendKeys() throws InterruptedException {
        WebElement clickForJsPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        clickForJsPrompt.click();

        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        String text = "Onur";
        alert.sendKeys(text);

        Thread.sleep(2000);

        alert.accept();

        String actual = driver.findElement(By.cssSelector("#result")).getText();
        String expected = "You entered: " + text;

        Assert.assertEquals(actual,expected);

    }
}
