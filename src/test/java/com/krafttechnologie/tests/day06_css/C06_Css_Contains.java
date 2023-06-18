package com.krafttechnologie.tests.day06_css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C06_Css_Contains {
    public static void main(String[] args) throws InterruptedException {
        //go to https://www.krafttechexlab.com/login

        //locate the email web element with contains by using css syntax
        //get the text and display

        //locate the password web element with contains by using css syntax
        //get the text and display

        //Sixth Formula
        //[attribute*='value']
        //tagName[attribute*='value']

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.krafttechexlab.com/login");

        Thread.sleep(2000);

        WebElement emailText = driver.findElement(By.cssSelector("label[for*='ai']"));
        System.out.println(emailText.getText());

        WebElement passwordText = driver.findElement(By.cssSelector("[for*='rP']"));
        System.out.println(passwordText.getText());

        driver.close();
    }
}
