package com.krafttechnologie.tests.day07_testNG_intro;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C03_TestNGAnnotationsDemo {

    @BeforeMethod
    public void setUp() {
        System.out.println("Open Browser");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Close Browser");
    }

    @Test
    public void test1() {
        System.out.println("First Assertion");
        Assert.assertEquals("Title","Title");
        // test fail olduğunda devam etmez

        System.out.println("Second Assertion");
        Assert.assertEquals("url","url");
    }

    @Test
    public void test2() {
        System.out.println("Third Assertion");
        Assert.assertEquals("test2","test2");

    }

    @Test
    public void test3() {
        String expectedTitle = "1kraft";
        String actualTitle = "kraft1";
        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"verify that title starting with tech");
    }

    @Test
    public void test4() {
        //verify that email contains "@" sign
        String email = "test@test.com";
        /*if(email.contains("@")){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }
         */

        Assert.assertTrue(email.contains("@"),"Verify that email contains @ sign");
    }

    @Test
    public void test5() {
        // test sonucunun false olması gerekiyor
        Assert.assertFalse(0<1,"Verify that = is not greater than 1");
    }

    @Test
    public void test6() {
        // eşitse sonucu kalır
        Assert.assertNotEquals("two","two");
    }
}
