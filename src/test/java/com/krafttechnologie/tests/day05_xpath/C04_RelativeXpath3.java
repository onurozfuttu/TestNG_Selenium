package com.krafttechnologie.tests.day05_xpath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C04_RelativeXpath3 {

    public static void main(String[] args) throws InterruptedException {
        //go to https://www.krafttechexlab.com/forms/elements

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.krafttechexlab.com/forms/elements");
        driver.manage().window().maximize();

        Thread.sleep(3000);

        WebElement colorPicker = driver.findElement(By.xpath("//label[contains(@for,'tC')]"));
        System.out.println(colorPicker.getText());

        WebElement colorPickerText = driver.findElement(By.xpath("//label[contains(text(),'Pi')]"));
        System.out.println(colorPickerText.getText());

        driver.quit();

    }
}
