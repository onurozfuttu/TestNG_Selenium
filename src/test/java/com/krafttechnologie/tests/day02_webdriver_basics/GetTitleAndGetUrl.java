package com.krafttechnologie.tests.day02_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndGetUrl {
    /*
        Task
        Open chrome and navigate to https://www.krafttechexlab.com
        Get title and display
         */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.krafttechexlab.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());


        // getting the url
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        // getting the source code of the page
        System.out.println(driver.getPageSource());
    }
}
