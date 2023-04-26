import api.Constants;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import poms.MainPageObject;

public class ConstructorTest {
    private WebDriver driver;

    @Before
    public void setup() {
//        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "/Users/cheredeeva/WebDriver/bin/yandexdriver");
        RestAssured.baseURI = Constants.BASE_URI;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
//        options.setBinary("/Applications/Yandex 2.app/Contents/MacOS/Yandex");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    public void saucesTest() {
        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.clickSaucesButton();
        mainPageObject.waitSaucesTitleDisplayed();
    }

    @Test
    @DisplayName("Переход к разделу «Булки»")
    public void breadTest() {
        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.clickSaucesButton();
        mainPageObject.waitSaucesTitleDisplayed();
        mainPageObject.clickBreadButton();
        mainPageObject.waitBreadTitleDisplayed();
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    public void fillingsTest() {
        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.clickFillingsButton();
        mainPageObject.waitFillingsTitleDisplayed();
    }
}
