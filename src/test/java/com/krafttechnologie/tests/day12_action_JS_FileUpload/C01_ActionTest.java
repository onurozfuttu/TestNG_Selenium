package com.krafttechnologie.tests.day12_action_JS_FileUpload;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C01_ActionTest {

    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void hoverOver() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        //Actions --> class that contains all the user interaction
        Actions actions = new Actions(driver);
        //Thread.sleep(2000);
        //moveElement() --> move your cursor to the web element
        // perform() --> performs action, complete the action
        actions.moveToElement(img2).perform();
        WebElement viewProfile1 = driver.findElement(By.linkText("View profile"));
        System.out.println(viewProfile1.getText());
        Assert.assertTrue(viewProfile1.isDisplayed(),"verify that element is displayed");

    }

    @Test
    public void dragAndDrop() {
        driver.get("https://demoqa.com/droppable");

        WebElement source = driver.findElement(By.id("draggable"));

        WebElement target = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        // Actions actions = new Actions(driver); globale alındı
        actions.dragAndDrop(source,target).perform();

        WebElement droppedElement = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        Assert.assertTrue(droppedElement.isDisplayed());
        Assert.assertEquals(droppedElement.getText(),"Dropped!", "verify that element has dropped");

    }

    @Test
    public void dragAndDrop2() {
        driver.get("https://demoqa.com/droppable");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        //Actions actions = new Actions(driver); -globale alındı
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();

        WebElement droppedElement = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        Assert.assertTrue(droppedElement.isDisplayed());
        Assert.assertEquals(droppedElement.getText(),"Dropped!", "verify that element has dropped");

    }
}
