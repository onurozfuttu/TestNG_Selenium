package com.krafttechnologie.tests.day12_action_JS_FileUpload;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C02_JS_Executor_Demo {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void clickWithJS() {
        driver.get("https://www.amazon.com.tr/");

        WebElement germany = driver.findElement(By.linkText("Almanya"));
        //germany.click();

        // ask google - how to click with jsExecutor
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", germany);
        driver.findElement(By.id("sp-cc-accept")).click();

       // driver.close();
    }

    @Test
    public void typeWithJS() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        String text = "Hello";
        //ask google --> how to sendkeys using JSExecutor
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].setAttribute('value', '" + text +"')", inputBox);

        Thread.sleep(2000);

        //driver.close();
    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.id("sp-cc-accept")).click();


        //ask google - how to scroll down with JSExecutor
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //jse.executeScript("window.scrollBy(0,500)");

        for (int i = 0; i < 10; i++) {
            jse.executeScript("window.scrollBy(0,500)");
            Thread.sleep(1000);
        }

        for (int i = 0; i < 10; i++) {
            jse.executeScript("window.scrollBy(0,-500)");
            Thread.sleep(1000);
        }

        // x, y = x yatay, y = dikey

        driver.close();

    }

    @Test
    public void scrollToElement() throws InterruptedException {
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.id("sp-cc-accept")).click();
        WebElement germany = driver.findElement(By.linkText("Almanya"));

        // ask google --> how to scroll into view with js executor
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", germany);

        germany.click();

        Thread.sleep(2000);


    }
}
