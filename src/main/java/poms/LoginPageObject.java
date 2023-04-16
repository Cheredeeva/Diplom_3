package poms;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPageObject {

    private WebDriver driver;

    // Кнопка "Зарегистрироваться"
    private By registrationButton = By.className("Auth_link__1fOlj");

    // Поле "Email"
    private By emailField = By.xpath(".//label[text()=\"Email\"]//following::input");

    // Поле "Пароль"
    private By passwordField = By.xpath(".//label[text()=\"Пароль\"]//following::input");

    // Кнопка "Войти"
    private By entryButton = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");

    // Заголовок "Вход"
    private By title = By.xpath(".//h2[text()=\"Вход\"]");

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickEntryButton() {
        driver.findElement(entryButton).click();
    }

    public void waitUntilTitleDisplayed() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(title));
    }

}
