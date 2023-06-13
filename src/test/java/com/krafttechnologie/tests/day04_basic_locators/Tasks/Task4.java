package com.krafttechnologie.tests.day04_basic_locators.Tasks;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task4 {
    public static void main(String[] args) throws InterruptedException {
        /*
         * HW TASK 4
         * open chrome browser
         * go to https://demoqa.com/login
         * click on login button
         * VERIFY that url is not changed
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://demoqa.com/login");
        Thread.sleep(2000);
        driver.findElement(By.id("login")).click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://demoqa.com/login";

        driver.close();

        if(actualUrl.equals(expectedUrl)){
            System.out.println("pass");
        }else System.out.println("fail");

    }
}
