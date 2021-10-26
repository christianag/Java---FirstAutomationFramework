package uitests;

import core.BaseClass;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

public class LoginTests extends BaseClass {

    @Test
    public void validDetails() {
        app.loginPage().login();
        app.loginPage().loginTestCheck();
        app.loginPage().logout();
        app.loginPage().logoutTestCheck();
    }

    @Test
    public void invalidDetails() {
        app.loginPage().goToLoginPage(LoginPage.BASE_URL);
        app.loginPage().enterEmail("wrong@email.com");
        app.loginPage().enterPassword("invalid_password");
        app.loginPage().clickLoginButton();
        app.loginPage().logoutTestCheck();
    }

}
