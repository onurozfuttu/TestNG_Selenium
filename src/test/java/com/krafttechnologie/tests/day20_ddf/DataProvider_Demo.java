package com.krafttechnologie.tests.day20_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Demo {

    @DataProvider
    public Object[][] tvAndRating(){
        String[][] data = {
                {"Chernobyl","10"},
                {"Breaking Bad", "10"},
                {"Prison Break", "9"},
                {"Fringe", "8"},
                {"Person Of Interest", "9"},
                {"La Casa De Papel", "8"}
        };
        return data;
    }

    @Test(dataProvider = "tvAndRating")
    public void testTvShows(String tvShow, String rating){
        System.out.println("Tv show " + tvShow + " has rating " + rating);
    }
}
