package poms;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPageObject {

    private WebDriver driver;

    // Кнопка "Войти"
    private By enterButton = By.className("Auth_link__1fOlj");

    public ForgotPasswordPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }


}
