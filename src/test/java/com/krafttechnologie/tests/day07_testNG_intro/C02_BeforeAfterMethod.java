package com.krafttechnologie.tests.day07_testNG_intro;

import org.testng.annotations.*;

public class C02_BeforeAfterMethod {

    @BeforeMethod
    public void setup(){
        System.out.println("*** before method ***");
        System.out.println("WebDriver, Opening Browser");
    }

    @Test
    public void test1(){
        //System.out.println("WebDriver, Opening Browser");
        System.out.println("First Test Case");
        //System.out.println("Closing Browser, quit");
    }

    @Test
    public void test2(){
        //System.out.println("WebDriver, Opening Browser");
        System.out.println("Second Test Case");
        //System.out.println("Closing Browser, quit");
    }

    @Test @Ignore
    public void test3(){
        //System.out.println("WebDriver, Opening Browser");
        System.out.println("Third Test Case");
        //System.out.println("Closing Browser, quit");
    }

    @AfterMethod
    public void teardown(){
        System.out.println("*** after method ***");
        System.out.println("Closing Browser, quit");
    }

    @BeforeClass
    public void setupClass(){
        System.out.println("--- before class ---");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("--- after class ---");
    }
}
