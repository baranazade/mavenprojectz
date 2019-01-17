package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IframeDemo {
    /*
    1. create a new class called IframeDemo
    2.
     */
    @Test
    public void test(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.hereokuapp.com/tinymce");

        driver.findElement(By.tagName("p")).sendKeys("ddeee ddeeedd dd");
    }
}
