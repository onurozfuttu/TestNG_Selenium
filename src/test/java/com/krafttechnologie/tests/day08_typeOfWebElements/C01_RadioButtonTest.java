package com.krafttechnologie.tests.day08_typeOfWebElements;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C01_RadioButtonTest {
    @Test
    public void radioBtnIsSelected() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://demo.aspnetawesome.com/");

        WebElement vegetablesRadio = driver.findElement(By.xpath("//div[text()='Vegetables']/../input"));

        System.out.println(vegetablesRadio.isSelected());

        Assert.assertTrue(vegetablesRadio.isSelected(),"Verify that 'vegetables' radio is selected default");

        /*
        verify that legumes is NOT selected
        click legumes
        verify that legumes is selected
        verify that vegetables is NOT selected
         */

        WebElement legumes = driver.findElement(By.xpath("//div[text()='Legumes']/../input"));
        Assert.assertFalse(legumes.isSelected());
        driver.findElement(By.xpath("//div[text()='Legumes']/../div")).click();
        Assert.assertTrue(legumes.isSelected());
        Assert.assertFalse(vegetablesRadio.isSelected());

        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void checkBoxIsSelected() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        Assert.assertTrue(checkbox2.isSelected());
        Assert.assertFalse(checkbox1.isSelected());

        Thread.sleep(3000);

        checkbox1.click();
        Thread.sleep(3000);
        checkbox2.click();

        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertFalse(checkbox2.isSelected());

        driver.close();

    }
}
