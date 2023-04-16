import helpers.CreateUserRequestBody;
import helpers.UserServiceHelper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import poms.*;
import org.junit.Test;
import org.junit.After;

public class GoToProfileTest {

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
    }

    @After
    public void tearDown() {
        userServiceHelper.deleteUser();
        driver.quit();
    }

    @Test
    public void goToProfileTest() {
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
}
