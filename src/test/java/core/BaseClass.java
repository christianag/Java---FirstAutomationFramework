package core;

import org.testng.annotations.*;

public class BaseClass {

    protected static App app;

    @BeforeSuite
    public static void setUp() {
        app = new App();
        app.startBrowser();
    }

    @BeforeClass
    public static void login() {
        app.loginPage().login();
    }

    @AfterMethod
    public static void checkConsole() {
        app.logErrors();
    }

//    @AfterClass
//    public static void logout() {
//        app.loginPage().logout();
//    }
//
//    @AfterSuite
//    public static void tearDown() {
//        app.quit();
//    }
}