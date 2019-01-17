package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesExample extends TestBase {
    /*
        print the whole table
     */

    @Test
    public void printWholeTable() {
        login();
        WebElement table = driver.findElement(By.id("ctl00_MainContent_orderGrid"));
        System.out.println(table.getText());
    }

    public void login() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Default.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);
    }

    /*

     */
    @Test
    public void printAllHeaders() {
        login();
        List<WebElement> headers = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));
        for (WebElement header : headers) {
            System.out.println(header.getText());

        }
    }

    /*
            prints the number of rows
            prints the certain based
     */

    @Test
    public void printRow() {
        login();
        List<WebElement> allRows = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
        System.out.println("number of rows: " + allRows.size());

        for (WebElement header : allRows) {
            System.out.println(header.getText());
        }
        System.out.println("printing row " + 3);
        System.out.println(allRows.get(2).getText());

    }

    @Test
    public void prinTableSize() {
        login();
        List<WebElement> allRows = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
        System.out.println("number of rows: " + allRows.size());

        List<WebElement> allHeaders = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[1]/th"));
        System.out.println("number of cols" + allHeaders.size());

    }

    /*
        print a row without using a list
     */
    @Test
    public void printRow2() throws Exception {
        login();
        Thread.sleep(2000);
        WebElement row = driver.findElement(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[5]"));
        System.out.println(row.getText());

    }

    /*
    print all the cells of a row whose index is given in the xpath
     */
    @Test
    public void printAllCellsInRow() {
        login();
        List<WebElement> cells = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]/th"));

        for (WebElement header : cells) {
            System.out.println(header.getText());
        }
    }

    /*
        print by coordinates : based on row and column number
     */
    @Test
    public void printByCoordinates() {
        login();
        WebElement cell = driver.findElement(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[3]/td[3]"));
        System.out.println(cell.getText());
    }

    public WebElement getCell(int row, int col) {
        String xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[" + row + "]/td[" + col + "]";
        return driver.findElement(By.xpath(xpath));
    }

    /*
        print all the values in single column
     */
    @Test
    public void prrintColumn() {
        login();
        List<WebElement> allNames = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));

        for (WebElement header : allNames) {
            System.out.println(header.getText());
        }
    }

    // find the select checkbox for a given name

    @Test
    public void selectCheckBox() {
        login();
        WebElement checkBox = driver.findElement(By.xpath("//td[.='Susan McLaren']/../td[1]/input"));
        System.out.println(checkBox.isSelected());
        checkBox.click();
        System.out.println(checkBox.isSelected());
    }

    // verify tthat name 'someone' exists in the names column
    // verify that city 'anytown' exists in the cities column

    @Test
    public void test() {

        login();
        int nameIndex = getColumnIndex("Name");
        System.out.println(nameIndex);

        List<WebElement> allNames = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[" + nameIndex + "]"));

        boolean found = false;

        for (int i = 0; i < allNames.size(); i++) {
            if (allNames.get(i).getText().equals("Mark Smith")) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);

        found = false;
        int cityIndex = getColumnIndex("City");
        List<WebElement> allCities = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[\"+ nameIndex +\"]"));
        for (int i = 0; i < allNames.size(); i++) {
            if (allNames.get(i).getText().equals("WhiteStone, British")) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);

    }

    // gets a column name as a parameters returns the index of the column name
    public int getColumnIndex(String column) {
        List<WebElement> allHeader = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));

        for (int i = 0; i < allHeader.size(); i++) {
            if (allHeader.get(i).getText().equals(column)) {
                return i + 1;
            }
        }

        return 0;
    }

}
