package com.krafttechnologie.tests.day04_basic_locators;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class C04_TagNameLocator {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.krafttechexlab.com/login");

        driver.findElement(By.name("email")).sendKeys("mike@gmail.com");

        Thread.sleep(3000);

        driver.findElement(By.name("password")).sendKeys("mike1234");

        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();

        System.out.println(driver.findElement(By.tagName("h2")).getText());
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        Thread.sleep(3000);

        //driver.quit();


    }
}
