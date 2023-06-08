package com.krafttechnologie.tests.day02_webdriver_basics;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    /*
    Task
    go to "https://www.krafttechexlab.com"
    use getDriver()
    verify that url is ""
     */
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.krafttechexlab.com/");
        String url = driver.getCurrentUrl();
        driver.quit();

        if(url.equals("https://www.krafttechexlab.com/")){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }
    }
}
