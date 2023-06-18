package com.krafttechnologie.tests.day06_css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C09_Css_ParentToChild {
    public static void main(String[] args) throws InterruptedException {

        //for xpath '/' --> parent to child
        //for css '>'   --> parent to child

        //for xpath '//' --> parent to grandson
        //for css ' '    --> parent to grandson

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.krafttechexlab.com/login");

        Thread.sleep(2000);

        WebElement email = driver.findElement(By.cssSelector(".col-12:nth-of-type(1)>label"));
        System.out.println(email.getText());

        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.cssSelector(".row.g-3.needs-validation button"));
        System.out.println(loginButton.getText());

        driver.close();
    }
}
