package org.prog.selenium.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected final WebDriver driver;
    private final String url;

    protected AbstractPage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }

    public void loadPage() {
        driver.get(url);
    }


}
