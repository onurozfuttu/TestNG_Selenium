package com.krafttechnologie.tests.day02_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.krafttechexlab.com");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        // closes the driver with close() method. it is closing the current tab.
        driver.close();

        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://www.amazon.com.tr");
        Thread.sleep(3000);

        // same as close() method. it quits the browser
        driver1.quit();
    }
}
