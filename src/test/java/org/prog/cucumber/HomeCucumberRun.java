package org.prog.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.cucumber.steps.SQLSteps;
import org.prog.cucumber.steps.home.PhoneSteps;
import org.prog.selenium.pages.AlloUaPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@CucumberOptions(
        glue = "org.prog.cucumber.steps.home",
        features = "src/test/resources/features",
        plugin = {"pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "html:target/cucumber-report.html"
        }
)

public class HomeCucumberRun extends AbstractTestNGCucumberTests {

    private WebDriver driver;
    private Connection connection;

    @BeforeSuite
    public void setUp() throws SQLException {
        connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/db", "user", "password");

        driver = new ChromeDriver();
        PhoneSteps.alloUaPage = new AlloUaPage(driver);
        SQLSteps.connection = connection;


    }

    @SneakyThrows
    @AfterSuite
    public void tearDown() {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
        if (driver != null) {
            driver.quit();
        }
    }
}