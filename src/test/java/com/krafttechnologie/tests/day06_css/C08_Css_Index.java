package com.krafttechnologie.tests.day06_css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C08_Css_Index {
    public static void main(String[] args) throws InterruptedException {

        //Eight Formula
        //cssSyntax:nth-of-type(indexNumber)
        //NOTE: It works only if the webElements are under the same parent

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.krafttechexlab.com/login");

        Thread.sleep(2000);

        WebElement emailAsWhole = driver.findElement(By.cssSelector(".col-12:nth-of-type(1)"));

        WebElement passwordAsWhole = driver.findElement(By.cssSelector(".col-12:nth-of-type(2)"));

        WebElement loginAsWhole = driver.findElement(By.cssSelector(".col-12:nth-of-type(4)"));
    }
}
