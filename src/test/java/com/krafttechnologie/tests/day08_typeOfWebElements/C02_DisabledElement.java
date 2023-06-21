package com.krafttechnologie.tests.day08_typeOfWebElements;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C02_DisabledElement {
    /*
    What is disabled element?
    You can NOT interact with this element
     */

    @Test
    public void disabledElement() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_controls");

        Thread.sleep(3000);

        WebElement disabledElement = driver.findElement(By.cssSelector("#input-example>input"));
        Assert.assertFalse(disabledElement.isEnabled());


        driver.findElement(By.cssSelector("#input-example>button")).click();
        Thread.sleep(3000);

        Assert.assertTrue(disabledElement.isEnabled());

        driver.close();


    }
}
