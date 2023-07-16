package com.krafttechnologie.pages;

import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//li[contains(@class, 'nav-item dropdown')]")
    public List<WebElement> upTitles;

    @FindBy(css = "[class='d-none d-md-block dropdown-toggle ps-2']")
    public WebElement userAccountName;

    public void navigateToModule(String menu){
        String locator ="//span[text()='"+menu+"']";
        Driver.get().findElement(By.xpath(locator)).click();
    }

    //method OVERLOADING
    public void navigateToModule(String tab, String module){
        String locator ="//span[text()='"+tab+"']";
        Driver.get().findElement(By.xpath(locator)).click();

        BrowserUtils.waitFor(2);

        String locator2 = "//span[text()='"+module+"']";
        WebElement moduleElement = Driver.get().findElement(By.xpath(locator2));
        BrowserUtils.clickWithJS(moduleElement);
    }

    public String getUserAccountName(){
        return userAccountName.getText();
    }



}
