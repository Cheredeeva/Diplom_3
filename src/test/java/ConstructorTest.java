import helpers.UserServiceHelper;
import io.restassured.RestAssured;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import poms.MainPageObject;
import org.junit.Test;
import org.junit.After;

public class ConstructorTest {

    private WebDriver driver;
    private final UserServiceHelper userServiceHelper = new UserServiceHelper();

    @Before
    public void setup() {
//        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "/Users/cheredeeva/WebDriver/bin/yandexdriver");
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
//        options.setBinary("/Applications/Yandex 2.app/Contents/MacOS/Yandex");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void saucesTest() {
        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.clickSaucesButton();
        mainPageObject.waitSaucesTitleDisplayed();
    }

    @Test
    public void breadTest() {
        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.clickSaucesButton();
        mainPageObject.waitSaucesTitleDisplayed();
        mainPageObject.clickBreadButton();
        mainPageObject.waitBreadTitleDisplayed();
    }

    @Test
    public void fillingsTest() {
        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.clickFillingsButton();
        mainPageObject.waitFillingsTitleDisplayed();
    }
}
