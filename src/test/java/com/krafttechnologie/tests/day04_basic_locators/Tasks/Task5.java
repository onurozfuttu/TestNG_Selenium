package com.krafttechnologie.tests.day04_basic_locators.Tasks;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task5 {

    public static void main(String[] args) throws InterruptedException {
        /*
         * Hw TASK 5
         * open chrome browser
         * go to https://demoqa.com/login
         * enter "test" into the username box
         * VERIFY that "test" is displayed in the username box
         * enter "Test.!123" into the password box
         * tap on login button
         * VERIFY that username is still "test"
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://demoqa.com/login");

        WebElement usernameInput = driver.findElement(By.id("userName"));
        usernameInput.sendKeys("test");

        String actualUsername = driver.findElement(By.tagName("input")).getAttribute("value");
        String expectedUsername = "test";

        if(actualUsername.equals(expectedUsername)){
            System.out.println("username passed");
        }else System.out.println("username failed");

        driver.findElement(By.id("password")).sendKeys("Test.!123");

        driver.findElement(By.id("login")).click();

        Thread.sleep(3000);

        String actualUsernameInProfile = driver.findElement(By.id("userName-value")).getText();
        String expectedUsernameInProfile = "test";

        if(actualUsernameInProfile.equals(expectedUsernameInProfile)){
            System.out.println("username in profile passed");
        }else System.out.println("username in profile failed");

        driver.close();
    }
}
