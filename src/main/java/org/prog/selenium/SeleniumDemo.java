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

public class SeleniumDemo {

    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            // 1. open browser
            driver = new ChromeDriver();
            // 2. open google.com
            driver.get("https://google.com/");
            // 3. enter 'ben affleck' to search field
            WebElement cookiesLink = driver.findElement(By.xpath("//a[contains(@href, 'technologies/cookies')]"));
            if (cookiesLink.isDisplayed()) {
                driver.findElements(By.tagName("button")).get(4).click();
            }
            WebElement searchInput = driver.findElement(By.name("q"));
            searchInput.sendKeys("Ben Affleck");
            searchInput.sendKeys(Keys.ENTER);

            List<WebElement> searchHeaders = new WebDriverWait(driver, Duration.ofSeconds(5L))
                    .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("h3"), 1));

            int count = 0;
            for (WebElement webElement : searchHeaders) {
                if (webElement.getText().contains("Ben Affleck")) {
                    count++;
                }
            }

            if (count > 3) {
                System.out.println("Ben Found!");
            } else {
                System.out.println("Ben not found!");
            }
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }

        // 4. press enter for search field
        // 5. check search results
    }
}
