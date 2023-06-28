package com.krafttechnologie.tests.day13_webTables;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C01_WebTables {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        //Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void printTable() {
        //print whole table
        WebElement firstTable = driver.findElement(By.xpath("//table[@id='t01']"));
        System.out.println(firstTable.getText());
    }

    @Test
    public void getAllHeaders() {
        List<WebElement> firstTableHeaders = driver.findElements(By.xpath("//table[@id='t01']//th"));

        //number of colums
        System.out.println(firstTableHeaders.size());

        //print all column names
        for (int i = 0; i < firstTableHeaders.size(); i++) {
            System.out.println(firstTableHeaders.get(i).getText());
        }

    }

    @Test
    public void printTableSize(){
        //number of rows with header
        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='t01']//tr"));
        System.out.println(allRowsWithHeader.size());

        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='t01']//tr/td/.."));
        System.out.println(allRowsWithoutHeader.size());

    }

    @Test
    public void getRow(){
        //print the second row
       // WebElement row2 = driver.findElement(By.xpath("//table[@id='t01']//td[text()='Jemma']"));
        WebElement row2 = driver.findElement(By.xpath("(//table[@id='t01']//td/..)[2]"));
        System.out.println(row2.getText());

        System.out.println("---");

        //get all row dynamically and print them one by one(without header)
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='t01']//td/.."));
        for (WebElement element : allRowsWithoutHeader) {
            System.out.println(element.getText());
        }

        System.out.println("---");
        //get all row dynamically and print them one by one(without header) (with for index loop)
        for (int i = 1; i <= allRowsWithoutHeader.size(); i++) {
            WebElement element = driver.findElement(By.xpath("(//table[@id='t01']//td/..)["+i+"]"));
            System.out.println(element.getText());
        }

    }

    @Test
    public void getAllCellInOneRow(){
        //get all cell of first row
        List<WebElement> allCellsInOneRow = driver.findElements(By.xpath("(//table[@id='t01']//td/..)[1]/td"));
        for (WebElement element : allCellsInOneRow) {
            System.out.println(element.getText());
        }
    }

    @Test
    public void getASingleCellInOneRow(){
        WebElement element = driver.findElement(By.xpath("(//table[@id='t01']//td/..)[1]/td[3]"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.xpath("(//table[@id='t01']//td/..)[2]/td[2]"));
        System.out.println(element1.getText());
    }

    @Test
    public void printAllCellsByIndex(){
        //we would like to write a code that it will print all cells one by one


        int rowNumber = getNumberOfRows();
        int columnNumber = getNumberOfColumns();

        for (int i = 1; i <= rowNumber; i++) {

            for (int j = 1; j <= columnNumber; j++) {
                WebElement element = driver.findElement(By.xpath("(//table[@id='t01']//td/..)["+i+"]/td["+j+"]"));
                System.out.println(element.getText());
            }
        }


    }

    private int getNumberOfRows() {
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='t01']//td/.."));
        int rowNumber = allRowsWithoutHeader.size();
        return rowNumber;
    }

    private int getNumberOfColumns() {
        List<WebElement> firstTableHeaders = driver.findElements(By.xpath("//table[@id='t01']//th"));
        int columNumber = firstTableHeaders.size();
        return columNumber;
    }



    //here is the method that we aimed to reach during the whole evening
    private WebElement getSpecificCell(int row, int column){
        WebElement element = driver.findElement(By.xpath("(//table[@id='t01']//td/..)["+row+"]/td["+column+"]"));
        return element;
    }

    @Test
    public void test(){
        //verify that value of 3rd row and 2nd cell is 'Doe'
        WebElement doeElement= getSpecificCell(3,2);
        Assert.assertEquals(doeElement.getText(),"Doe");
    }
}
