package com.krafttechnologie.tests.day08_typeOfWebElements;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C05_DisplayedDemo {

    @Test
    public void displayedTest1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement hello = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        System.out.println(hello.isDisplayed());

        Assert.assertFalse(hello.isDisplayed());

        WebElement startBtn = driver.findElement(By.xpath("//button[text()='Start']"));
        startBtn.click();
        Thread.sleep(6000);
        Assert.assertTrue(hello.isDisplayed());
        System.out.println(hello.isDisplayed());

        driver.close();
    }

    @Test
    public void displayedTest2() {
        /**  HOME TASK
         https://the-internet.herokuapp.com/dynamic_loading
         Example 2: Element rendered after the fact -->click
         click that element
         verify that hello world is not displayed
         click start button
         verify that hello element is displayed
         and verify that "Hello World!" text is present
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading/1");

    }
}
