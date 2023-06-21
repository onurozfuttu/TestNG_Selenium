package com.krafttechnologie.tests.day09_findElements_dropdowns;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class C02_DropDownWithSelectTag {
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
    public void test_getOptions() {
        // Old Style Select Menu
        // go to https://demoqa.com/select-menu
        // get all options(web elements) as a list
        // verify that the number of webElement is 11

        //locate the dropdown menu
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));

        //create a select object to manipulate the dropdown menu
        Select select = new Select(dropDownMenu);

        //get all the webElements in the dropdown menu by using getOptions() method
        List<WebElement> options = select.getOptions();

        System.out.println(options.size());

        //verify the size of list
        Assert.assertTrue(options.size() == 11);

    }

    @Test
    public void test_selectByVisibleText(){
        // Old Style Select Menu
        // get the blue thru visible text option and make verification


        //locate the dropdown menu
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));

        //create a select object to manipulate the dropdown menu
        Select select = new Select(dropDownMenu);

        //select the blue option with visible text
        select.selectByVisibleText("Blue");


        //get the selected webElement and put into a webElement bucket by getFirstSelectedOption()
        WebElement selectedElement = select.getFirstSelectedOption();

        //verify that the visible text is Blue
        String actualText = selectedElement.getText();
        String expectedText = "Blue";
        Assert.assertEquals(actualText,expectedText);

    }

    @Test
    public void test_selectByIndexNumber(){
        // Old Style Select Menu
        // get the green option thru visible index number and make verification

        //locate the dropdown menu
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));

        //create a select object to manipulate the dropdown menu
        Select select = new Select(dropDownMenu);

        //select the webElement based on the index number
        select.selectByIndex(2);

        WebElement firstSelectedOption = select.getFirstSelectedOption();
        String actualText = firstSelectedOption.getText();
        String expectedText = "Green";

        Assert.assertEquals(actualText,expectedText);

    }

    @Test
    public void test_selectByValueAttribute() throws InterruptedException {
        //locate the dropdown menu
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));

        //create a select object to manipulate the dropdown menu
        Select select = new Select(dropDownMenu);

        select.selectByValue("7");

        Thread.sleep(3000);

        WebElement firstSelectedOption = select.getFirstSelectedOption();
        String actualText = firstSelectedOption.getText();
        String expectedText = "Voilet";

        Assert.assertEquals(actualText,expectedText);
    }
}
