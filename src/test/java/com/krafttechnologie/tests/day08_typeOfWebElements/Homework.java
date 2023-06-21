package com.krafttechnologie.tests.day08_typeOfWebElements;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework {

    @Test
    public void testHomework() throws InterruptedException {
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
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading");

        Thread.sleep(1500);
        driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
        Thread.sleep(1500);


        WebElement helloWorld = driver.findElement(By.xpath("//div[@class='example']/div"));
        System.out.println(helloWorld.getAttribute("finish"));
        Assert.assertTrue(helloWorld.isDisplayed());

        driver.findElement(By.xpath("//div[@id='start']/button")).click();
        Thread.sleep(6500);
        WebElement clickedHelloWorld = driver.findElement(By.xpath("//div[@class='example']/div/h4"));
        Assert.assertTrue(clickedHelloWorld.isDisplayed());
        System.out.println(clickedHelloWorld.getText());


        driver.quit();
    }
}
