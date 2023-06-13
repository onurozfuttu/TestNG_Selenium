package com.krafttechnologie.tests.day04_basic_locators.Tasks;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task3 {
    public static void main(String[] args) throws InterruptedException {
        /*
         * HW TASK 3
         * open chrome browser
         * go to https://demoqa.com/login
         * enter "test" into the username box
         * enter "Test.!123" into the password box
         * tap on login button
         * VERIFY that url is changed as "https://demoqa.com/profile"
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://demoqa.com/login");
        driver.findElement(By.id("userName")).sendKeys("test");
        driver.findElement(By.id("password")).sendKeys("Test.!123");

        Thread.sleep(1000);

        driver.findElement(By.id("login")).click();

        Thread.sleep(3000);

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://demoqa.com/profile";

        driver.close();

        if(actualUrl.equals(expectedUrl)){
            System.out.println("pass");
        }else System.out.println("fail");

    }
}
