package com.krafttechnologie.tests.day06_css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C10_Css_Siblings {
    public static void main(String[] args) throws InterruptedException {

        //Tenth formula
        //cssSyntax~~Tagname

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.krafttechexlab.com/login");

        Thread.sleep(2000);

        WebElement emailBox = driver.findElement(By.cssSelector("label[for='email']~input"));
        emailBox.sendKeys("test@test.com");

        Thread.sleep(2000);

        driver.close();
    }
}
