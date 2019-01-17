package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MixedUpDependencies {

    @Test
    public void openBrowser(){
        System.out.println("opening browser");
    }

    @Test (dependsOnMethods = "openBrowser")
    public void login(){
        System.out.println("Login");

    }

    @AfterMethod
    public void logOut(){
        System.out.println("Close browser");
    }


}
