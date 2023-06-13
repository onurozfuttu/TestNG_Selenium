package com.krafttechnologie.tests.day04_basic_locators.Tasks;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task2 {
    public static void main(String[] args) {
        /** Class Task
         *  go to the amazon webpage
         *  write "selenium" to search box
         *  verify that the result of the search
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.amazon.com");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("selenium");
        driver.findElement(By.id("nav-search-submit-button")).click();

        String actualStr = driver.findElement(By.xpath("//span[@class=\"a-color-state a-text-bold\"]")).getText();
        actualStr = actualStr.replace("\"","");
        System.out.println(actualStr);
        String expectedStr = "selenium";

        if(actualStr.equals(expectedStr)){
            System.out.println("pass");
        }else System.out.println("fail");

        driver.close();
    }
}
