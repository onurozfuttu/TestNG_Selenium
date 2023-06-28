package com.krafttechnologie.tests.day12_action_JS_FileUpload;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C03_FindUpload {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void fileUpload() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));
        //chooseFile.sendKeys("/Users/onur/Desktop/seleniumFileUpload.txt");
        chooseFile.sendKeys("/Users/onur/IdeaProjects/Batch4_TestNG_Selenium/src/test/resources/seleniumFileUpload.txt");

        driver.findElement(By.id("file-submit")).click();

        String actual = driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actual,"seleniumFileUpload.txt");

    }

    @Test
    public void fileUploadTestDemo() {
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("os.name"));
        //System.out.println(System.getenv("Path"));

        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/seleniumFileUpload.txt";

        String fullPath = projectPath+"/"+filePath;

        System.out.println(fullPath);

        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys(filePath);

        driver.findElement(By.id("file-submit")).click();

        String actual = driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actual,"seleniumFileUpload.txt");
    }

    @Test
    public void test_Homework() {

        /**  Hover class Task
         *      go to https://the-internet.herokuapp.com/hovers url
         *      and get "view profile" elements' text (all of them)
         *      and verify element is displayed (one by one)
         *
         *      hind: Use list and for loop
         */
    }
}
