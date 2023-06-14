package com.krafttechnologie.tests.day05_xpath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C02_RelativeXpath1 {
    public static void main(String[] args) throws InterruptedException {
        //go to amazon.com
        //locate search bar with xpath
        //locate search button with xpath

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.amazon.com.tr");
        driver.manage().window().maximize();

        WebElement acceptCookies = driver.findElement(By.xpath("//input[@id='sp-cc-accept']"));
        acceptCookies.click();

        Thread.sleep(3000);

        WebElement searchBar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBar.sendKeys("selenium");
        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Git']"));
        searchButton.click();

        // Tagname[text()='word']   or // Tagname[.='word']
        WebElement seleniumElement = driver.findElement(By.xpath("//span[text()='\"selenium\"']"));
        WebElement seleniumElement2 = driver.findElement(By.xpath("//span[.='\"selenium\"']"));
        System.out.println(seleniumElement.getText());
        System.out.println(seleniumElement2.getText());

        driver.quit();

    }
}
