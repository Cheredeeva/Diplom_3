import helpers.LoginUserRequestBody;
import helpers.UserServiceHelper;
import io.restassured.RestAssured;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import poms.LoginPageObject;
import poms.MainPageObject;
import org.junit.Test;
import org.junit.After;
import poms.RegistrationPageObject;

public class RegistrationTest {

    private WebDriver driver;
    private final UserServiceHelper userServiceHelper = new UserServiceHelper();

    @Before
    public void setup() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void registrationTest() {
        RegistrationPageObject registrationPageObject = new RegistrationPageObject(driver);
        LoginUserRequestBody requestBody = new LoginUserRequestBody("chedMaaa12@gmail.am", "password");
        registrationPageObject.enterName("Rita");
        registrationPageObject.enterEmail(requestBody.email);
        registrationPageObject.enterPassword(requestBody.password);
        registrationPageObject.clickRegistrationButton();

        LoginPageObject loginPageObject = new LoginPageObject(driver);
        loginPageObject.waitUntilTitleDisplayed();

        // tear down
        userServiceHelper.loginUser(requestBody);
        userServiceHelper.deleteUser();
    }

    @Test
    public void registrationFailureTest() {
        RegistrationPageObject registrationPageObject = new RegistrationPageObject(driver);
        registrationPageObject.enterName("Rita");
        registrationPageObject.enterEmail("cheredM@gmail.am");
        registrationPageObject.enterPassword("passw");
        registrationPageObject.clickRegistrationButton();
        registrationPageObject.checkIncorrectPasswordDisplayed();
    }
}
