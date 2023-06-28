package com.krafttechnologie.tests.day11_waits;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C03_ExplicitWaitExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        //setup once, all the findelement will use this wait
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //Wait wait = new WebDriverWait(driver,15); --> burada da kullanılabilir

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void explicitWaitExampletest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start>button")).click();

        //how to wait explicity?
        WebDriverWait wait = new WebDriverWait(driver,15);

        WebElement hello = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        //it will wait up to 15 seconds until hello element is visible
        wait.until(ExpectedConditions.visibilityOf(hello));
        System.out.println(hello.getText());

        Assert.assertEquals(hello.getText(),"Hello World!");
    }

    @Test
    public void explicitWaitExampleTest2(){
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_controls");


        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        Wait wait = new WebDriverWait(driver,15);
        //driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Test1234");
        WebElement inputBox = driver.findElement(By.cssSelector("input[type='text']"));
        // sendKeys? wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        inputBox.sendKeys("Test12345");

        WebElement message = driver.findElement(By.id("message"));
        Assert.assertEquals(message.getText(),"It's enabled!");

    }
}
