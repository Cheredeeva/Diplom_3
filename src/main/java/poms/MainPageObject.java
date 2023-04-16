package poms;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPageObject {

    private WebDriver driver;

    // Кнопка "Личный кабинет"
    private By personalAreaButton = By.xpath(".//*[text()=\"Личный Кабинет\"]");

    // Кнопка "Войти в аккаунт"
    private By signInButton = By.xpath(".//button[text()=\"Войти в аккаунт\"]");

    // Кнопка "Оформить заказ"
    private By orderButton = By.xpath(".//button[text()=\"Оформить заказ\"]");

    // Кнопка "Булки"
    private By breadButton = By.xpath(".//span[text()=\"Булки\"]");

    // Кнопка "Соусы"
    private By saucesButton = By.xpath(".//span[text()=\"Соусы\"]");

    // Кнопка "Начинки"
    private By fillingsButton = By.xpath(".//span[text()=\"Начинки\"]");

    //Заголовок "Булки"
    private By breadTitle = By.xpath(".//h2[text()=\"Булки\"]");

    //Заголовок "Соусы"
    private By saucesTitle = By.xpath(".//h2[text()=\"Соусы\"]");

    //Заголовок "Начинки"
    private By fillingsTitle = By.xpath(".//h2[text()=\"Начинки\"]");


    public MainPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAreaButton() {
        driver.findElement(personalAreaButton).click();
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void waitUntilOrderButtonDisplayed() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
    }

    public void clickBreadButton() {
        driver.findElement(breadButton).click();
    }

    public void clickSaucesButton() {
        driver.findElement(saucesButton).click();
    }

    public void clickFillingsButton() {
        driver.findElement(fillingsButton).click();
    }

    public void waitBreadTitleDisplayed() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(breadTitle));
    }

    public void waitSaucesTitleDisplayed() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(saucesTitle));
    }

    public void waitFillingsTitleDisplayed() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(fillingsTitle));
    }

}
