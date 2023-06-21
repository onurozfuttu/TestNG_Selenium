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

public class C01_ListOfElements {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.krafttechexlab.com/javascript/clicks");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void findElementsWithCorrectFormula() throws InterruptedException {
        /*
         go to https://www.krafttechexlab.com/javascript/clicks
         get all buttons into a list
         click on third button*/


        List<WebElement> listButtons = driver.findElements(By.cssSelector(".btn.btn-primary"));

        //assert that the size is 4
        System.out.println(listButtons.size());
        Assert.assertTrue(listButtons.size() == 4);

        //verify that the text of 4th element is Mouse Down / Up
        String actual = listButtons.get(3).getText();
        String expected = "Mouse Down / Up";

        Assert.assertEquals(actual,expected);

        //verify that the text of 3rd element is Click Me
        String actualBtn = listButtons.get(2).getText();
        String expectedBtn = "Click Me";
        Assert.assertEquals(actualBtn,expectedBtn);

    }

    @Test
    public void findElementsWithoutCorrectFormula() throws InterruptedException {
        /*
         go to https://www.krafttechexlab.com/javascript/clicks
         try to locate any web element with findElements() method with a wrong formula
         see how it behaves*/


        //if locator formula is wrong it returns 0 element
        List<WebElement> wrongFormula = driver.findElements(By.xpath("wrongFormula"));
        System.out.println(wrongFormula.size());

        //verify that size is equal to zero
        //Assert.assertTrue(wrongFormula.size() == 0);
        Assert.assertTrue(wrongFormula.isEmpty());

    }
}
