package org.prog.cucumber.steps.home;

import io.cucumber.java.en.*;
import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.selenium.dto.PhoneResultsDto;
import org.prog.selenium.pages.AlloUaPage;
import java.sql.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;



public class PhoneSteps {
        private Connection connection;
        private WebDriver driver;
        private final List<PhoneResultsDto> phoneResults = new ArrayList<>();
    public static AlloUaPage alloUaPage;
        @SneakyThrows
        @Given("the database connection is set up")
        public void setUpDatabase() {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");
        }
        @When("I search for {string} on Allo.ua")
        public void searchPhones(String searchQuery) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://allo.ua/");
            WebElement searchInput = driver.findElement(By.id("search-form__input"));
            searchInput.sendKeys(searchQuery);
            searchInput.sendKeys(Keys.ENTER);
        }

        @And("I retrieve the first {int} phones")
        public void retrievePhones(int amount) {
            try {
                List<WebElement> searchResults =
                        new WebDriverWait(driver, Duration.ofSeconds(60))
                                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("products-layout__item"), amount));

                for (int i = 0; i < Math.min(amount, searchResults.size()); i++) {
                    Actions actions = new Actions(driver);
                    actions.moveToElement(searchResults.get(i)).perform();
                    WebElement result = searchResults.get(i);
                    WebElement nameElement = result.findElement(By.className("product-card__title"));
                    WebElement goodsIdElement = result.findElement(By.className("product-sku__value"));

                    PhoneResultsDto phone = new PhoneResultsDto(
                            String.valueOf(i + 1), // ID — порядковый номер
                            nameElement.getText(), // Название товара
                            goodsIdElement.getText() // Код товара
                    );
                    phoneResults.add(phone);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        @Then("I check and insert the phones into the database")
        @SneakyThrows
        public void insertPhonesToDatabase() {
            String insertStatementPhone = "INSERT INTO Phones (PhoneId,PhoneName,GoodsId) VALUES (?, ?, ?)";
            String checkStatementPhone = "SELECT COUNT(*) FROM Phones WHERE PhoneName = ? AND GoodsId = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertStatementPhone);
            PreparedStatement checkStatement = connection.prepareStatement(checkStatementPhone);

            for (PhoneResultsDto phone : phoneResults) {
                checkStatement.setString(1, phone.getName());
                checkStatement.setString(2, phone.getGoodsId());
                ResultSet resultSet = checkStatement.executeQuery();
                resultSet.next();

                if (resultSet.getInt(1) == 0) { // Если записи нет
                    insertStatement.setString(1, phone.getId());
                    insertStatement.setString(2, phone.getName());
                    insertStatement.setString(3, phone.getGoodsId());
                    try {
                        insertStatement.execute();
                        System.out.println("Phone saved: " + phone);
                    } catch (Exception e) {
                        System.err.println("Failed to save phone: " + phone);
                    }
                } else {
                    System.out.println("Phone already exists: " + phone);
                }
            }
        }
    }

