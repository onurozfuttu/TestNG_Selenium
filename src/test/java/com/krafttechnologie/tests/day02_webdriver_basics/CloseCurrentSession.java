package com.krafttechnologie.tests.day02_webdriver_basics;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CloseCurrentSession {
    public static void main(String[] args) {
        // added in day 4

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.facebook.com");

        driver.close();

        // close ile kapandığı için session exception atar
        driver.get("https://www.facebook.com");
    }
}
