package org.prog.testng;

import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.selenium.dto.PhoneResultsDto;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

//TODO: Add table to database which contains PhoneId, PhoneName, GoodsId
//TODO: In Allo.ua search for iphone, and store first three devices name
// and код товару (GoodsId) to database
// TODO: * - check if this code and name are already present in database. If its present - do nothing
public class SQLHomeWork {
    // 1. open allo.ua
    // 2. search for iphone (or whatever)
    // 3. Get first 3 items
    // 4. Get name and id for those items
    // 5. insert into database for each
    // * - before insert for each - select from DB where name & id
    private Connection connection;

    @SneakyThrows
    @BeforeSuite
    public void setUp() {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");
    }

    @SneakyThrows
    @Test
    public void mySqlPhoneTest() {
            String insertStatementPhone = "INSERT INTO Phones (PhoneId,PhoneName,GoodsId) VALUES (?, ?, ?)";
            String checkStatementPhone = "SELECT COUNT(*) FROM Phones WHERE PhoneName = ? AND GoodsId = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertStatementPhone);
            PreparedStatement checkStatement = connection.prepareStatement(checkStatementPhone);

            List<PhoneResultsDto> phones = retrievePhones(3);
            for (PhoneResultsDto phone : phones) {
                // Проверяем, есть ли запись в базе
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

    private List<PhoneResultsDto> retrievePhones(int amount) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        List<PhoneResultsDto> phoneResults = new ArrayList<>();
        try {
            driver.get("https://allo.ua/");
            WebElement searchInput = driver.findElement(By.id("search-form__input"));
            searchInput.sendKeys("iphone");
            searchInput.sendKeys(Keys.ENTER);

            List<WebElement> searchResults =
                    new WebDriverWait(driver, Duration.ofSeconds(60))
                            .until(ExpectedConditions.numberOfElementsToBeMoreThan(By
                                    .className("products-layout__item"), amount));


            // Извлечение данных о телефонах
            for (int i = 0; i < Math.min(amount, searchResults.size()); i++) {

                Actions actions = new Actions(driver);
                actions.moveToElement(searchResults.get(i));
                actions.perform();
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
        } finally {
            driver.quit();
        }
        return phoneResults;
    }
}