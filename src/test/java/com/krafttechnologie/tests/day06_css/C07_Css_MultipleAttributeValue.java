package com.krafttechnologie.tests.day06_css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C07_Css_MultipleAttributeValue {
    public static void main(String[] args) throws InterruptedException {
        // There is only 'and' logic and no 'or' logic

        //go to https://www.krafttechexlab.com/forms/input

        //locate the Read Only/Disabled web element with multiple attribute-value by using css syntax
        //get the text and display

        //Seventh Formula
        //[attribute1='value'][attribute2='value']
        //tagName[attribute1='value'][attribute2='value']

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.krafttechexlab.com/forms/input");

        Thread.sleep(2000);

        WebElement readOnlyDisabled = driver.findElement(By.cssSelector("input[type='text'][value='Read only / Disabled']"));
        System.out.println(readOnlyDisabled.getAttribute("value"));

        WebElement readOnlyDisabled1 = driver.findElement(By.cssSelector("[type='text'][value='Read only / Disabled']"));
        System.out.println(readOnlyDisabled1.getAttribute("value"));

        driver.close();

    }
}
