package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxes {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/forgot_password");

        WebElement input = driver.findElement(By.id("email"));

        input.sendKeys("somemail@somemail.com" + Keys.ENTER); // or input.submit();

        String expexted = "Your e-mail1's been sent!";
        String actual=
                driver.findElement(By.id("content")).getText();

        if (actual.equals(expexted)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
            System.out.println("actual = " + actual);
            System.out.println("expexted = " + expexted);
        }


    }
}
