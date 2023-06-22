package com.krafttechnologie.tests.day10_alerts_multipleWindows_iFrame;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class C03_MultipleWindows {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test_switchedBetweenTwoWindows() throws InterruptedException {
        WebElement clickHereButton = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereButton.click();

        Thread.sleep(2000);

        //switched between windows
        String currentWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            if(!currentWindow.equals(windowHandle)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        //verification
        WebElement newWindow = driver.findElement(By.xpath("//h3[.='New Window']"));
        String actual = newWindow.getText();
        String expected = "New Window";
        Assert.assertEquals(actual,expected);

    }

    @Test
    public void test_switchBetweenMultipleWindows() {
        WebElement clickHereButton = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereButton.click();
        clickHereButton.click();
        clickHereButton.click();

        String expectedUrl = "https://the-internet.herokuapp.com/windows/new";

        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if(driver.getCurrentUrl().equals(expectedUrl)){
                break;
            }
        }
        System.out.println(driver.getCurrentUrl());
    }
}
