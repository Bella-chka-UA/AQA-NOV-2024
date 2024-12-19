package org.prog.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.selenium.pages.AlloUaPage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

//TODO: Move Allo.ua code to TestNG
//TODO: replace [// if X > goods count -> throw exception] with Assert
public class AlloUaTestNG {
    private WebDriver driver;
    private AlloUaPage alloUaPage;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        alloUaPage = new AlloUaPage(driver);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(dataProvider = "inputText")
    public void testFindSkuParameters( String inputText,int position) {
        alloUaPage.loadPage();
        alloUaPage.setSearchInputText(inputText);
        alloUaPage.executeSearch();
        List<WebElement> searchResults = alloUaPage.getSearchResults();

        Assert.assertTrue(position >= 0, "Position is below zero");
        Assert.assertTrue(position < searchResults.size(), "Position is above list size");

        var skuParameters = alloUaPage.searchForAPosition(searchResults, position);
        System.out.println(skuParameters);
    }

    @DataProvider
    public Object[][] inputText() {
        return new Object[][]{
                {"Redmi",3},
                {"iPhone",1},
                {"Samsung",1},
                {"Acer",2}
        };
    }




}