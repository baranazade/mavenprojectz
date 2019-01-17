package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
open browser
go to amazon
enter search term and submit
verify search box still contains the same search term
 */
public class AmazonSearch {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");

        String searchterm = "charger";
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchterm + Keys.ENTER);

        String actual = driver.findElement(By.id("twotabsearchtextbox")).getAttribute("value");

        if(searchterm.equals(actual)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }




    }
}
