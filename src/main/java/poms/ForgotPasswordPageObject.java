package poms;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPageObject {
    private final WebDriver driver;

    // Кнопка "Войти"
    private final By enterButton = By.className("Auth_link__1fOlj");

    public ForgotPasswordPageObject(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Нажать кнопку «Вход»")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
}
