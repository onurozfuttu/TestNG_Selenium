package com.krafttechnologie.tests.day04_basic_locators;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C06_LinkTextAndPartialLinkText {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading");

        WebElement example1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden"));
        example1.click();

        String actualText = driver.findElement(By.tagName("h3")).getText();
        String expectedText = "Dynamically Loaded Page Elements";


        if(actualText.equals(expectedText)){
            System.out.println("pass");
        }else System.out.println("fail");

        driver.navigate().back();

        WebElement partialh4 = driver.findElement(By.partialLinkText("Example 1"));
        partialh4.click();

        driver.close();
    }
}
