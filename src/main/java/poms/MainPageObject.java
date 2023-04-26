package poms;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPageObject {

    private final WebDriver driver;

    // Кнопка "Личный кабинет"
    private final By personalAreaButton = By.xpath(".//*[text()=\"Личный Кабинет\"]");

    // Кнопка "Войти в аккаунт"
    private final By signInButton = By.xpath(".//button[text()=\"Войти в аккаунт\"]");

    // Кнопка "Оформить заказ"
    private final By orderButton = By.xpath(".//button[text()=\"Оформить заказ\"]");

    // Кнопка "Булки"
    private final By breadButton = By.xpath(".//span[text()=\"Булки\"]");

    // Кнопка "Соусы"
    private final By saucesButton = By.xpath(".//span[text()=\"Соусы\"]");

    // Кнопка "Начинки"
    private final By fillingsButton = By.xpath(".//span[text()=\"Начинки\"]");

    //Заголовок "Булки"
    private final By breadTitle = By.xpath(".//h2[text()=\"Булки\"]");

    //Заголовок "Соусы"
    private final By saucesTitle = By.xpath(".//h2[text()=\"Соусы\"]");

    //Заголовок "Начинки"
    private final By fillingsTitle = By.xpath(".//h2[text()=\"Начинки\"]");


    public MainPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать кнопку «Личный кабинет»")
    public void clickAreaButton() {
        driver.findElement(personalAreaButton).click();
    }

    @Step("Нажать кнопку «Войти в аккаунт»")
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    @Step("Ожидать появления кнопки «Оформить заказ»")
    public void waitUntilOrderButtonDisplayed() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
    }
    @Step("Нажать кнопку «Булки»")
    public void clickBreadButton() {
        driver.findElement(breadButton).click();
    }

    @Step("Нажать кнопку «Соусы»")
    public void clickSaucesButton() {
        driver.findElement(saucesButton).click();
    }

    @Step("Нажать кнопку «Начинки»")
    public void clickFillingsButton() {
        driver.findElement(fillingsButton).click();
    }

    @Step("Ожидать появления заголовка «Булки»")
    public void waitBreadTitleDisplayed() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(breadTitle));
    }

    @Step("Ожидать появления заголовка «Соусы»")
    public void waitSaucesTitleDisplayed() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(saucesTitle));
    }

    @Step("Ожидать появления заголовка «Начинки»")
    public void waitFillingsTitleDisplayed() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(fillingsTitle));
    }

}
