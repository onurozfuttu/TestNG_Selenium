package com.krafttechnologie.tests.day03_webelement_intro;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrlIsNotChanged {
    public static void main(String[] args) throws InterruptedException {
        /*
        Open the Chrome browser
        go to the page: http://www.krafttechexlab.com/
        click on the login button
        verify that url is not changed
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("http://www.krafttechexlab.com/login");

        String expectedUrl = driver.getCurrentUrl();
        System.out.println("expectedUrl = " + expectedUrl);

        //click on the login button
        WebElement loginBtn = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        loginBtn.click();

        String actualUrl = driver.getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);

        if(expectedUrl.equals(actualUrl)){
            System.out.println("pass");
        }else System.out.println("fail");

        Thread.sleep(3000);
        driver.quit();
    }
}
