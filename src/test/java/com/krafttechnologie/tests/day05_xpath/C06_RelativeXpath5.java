package com.krafttechnologie.tests.day05_xpath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C06_RelativeXpath5 {
    public static void main(String[] args) throws InterruptedException {
        //go to "https://www.krafttechexlab.com/forms/input"

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.krafttechexlab.com/forms/input");

        Thread.sleep(3000);

        //get the text webElement with the following features

        //1. parent to child  --> xpath/xpath
        WebElement text1 = driver.findElement(By.xpath("//div[@class='row mb-3'][1]/label"));
        System.out.println(text1.getText());

        //2. child to parent --> xpath/..
        WebElement text2 = driver.findElement(By.xpath("(//input[@type='text'])[1]/../../label"));
        System.out.println(text2.getText());

        //3. from sibling to previous sibling --> xpath/preceding-sibling::*
        WebElement text3 = driver.findElement(By.xpath("(//div[@class='col-sm-10'])[1]/preceding-sibling::*"));
        System.out.println(text3.getText());

        // //*[@for='inputPassword'] tüm elementleri tarar
        // //label[@*='inputPassword'] tag name i label olan bütün elementlerde bütün attributelarda value'su 'inputPassword'

        //4. from parent to grandson --> xpath//xpath    (double slash for grandson)
        WebElement text4 = driver.findElement(By.xpath("(//form[@method='post']//label)[1]"));
        System.out.println(text4.getText());

        driver.quit();

    }
}
