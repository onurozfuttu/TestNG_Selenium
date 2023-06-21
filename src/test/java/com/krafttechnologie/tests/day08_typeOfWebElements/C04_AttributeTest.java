package com.krafttechnologie.tests.day08_typeOfWebElements;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class C04_AttributeTest {

    @Test
    public void aTest() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://demoqa.com/text-box");

        WebElement userInputBox = driver.findElement(By.cssSelector("#userName"));
        System.out.println(userInputBox.getAttribute("id"));
        System.out.println(userInputBox.getAttribute("autocomplete"));
        System.out.println(userInputBox.getAttribute("placeholder"));
        System.out.println(userInputBox.getAttribute("type"));
        System.out.println(userInputBox.getAttribute("class"));

        System.out.println(userInputBox.getAttribute("outerHTML"));
        //System.out.println(userInputBox.getAttribute("innerHTML"));

        Thread.sleep(2000);
        driver.close();


    }
}
