package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AppDashboardPage extends BasePage {

    public AppDashboardPage(WebDriver driver){
        super(driver);
    }

    // CONSTANTS
    public static final String APP_DASHBOARD_URL = "https://test-app.diplomasafe.net/en-US/login";
    public static final String UNCLAIMED_DIPLOMAS_DIV= "/html/body/app-main/div/app-mydiplomas/main/div/article/div[2]/div/div";
    public static final String PENDING_DIPLOMA_NAME = "/html/body/app-main/div/app-mydiplomas/main/div/article/div[2]/div/br";

    // PAGE ELEMENTS
    @FindBy(xpath = "//*[@id='mat-input-0']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id='mat-input-1']")
    private WebElement passwordField;

    @FindBy(xpath = "/html/body/app-main/div/app-login/main/div/div/div/form/div/button")
    private WebElement loginButton;

    @FindBy(xpath = "/html/body/app-main/div/app-mydiplomas/main/div/article/div[2]/div/div/div/div[2]/a/button")
    private WebElement buttonGetItNow;

    @FindBy(xpath = "/html/body/app-main/div/app-claim-base/div/div/div[1]/div/div[2]/div/div/div[2]/app-claim-registered/div/button")
    private WebElement claimDiplomaButton;

    // METHODS
    public void logIntoAppDashboard(String email, String password) {
        bpDriver.get(APP_DASHBOARD_URL);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void areThereAnyPendingDiplomas() {
        Assert.assertEquals(getElementText(UNCLAIMED_DIPLOMAS_DIV), "Sorry you do not have any diplomas.");
    }

    public void claimDiploma(String templateName) {
        buttonGetItNow.click();
        Assert.assertEquals(PENDING_DIPLOMA_NAME, templateName);
        claimDiplomaButton.click();
        urlContains("https://test-app.diplomasafe.net/en-US/diploma");
    }


}
