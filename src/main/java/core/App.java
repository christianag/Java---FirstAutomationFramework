package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import pageobjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class App {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(BasePage.class));

    // PAGES
    private TemplatesPage templatesPage;
    private LoginPage loginPage;
    private IssueDiplomasPage issueDiplomasPage;
    private OrganizationsPage organizationsPage;
    private SearchDiplomasPage searchDiplomasPage;
    private UserManagementPage userManagementPage;
    private TemplateDesignsPage templateDesignsPage;

    // BROWSER (START & QUIT)
    private WebDriver appDriver;
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--window-size=1920,1080");
        appDriver = new ChromeDriver(options);
        appDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LOGGER.info("******************************************************************");
    }

    // METHODS
    public void close() { appDriver.close(); }

    public void quit() { appDriver.quit(); }

    //LOGGING ERRORS FROM BROWSER'S CONSOLE
    public void logErrors() {
        LOGGER.info("*********************** Checking for console errors.");
        LogEntries logEntries = appDriver.manage().logs().get("browser");
        for (LogEntry entry : logEntries) {
            LOGGER.info(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            String errorLogType= entry.getLevel().toString();
            String errorLog= entry.getMessage().toString();
            if (errorLog.contains("404")){
                LOGGER.info("*********************** Error LogType: "+ errorLogType+" Error Log message: "+errorLog);
            } else if (errorLog.contains("400")){
                LOGGER.info("*********************** Error LogType: "+ errorLogType+" Error Log message: "+errorLog);
            } else if (errorLog.contains("500")){
                LOGGER.info("*********************** Error LogType: "+ errorLogType+" Error Log message: "+errorLog);
            }
        }
    }

    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(appDriver);
        }
        return loginPage;
    }

    public OrganizationsPage organizationsPage() {
        if (organizationsPage == null) {
            organizationsPage = new OrganizationsPage(appDriver);
        }
        return organizationsPage;
    }

    public TemplatesPage templatesPage() {
        if (templatesPage == null) {
            templatesPage = new TemplatesPage(appDriver);
        }
        return templatesPage;
    }

    public IssueDiplomasPage issueDiplomasPage() {
        if (issueDiplomasPage == null) {
            issueDiplomasPage = new IssueDiplomasPage(appDriver);
        }
        return issueDiplomasPage;
    }

    public SearchDiplomasPage searchDiplomasPage() {
        if (searchDiplomasPage == null) {
            searchDiplomasPage = new SearchDiplomasPage(appDriver);
        }
        return searchDiplomasPage;
    }

    public UserManagementPage userManagementPage() {
        if(userManagementPage == null) {
            userManagementPage = new UserManagementPage(appDriver);
        }
        return userManagementPage;
    }

    public TemplateDesignsPage templateDesignsPage() {
        if(templateDesignsPage == null) {
            templateDesignsPage = new TemplateDesignsPage(appDriver);
        }
        return templateDesignsPage;
    }
}
