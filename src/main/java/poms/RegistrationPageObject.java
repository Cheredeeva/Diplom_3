package poms;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPageObject {

    private WebDriver driver;

    // Поле "Имя"
    private By nameField = By.xpath(".//label[text()=\"Имя\"]//following::input");

    // Поле "Email"
    private By emailField = By.xpath(".//label[text()=\"Email\"]//following::input");

    // Поле "Password"
    private By passwordField = By.xpath(".//label[text()=\"Пароль\"]//following::input");

    // Кнопка "Зарегистрироваться"
    private By registrationButton = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");

    // Кнопка "Войти"
    private By enterButton = By.className("Auth_link__1fOlj");

    // Сообщение о некорректном пароле
    private By incorrectPassword = By.cssSelector(".input__error.text_type_main-default");

    public RegistrationPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    public void checkIncorrectPasswordDisplayed() {
        boolean isDisplayed = driver
                .findElement(incorrectPassword)
                .isDisplayed();
        Assert.assertTrue(isDisplayed);
    }
}

