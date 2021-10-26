package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.logging.Logger;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(LoginPage.class));

    // CONSTANTS
    public static final String BASE_URL = "https://test-admin.diplomasafe.net/en-US";
    public static final String EMAIL = "kristiana.georgieva@lab08.com";
    public static final String PASSWORD = "kigQDT21";
    public static final String EXPECTED_OUTCOME = "https://test-admin.diplomasafe.net/en-US/admin/organization-list";

    // PAGE ELEMENTS
    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(className = "submit")
    private WebElement loginButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/nav/ul/li[1]/a")
    private WebElement profileMenu;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/nav/ul/li[1]/ul/li[2]/a")
    private WebElement logoutButton;

    // METHODS
    public void login() {
        goToLoginPage(BASE_URL);
        enterEmail(EMAIL);
        enterPassword(PASSWORD);
        clickLoginButton();
    }

    public void logout() {
        profileMenu.click();
        logoutButton.click();
    }

    // CHECK TESTS
    public void loginTestCheck() {
        testURL(EXPECTED_OUTCOME);
    }

    public void logoutTestCheck() {
        testURL(BASE_URL);
    }

    // LOGIN ACTIONS BREAKDOWN
    public void goToLoginPage(String url) {
        LOGGER.info("Navigating to Login page");
        bpDriver.get(url);
    }

    public void enterEmail(String email) {
        LOGGER.info("Entering email.");
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        LOGGER.info("Entering password.");
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        LOGGER.info("Logging in.");
        loginButton.click();
    }

}
