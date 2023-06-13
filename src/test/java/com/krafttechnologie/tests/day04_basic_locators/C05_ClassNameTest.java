package com.krafttechnologie.tests.day04_basic_locators;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class C05_ClassNameTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.krafttechexlab.com/");

        System.out.println(driver.findElement(By.className("pagetitle")).getText());
        System.out.println(driver.findElement(By.className("footer")).getText());

        // class isminde boşluk varsa almaz, NoSuchElementException
        //System.out.println(driver.findElement(By.className("header fixed-top d-flex align-items-center")).getText());

        driver.close();
    }
}
