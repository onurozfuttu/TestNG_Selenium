package com.krafttechnologie.tests.day03_webelement_intro;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttribute {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.krafttechexlab.com/login");

        WebElement emailInputBox = driver.findElement(By.id("email"));

        // getAttribute() --> it gives the attribute that value i shared

        String value = emailInputBox.getAttribute("class");
        String value2 = emailInputBox.getAttribute("type");
        System.out.println("value = " + value);

        driver.quit();

    }
}
