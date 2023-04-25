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
import poms.ForgotPasswordPageObject;
import poms.LoginPageObject;
import poms.MainPageObject;
import poms.RegistrationPageObject;

public class LoginTest {
    private WebDriver driver;

    private final StateUserService userService = new StateUserService();
    private UserRequestBody requestBody;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);

        RestAssured.baseURI = Constants.BASE_URI;
        requestBody = new UserRequestBody(
                "chereder@yan.ru",
                "password",
                "User"
        );
        userService.createUser(requestBody);
    }

    @After
    public void tearDown() {
        userService.deleteUser();
        driver.quit();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginTest() {
        driver.get("https://stellarburgers.nomoreparties.site/");

        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.clickSignInButton();

        performLoginFlow();
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginWithPersonalAreaTest() {
        driver.get("https://stellarburgers.nomoreparties.site/");

        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.clickAreaButton();

        performLoginFlow();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginFromRegistrationTest() {
        driver.get("https://stellarburgers.nomoreparties.site/register");

        RegistrationPageObject registrationPageObject = new RegistrationPageObject(driver);
        registrationPageObject.clickEnterButton();

        performLoginFlow();
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginFromPasswordPageTest() {
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");

        ForgotPasswordPageObject forgotPasswordPageObject = new ForgotPasswordPageObject(driver);
        forgotPasswordPageObject.clickEnterButton();

        performLoginFlow();
    }

    private void performLoginFlow() {
        LoginPageObject loginPageObject = new LoginPageObject(driver);
        loginPageObject.waitUntilTitleDisplayed();
        loginPageObject.enterEmail(requestBody.email);
        loginPageObject.enterPassword(requestBody.password);
        loginPageObject.clickEntryButton();

        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.waitUntilOrderButtonDisplayed();
    }
}
