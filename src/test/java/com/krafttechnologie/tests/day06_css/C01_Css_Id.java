package com.krafttechnologie.tests.day06_css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C01_Css_Id {
    public static void main(String[] args) throws InterruptedException {
        //go to https://www.krafttechexlab.com/login
        //locate the email box with id by using css syntax
        //send "test@test.com" into the box

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.krafttechexlab.com/login");

        Thread.sleep(3000);

        //First Formula
        //#id
        //tagname#id

        WebElement emailButton = driver.findElement(By.cssSelector("#email")); //or input#email
        emailButton.sendKeys("test@test.com");

        Thread.sleep(3000);

        driver.close();
    }
}
