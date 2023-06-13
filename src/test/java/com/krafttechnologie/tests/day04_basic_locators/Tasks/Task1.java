package com.krafttechnologie.tests.day04_basic_locators.Tasks;

import com.github.javafaker.Faker;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        /** Class Task- Home work
         *  go to the url -  "https://www.browserstack.com/users/sign_up"
         *  maximize the window
         *  accept cookies if any ,
         *  fill in the blanks with the faker class
         *  click "Term of service" checkbox
         *  and close the window
         *
         *  hint: u can use any locator you want
         *
         */

        Faker faker = new Faker();

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.browserstack.com/users/sign_up");

        driver.manage().window().maximize();

        driver.findElement(By.id("accept-cookie-notification")).click();

        driver.findElement(By.id("user_full_name")).sendKeys(faker.name().fullName());
        driver.findElement(By.id("user_email_login")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("user_password")).sendKeys(faker.internet().password());

        driver.findElement(By.id("tnc_checkbox")).click();

        Thread.sleep(3000);

        driver.close();

    }
}
