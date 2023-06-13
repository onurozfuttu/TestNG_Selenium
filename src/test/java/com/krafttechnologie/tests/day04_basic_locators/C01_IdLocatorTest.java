package com.krafttechnologie.tests.day04_basic_locators;

import com.github.javafaker.Faker;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C01_IdLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        Faker faker = new Faker();


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://demoqa.com/text-box");

        WebElement inputUsername = driver.findElement(By.id("userName"));
        //inputUsername.sendKeys("Jake");
        inputUsername.sendKeys(faker.name().firstName());

        WebElement emailInput = driver.findElement(By.id("userEmail"));
        //emailInput.sendKeys("loremipsum@hotmail.com");
        emailInput.sendKeys(faker.internet().emailAddress());

        Thread.sleep(3000);

        driver.close();
    }
}
