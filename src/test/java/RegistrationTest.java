import api.Constants;
import api.user.LoginUserRequestBody;
import api.user.StateUserService;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import poms.LoginPageObject;
import poms.RegistrationPageObject;

public class RegistrationTest {
    private WebDriver driver;
    private final StateUserService userService = new StateUserService();

    @Before
    public void setup() {
        RestAssured.baseURI = Constants.BASE_URI;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Успешная регистрация пользователя")
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
        userService.loginUser(requestBody);
        userService.deleteUser();
    }

    @Test
    @DisplayName("Ошибка при регистрации из-за некорректного пароля")
    public void registrationFailureTest() {
        RegistrationPageObject registrationPageObject = new RegistrationPageObject(driver);
        registrationPageObject.enterName("Rita");
        registrationPageObject.enterEmail("cheredM@gmail.am");
        registrationPageObject.enterPassword("passw");
        registrationPageObject.clickRegistrationButton();
        registrationPageObject.checkIncorrectPasswordDisplayed();
    }
}
