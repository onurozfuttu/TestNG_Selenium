package com.krafttechnologie.tests.day03_webelement_intro;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrlChanged {
    public static void main(String[] args) throws InterruptedException {
        /*
        Task
        Open Chrome browser
        go to https://www.krafttechxlab.com/login page
        enter email: mike@gmail.com
        enter password: mike1234
        click login button
        verify that url has changed
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.krafttechexlab.com/login");

        // enter email --> sendKeys()
        WebElement emailInputBox = driver.findElement(By.id("email"));
        emailInputBox.sendKeys("mike@gmail.com");

        // enter password --> sendKeys()
        WebElement passwordInputBox = driver.findElement(By.id("yourPassword"));
        passwordInputBox.sendKeys("mike1234");

        WebElement loginBtn = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        loginBtn.click();

        //Thread.sleep(2000);

        String expectedUrl = "https://www.krafttechexlab.com/index";
        String actualUrl = driver.getCurrentUrl();
        System.out.println("expectedUrl = " + expectedUrl);
        System.out.println("actualUrl = " + actualUrl);

        if (expectedUrl.equals(actualUrl)) {
            System.out.println("pass");
        }else System.out.println("fail");

        Thread.sleep(2000);
        driver.quit();
    }
}
