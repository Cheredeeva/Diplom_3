import api.Constants;
import api.user.StateUserService;
import api.user.UserRequestBody;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import poms.LoginPageObject;
import poms.MainPageObject;
import poms.ProfilePageObject;

public class GoToConstructorTest {
    private final StateUserService userService = new StateUserService();
    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);

        RestAssured.baseURI = Constants.BASE_URI;
        UserRequestBody requestBody = new UserRequestBody(
                "chereder@yan.ru",
                "password",
                "User"
        );
        userService.createUser(requestBody);

        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPageObject loginPageObject = new LoginPageObject(driver);
        loginPageObject.waitUntilTitleDisplayed();
        loginPageObject.enterEmail(requestBody.email);
        loginPageObject.enterPassword(requestBody.password);
        loginPageObject.clickEntryButton();

        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.waitUntilOrderButtonDisplayed();
        mainPageObject.clickAreaButton();

        ProfilePageObject profilePageObject = new ProfilePageObject(driver);
        profilePageObject.waitUntilProfileButtonDisplayed();
    }

    @After
    public void tearDown() {
        userService.deleteUser();
        driver.quit();
    }

    @Test
    @DisplayName("Переход в конструктор из личного кабинета по клику на «Конструктор»")
    public void goToConstructorTest() {
        ProfilePageObject profilePageObject = new ProfilePageObject(driver);
        profilePageObject.clickConstructorButton();

        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.waitUntilOrderButtonDisplayed();
    }

    @Test
    @DisplayName("Переход в конструктор из личного кабинета по клику на логотип Stellar Burgers")
    public void goToConstructorWithLogoTest() {
        ProfilePageObject profilePageObject = new ProfilePageObject(driver);
        profilePageObject.clickLogoButton();

        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.waitUntilOrderButtonDisplayed();
    }
}
