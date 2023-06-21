package com.krafttechnologie.tests.day08_typeOfWebElements;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_CheckBoxDemo {

    @Test
    public void checkBoxDemoTest() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://demoqa.com/automation-practice-form");

        WebElement sports = driver.findElement(By.cssSelector("input[id='hobbies-checkbox-1']"));
        WebElement reading = driver.findElement(By.cssSelector("input[id='hobbies-checkbox-2']"));
        WebElement music = driver.findElement(By.cssSelector("input[id='hobbies-checkbox-3']"));

        Assert.assertFalse(sports.isSelected());
        Assert.assertFalse(reading.isSelected());
        Assert.assertFalse(music.isSelected());

        WebElement sportsCheckBox = driver.findElement(By.xpath("//div[@id='hobbiesWrapper']/div[2]/div[1]"));
        sportsCheckBox.click();
        Thread.sleep(2000);
        Assert.assertTrue(sports.isSelected());

        driver.close();
    }
}
