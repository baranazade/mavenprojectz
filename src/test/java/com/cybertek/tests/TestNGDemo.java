package com.cybertek.tests;

import org.testng.annotations.Test;

public class TestNGDemo {

    @Test // we imported
    //in testNg always use void no static or return
    public void testOne(){
        System.out.println("Hello World");

        String expected  = "a" ;
        String actual = "B" ;
        if(expected.equals(actual)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
        // this is not how you test in TestNG
    }

}
