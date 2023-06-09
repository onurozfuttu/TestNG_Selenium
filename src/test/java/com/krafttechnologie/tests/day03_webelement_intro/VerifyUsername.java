package com.krafttechnologie.tests.day03_webelement_intro;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUsername {
    public static void main(String[] args) {
        /*
        Task
        Open Chrome browser
        go to https://www.krafttechxlab.com/login page
        enter email: mike@gmail.com
        enter password: mike1234
        click login button
        verify that username is "mike"

         */



        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.krafttechexlab.com/login");

        // enter username and password
        driver.findElement(By.id("email")).sendKeys("mike@gmail.com");
        driver.findElement(By.id("yourPassword")).sendKeys("mike1234");

        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();

        WebElement username = driver.findElement(By.cssSelector("[class=\"d-none d-md-block dropdown-toggle ps-2\"]"));
        System.out.println("username = " + username);

        /*
        2 ways to get text from web element
        getText() --> it works 99% and it returns String
        getAttribute() --> second way of getting text
         */

        String expectedUsername = "mike";
        String actualUsername = username.getText();

        if(expectedUsername.equals(actualUsername)){
            System.out.println("pass");
        }else System.out.println("fail");

        driver.quit();
    }
}
