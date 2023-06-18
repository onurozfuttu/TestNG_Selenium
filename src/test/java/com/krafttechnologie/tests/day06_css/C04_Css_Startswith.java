package com.krafttechnologie.tests.day06_css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C04_Css_Startswith {
    public static void main(String[] args) throws InterruptedException {
        //go to https://www.krafttechexlab.com/login

        //locate the enterYourEmail&Password web element  with start-with by using css syntax
        //get the web element text and display

        //locate the doNotHaveAnAccount web element with start-with by using css syntax
        //get the web element text and display

        //Fourth Formula
        //[attribute^='firstParOfValue']
        //tagName[attribute^='firstParOfValue']

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.krafttechexlab.com/login");

        Thread.sleep(2000);

        WebElement enterYourEmail = driver.findElement(By.cssSelector("p[class^='t']"));
        System.out.println(enterYourEmail.getText());

        Thread.sleep(2000);

        WebElement doNotHaveAccount = driver.findElement(By.cssSelector("[class^='sm']"));
        System.out.println(doNotHaveAccount.getText());

        driver.close();
    }
}
