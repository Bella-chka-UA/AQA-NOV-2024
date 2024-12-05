package org.prog.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomeWorkSelenium {
    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.get("https://allo.ua/");

            WebElement searchInput = driver.findElement(By.id("search-form__input"));
            searchInput.sendKeys("IPhone");
            searchInput.sendKeys(Keys.ENTER);


            List<WebElement> searchIPhones =new WebDriverWait(driver,Duration.ofSeconds(5l)).
                    until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("product-card__content"),1));

                var webElement= searchIPhones.get(3).findElement(By.tagName("a"));

                System.out.println(webElement.getDomAttribute("title"));


        } finally {
            if (driver != null) {
                driver.quit();
            }

        }
    }
}
