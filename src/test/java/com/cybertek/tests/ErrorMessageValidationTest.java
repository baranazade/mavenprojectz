package com.cybertek.tests;

import com.cybertek.pages.HomePage;
import com.cybertek.pages.ListingPage;
import com.cybertek.pages.PrestashopHomePage;
import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorMessageValidationTest extends TestBase {

    HomePage homePage = new HomePage();

    @Test
    public void wrongEmailTest(){

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        homePage.username.sendKeys("admin");
        homePage.password.sendKeys("test");
        homePage.loginButton.click();

        String error = "Invalid Login or Password.";
        String actualError = homePage.errorMessage.getText();

        Assert.assertEquals(actualError, error);
    }

    @Test
    public void wrongPasswordTest() {

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        homePage.username.sendKeys("Tester");
        homePage.password.sendKeys("wrong password");
        homePage.loginButton.click();

        String expectedError = "Invalid Login or Password.";
        String actualError = homePage.errorMessage.getText();
        Assert.assertEquals(actualError, expectedError);
    }

    @Test
    public void blankUsername(){

        homePage.open();
        homePage.login("", "test");

        String expectedError = "Invalid Login or Password.";
        String actualError = homePage.errorMessage.getText();
        Assert.assertEquals(actualError, expectedError);
    }


    // this is just a method which does not do anything
    @Test
    public void test(){
        ListingPage nilesLane = new ListingPage();

        ListingPage palmetLane = new ListingPage();

        PrestashopHomePage prestashopHomePage = new PrestashopHomePage();

        WebElement tshirt = prestashopHomePage.product("tshirt");

        WebElement dress = prestashopHomePage.product("dress");


    }


}
