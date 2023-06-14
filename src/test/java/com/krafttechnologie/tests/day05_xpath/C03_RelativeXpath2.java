package com.krafttechnologie.tests.day05_xpath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C03_RelativeXpath2 {
    public static void main(String[] args) throws InterruptedException {
        //go to https://www.krafttechexlab.com/forms/input

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.krafttechexlab.com/forms/input");
        driver.manage().window().maximize();

        Thread.sleep(3000);

        //locate the web element with starts-with(@attribute, value(enough))
        WebElement passwordElement = driver.findElement(By.xpath("//label[starts-with(@for,'inputP')]"));
        System.out.println(passwordElement.getText());

        WebElement password1 = driver.findElement(By.xpath("//label[starts-with(text(), 'P')]"));
        System.out.println(password1.getText());

        //ends-with olanı da vardır ancak chrome ve safari ile çalışmıyor

        driver.quit();
    }
}
