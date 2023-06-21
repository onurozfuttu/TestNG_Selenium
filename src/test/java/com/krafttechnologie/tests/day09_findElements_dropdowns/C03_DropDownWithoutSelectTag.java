package com.krafttechnologie.tests.day09_findElements_dropdowns;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class C03_DropDownWithoutSelectTag {
    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test_getOneOptionsWithoutFindElement(){
        // locate the "Select Title" web element
        // click on it
        // click on 'Mrs.'

        WebElement dropDownMenu = driver.findElement(By.xpath("//div[text()='Select Title']"));
        dropDownMenu.click();

        //locate the 'Mrs' webElement
        WebElement optionInDropDown = driver.findElement(By.xpath("//div[@id='react-select-3-option-0-2']"));
        optionInDropDown.click();
        WebElement targetWebElement = driver.findElement(By.xpath("//div[@class=' css-1uccc91-singleValue']"));
        String targetWebElementText = targetWebElement.getText();
        String expectedWebElementText = "Mrs.";
        Assert.assertEquals(targetWebElementText,expectedWebElementText);

    }

    @Test
    public void test_getAllOptionsWithFindElements() throws InterruptedException {
        WebElement dropDownMenu = driver.findElement(By.xpath("//div[text()='Select Title']"));
        dropDownMenu.click();

        //put all webElements into a list by findElements()
        List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@id,'react-select-3-option')]"));

        System.out.println(elements.size());

        //verification
        Assert.assertTrue(elements.size() == 6);

        Thread.sleep(3000);
        //click on other
        //elements.get(5).click();
    }
}
