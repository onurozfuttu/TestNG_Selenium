package com.krafttechnologie.tests.day06_css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C05_Css_EndsWith {
    public static void main(String[] args) throws InterruptedException {
        //go to https://www.krafttechexlab.com/login

        //locate the rememberMe web element with ends-with by using css syntax
        //get the text and display

        //locate the designedByAfm web element with ends-with by using css syntax
        //get the text and display

        //Fifth Formula
        //[attribute$='lastPartOfValue']
        //tagName[attribute$='lastPartOfValue']

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.krafttechexlab.com/login");

        Thread.sleep(2000);

        WebElement rememberMe = driver.findElement(By.cssSelector("label[for$='Me']"));
        System.out.println(rememberMe.getText());

        Thread.sleep(2000);

        WebElement designedByaFm = driver.findElement(By.cssSelector("[class$='ts']"));
        System.out.println(designedByaFm.getText());

        driver.quit();


    }
}
