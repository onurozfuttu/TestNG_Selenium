package com.krafttechnologie.tests.day14_properties_singleton;

public class C02_Singleton {

   private C02_Singleton(){}
    private static String str;

   public static String getInstance(){
       if(str==null){
           System.out.println("str is null, assigning a value to it");
           //str="some value";
       }else{
           System.out.println("It has value, just returning it");
       }
       return str;
    }
}
