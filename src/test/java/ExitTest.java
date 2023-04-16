import helpers.CreateUserRequestBody;
import helpers.UserServiceHelper;
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


public class ExitTest {
        private WebDriver driver;

        private final UserServiceHelper userServiceHelper = new UserServiceHelper();
        private CreateUserRequestBody requestBody;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);

        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
        requestBody = new CreateUserRequestBody(
                "chereder@yan.ru",
                "password",
                "User"
        );
        userServiceHelper.createUser(requestBody);

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
        userServiceHelper.deleteUser();
        driver.quit();
    }

    @Test
    public void goToConstructorTest() {
        ProfilePageObject profilePageObject = new ProfilePageObject(driver);
        profilePageObject.clickExitButton();

        LoginPageObject loginPageObject = new LoginPageObject(driver);
        loginPageObject.waitUntilTitleDisplayed();
    }
}
