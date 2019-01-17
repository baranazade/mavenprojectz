package com.cybertek.tests;

import org.testng.annotations.Test;

public class MoreDependenciesTest {

    @Test
    public void openBrowser(){
        System.out.println("opening browser");
    }

    @Test (dependsOnMethods = "openBrowser")
    public void login(){
        System.out.println("Login");
    }

    @Test
    public void logOut(){
        System.out.println("Logout");
    }
}
