package poms;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPageObject {
    private final WebDriver driver;

    // Поле "Имя"
    private final By nameField = By.xpath(".//label[text()=\"Имя\"]//following::input");

    // Поле "Email"
    private final By emailField = By.xpath(".//label[text()=\"Email\"]//following::input");

    // Поле "Password"
    private final By passwordField = By.xpath(".//label[text()=\"Пароль\"]//following::input");

    // Кнопка "Зарегистрироваться"
    private final By registrationButton = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");

    // Кнопка "Войти"
    private final By enterButton = By.className("Auth_link__1fOlj");

    // Сообщение о некорректном пароле
    private final By incorrectPassword = By.cssSelector(".input__error.text_type_main-default");

    public RegistrationPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввести данные в поле «Имя»")
    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Ввести данные в поле «Email»")
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввести данные в поле «Пароль»")
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать кнопку «Зарегистрироваться»")
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Нажать кнопку «Вход»")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    @Step("Проверить появление сообщения о некорректном пароле")
    public void checkIncorrectPasswordDisplayed() {
        boolean isDisplayed = driver
                .findElement(incorrectPassword)
                .isDisplayed();
        Assert.assertTrue(isDisplayed);
    }
}

