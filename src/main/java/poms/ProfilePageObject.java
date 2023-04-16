package poms;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePageObject {

    private WebDriver driver;

    // Кнопка "Конструктор"
    private By constructorButton = By.xpath(".//p[text()=\"Конструктор\"]");

    // Кнопка "Профиль"
    private By profileButton = By.xpath(".//a[text()=\"Профиль\"]");

    // Кнопка "Выход"
    private By exitButton = By.xpath(".//button[text()=\"Выход\"]");

    private By logoButton = By.className("AppHeader_header__logo__2D0X2");

    public ProfilePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilProfileButtonDisplayed() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(profileButton));
    }

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    public void clickExitButton() {
        driver.findElement(exitButton).click();
    }

    public void checkProfileButtonDisplayed() {
        boolean isDisplayed = driver
                .findElement(profileButton)
                .isDisplayed();
        Assert.assertTrue(isDisplayed);
    }
    public void clickLogoButton() {
        driver.findElement(logoButton).click();
    }
}
