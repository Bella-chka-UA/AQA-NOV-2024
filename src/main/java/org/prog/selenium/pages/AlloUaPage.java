package org.prog.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

// add method which checks goods id on position X
// if X < 0 -> throw exception
// if X > goods count -> throw exception
// if 0 <= X <= goods_amount -> scroll to item, then print goods id for that item

public class AlloUaPage {

    private final WebDriver driver;

    public AlloUaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get("https://allo.ua/");
    }

    public void executeSearch() {
        driver.findElement(By.id("search-form__input")).sendKeys(Keys.ENTER);
    }

    public void setSearchInputText(String value) {
        driver.findElement(By.id("search-form__input")).sendKeys(value);
    }
    public List<WebElement> getSearchResults() {
        return new WebDriverWait(driver, Duration.ofSeconds(5L))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("products-layout__item"), 10));
    }

    public String searchForAPosition (List<WebElement> goods,int position) {
        try
        {
            validatePosition(position, goods.size());
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
        moveToElementToPosition(goods, position);
        var skuElements = getSkuWebElements();
        return getSkuParametersByPosition(skuElements, position);
    }

    private static String getSkuParametersByPosition(List<WebElement> skuElements, int position) {
        WebElement skuTitle = skuElements.get(position).findElement(By.className("product-sku__title"));
        WebElement skuValue = skuElements.get(position).findElement(By.className("product-sku__value"));
        return skuTitle.getText() + skuValue.getText();
    }

    private List<WebElement> getSkuWebElements() {
        return new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("product-card__sku"), 1));
    }

    private void moveToElementToPosition(List<WebElement> goods, int position) {
        Actions actions = new Actions(driver);
        actions.moveToElement(goods.get(position));
        actions.perform();
    }

    private static void validatePosition(int position, int listSize) throws Exception {
        if (position < 0)
        {
            throw new Exception("below zero ");
        }
        if (position > listSize)
        {
            throw new Exception("above list size");
        }
    }
}















