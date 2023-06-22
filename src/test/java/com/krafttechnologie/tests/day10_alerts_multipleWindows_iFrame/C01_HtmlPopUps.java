package com.krafttechnologie.tests.day10_alerts_multipleWindows_iFrame;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C01_HtmlPopUps {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=73437");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test_htmlPopUp() throws InterruptedException {
        WebElement confirmBtn = driver.findElement(By.xpath("(//span[text()='Confirm'])[1]"));
        confirmBtn.click();
        Thread.sleep(2000);

        WebElement yesBtn = driver.findElement(By.xpath("(//span[.='Yes'])"));
        yesBtn.click();
        Thread.sleep(2000);

        WebElement confirmPopUp = driver.findElement(By.xpath("//p[.='You have accepted']"));
        String actualEl = confirmPopUp.getText();
        String expectedEl = "You have accepted";

        Assert.assertEquals(actualEl,expectedEl);
    }
}
