package poms;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePageObject {
    private final WebDriver driver;

    // Кнопка "Конструктор"
    private final By constructorButton = By.xpath(".//p[text()=\"Конструктор\"]");

    // Кнопка "Профиль"
    private final By profileButton = By.xpath(".//a[text()=\"Профиль\"]");

    // Кнопка "Выход"
    private final By exitButton = By.xpath(".//button[text()=\"Выход\"]");

    private final By logoButton = By.className("AppHeader_header__logo__2D0X2");

    public ProfilePageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ожидать появления кнопки «Профиль»")
    public void waitUntilProfileButtonDisplayed() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(profileButton));
    }

    @Step("Нажать кнопку «Конструктор»")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Нажать кнопку «Выход»")
    public void clickExitButton() {
        driver.findElement(exitButton).click();
    }

    @Step("Проверить появление кнопки «Профиль» на экране")
    public void checkProfileButtonDisplayed() {
        boolean isDisplayed = driver
                .findElement(profileButton)
                .isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    @Step("Нажать логотип")
    public void clickLogoButton() {
        driver.findElement(logoButton).click();
    }
}
