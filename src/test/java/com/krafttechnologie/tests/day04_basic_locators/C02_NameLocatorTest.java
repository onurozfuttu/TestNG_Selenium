package com.krafttechnologie.tests.day04_basic_locators;

import com.github.javafaker.Faker;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class C02_NameLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        Faker faker = new Faker();

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.krafttechexlab.com/login");
        driver.findElement(By.name("email")).sendKeys(faker.internet().emailAddress());

        Thread.sleep(3000);

        driver.findElement(By.name("password")).sendKeys(faker.internet().password());

        Thread.sleep(3000);

        driver.quit();
    }
}
