package com.krafttechnologie.tests.day10_alerts_multipleWindows_iFrame;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C04_iFrame {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test_iframe_NameOrId() {
        //we will be able to locate this element since it is in the defaul HTML
        WebElement upTitle = driver.findElement(By.xpath("//textarea[@id='mce_0']/../h3"));
        System.out.println(upTitle.getText());

        //we will not be able to locate this element since it is in another HTML/frame
        /*WebElement targetElement = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        System.out.println(targetElement.getText());
        */

        //switch driver to the target html block
        driver.switchTo().frame("mce_0_ifr");
        WebElement targetElement = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        System.out.println(targetElement.getText());

        //switch driver to parent(default) html
        driver.switchTo().parentFrame();
        WebElement upTitle1 = driver.findElement(By.xpath("//textarea[@id='mce_0']/../h3"));
        System.out.println(upTitle1.getText());
    }

    @Test
    public void test_iFrame_Index() {
        driver.switchTo().frame(0);
        WebElement targetElement = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        targetElement.clear();
        targetElement.sendKeys("iframe");
    }

    @Test
    public void test_iFrame_WebElement() {
        WebElement frame = driver.findElement(By.cssSelector("#mce_0_ifr"));
        // switch driver by webelement
        driver.switchTo().frame(frame);

        WebElement targetElement = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        targetElement.clear();
        targetElement.sendKeys("Webelement kullanarak değiştirildi");
    }
}
