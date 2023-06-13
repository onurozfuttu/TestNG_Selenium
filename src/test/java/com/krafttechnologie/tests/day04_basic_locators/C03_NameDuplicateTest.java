package com.krafttechnologie.tests.day04_basic_locators;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class C03_NameDuplicateTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://demo.aspnetawesome.com/");

        Thread.sleep(3000);
        driver.findElement(By.id("btnCookie")).click();

        System.out.println(driver.findElement(By.name("itemParentCat")).getAttribute("name"));

        driver.close();
    }
}
