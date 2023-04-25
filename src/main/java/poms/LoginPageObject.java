package poms;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject {
    private final WebDriver driver;

    // Кнопка "Зарегистрироваться"
    private final By registrationButton = By.className("Auth_link__1fOlj");

    // Поле "Email"
    private final By emailField = By.xpath(".//label[text()=\"Email\"]//following::input");

    // Поле "Пароль"
    private final By passwordField = By.xpath(".//label[text()=\"Пароль\"]//following::input");

    // Кнопка "Войти"
    private final By entryButton = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");

    // Заголовок "Вход"
    private final By title = By.xpath(".//h2[text()=\"Вход\"]");

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввести данные в поле «Email»")
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввести данные в поле «Пароль»")
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать кнопку «Вход»")
    public void clickEntryButton() {
        driver.findElement(entryButton).click();
    }

    @Step("Ожидать появления заголовка «Вход»")
    public void waitUntilTitleDisplayed() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(title));
    }

}
