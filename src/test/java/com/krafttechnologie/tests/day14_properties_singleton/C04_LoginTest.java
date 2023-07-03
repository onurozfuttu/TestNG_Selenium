package com.krafttechnologie.tests.day14_properties_singleton;

import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class C04_LoginTest extends TestBase {


    @Test
    public void positiveLoginTest() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.cssSelector("#email")).sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(By.id("yourPassword")).sendKeys(ConfigurationReader.get("userPassword"));
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        Thread.sleep(3000);
    }

    @Test
    public void anotherLoginTest() {
        driver.get(ConfigurationReader.get("url"));
        WebElement userEmailInput = driver.findElement(By.cssSelector("#email"));
        WebElement userPassword = driver.findElement(By.id("yourPassword"));
        userEmailInput.sendKeys(ConfigurationReader.get("userEmail"));
        userPassword.sendKeys(ConfigurationReader.get("userEmail")+ Keys.TAB + Keys.TAB+ Keys.TAB +
                Keys.ENTER);

    }
}
