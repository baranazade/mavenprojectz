package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadioButtons {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton");

        //verify blue and red not checked
        WebElement blue = driver.findElement(By.id("gwt-debug-cwRadioButton-color-blue-input"));
        WebElement red = driver.findElement(By.id("gwt-debug-cwRadioButton-color-red-input"));

        System.out.println("blue: " + blue.isSelected());
        System.out.println("red: " + red.isSelected());

        //check blue
        System.out.println("IT WILL CLICK ON BLUE");
        blue.click();

//        VERIFY BLUE CHECCKED AND RED NOT CHECKED
        System.out.println("blue: " + blue.isSelected());
        System.out.println("red: " + red.isSelected());
//        CHECK RED
        System.out.println("IT WILL CLICK ON RED");
        red.click();
        //



    }
}
