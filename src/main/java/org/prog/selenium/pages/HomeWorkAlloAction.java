package org.prog.selenium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;


public class HomeWorkAlloAction {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        AlloUaPage alloUaPage = new AlloUaPage(driver);
        driver.manage().window().maximize();


        try {
            findSkuParameters(alloUaPage, "Redmi", 2);
            findSkuParameters(alloUaPage,"iPhone",1);
        } finally{
            if (driver != null) {
                driver.quit();
            }
        }
    }

    private static void findSkuParameters(AlloUaPage alloUaPage, String inputText, int position) {
        alloUaPage.loadPage();
        alloUaPage.setSearchInputText(inputText);
        alloUaPage.executeSearch();
        List<WebElement> searchResults = alloUaPage.getSearchResults();
        var skuParameters = alloUaPage.searchForAPosition(searchResults,position);
        System.out.println(skuParameters);
    }

}

