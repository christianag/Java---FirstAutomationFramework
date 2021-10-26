package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.logging.Logger;

public class UserManagementPage extends BasePage {

    public UserManagementPage(WebDriver driver){
        super(driver);
    }
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(LoginPage.class));

    //CONSTANTS
    public static final String EMAIL = "test@abv.bg";
    public static final String PERMISSIONS_FIELD = "/html/body/div/div/div[3]/div[3]/div/div/div/div/form/div[5]/div/select";
    public static final String USER_ADD_CONFIRMATION = "/html/body/div/div/div[3]/div[1]/div/h3";
    public static final String ADDED_SUCCESSFULLY = "/html/body/div/div/div[3]/p";
    public static final String SEARCH_TBODY = "/html/body/div[1]/div/div[3]/div[3]/div/div[2]/table/tbody";
    public static final String POPUP_H2 = "/html/body/div[3]/h2";
    public static final String NO_USER_FOUND = "//*[@id='app']/div/div[2]/table/tbody/tr/td";
    public static final String SELECT_STATUS = "/html/body/div/div/div[3]/div[3]/div/div[2]/table/tbody/tr/td[6]/select";

    //PAGE ELEMENTS
    @FindBy(xpath = "/html/body/div/div/div[1]/div/div[3]/div/ul/li[2]/a")
    private WebElement userManagementMenu;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div[1]/div[1]/a")
    private WebElement addNewUser;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div[1]/div[2]/form/div/input")
    private WebElement searchUserField;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div[1]/div[2]/form/div/span/button")
    private WebElement searchButton;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id ="email")
    private WebElement emailField;

    @FindBy(id = "select2-country_id-container")
    private WebElement countryField;

    @FindBy(xpath = "/html/body/span/span/span[1]/input")
    private WebElement countryFieldInput;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div/div/div/form/div[8]/div/button[2]")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id='app']/div/div[2]/table/tbody/tr/td[7]/a[1]")
    private WebElement editButton;

    @FindBy(xpath = "//*[@id='app']/div/div[2]/table/tbody/tr/td[7]/a[2]")
    private WebElement deleteButton;

    @FindBy(xpath = "/html/body/div[3]/div[7]/div/button")
    private WebElement popupYesButton;


    //METHODS
    public void goToUserManagementMenu() {
        LOGGER.info("Navigating to 'User Management' menu.");
        userManagementMenu.click();
    }

    public void addNewUser() {
        LOGGER.info("Add New User.");
        addNewUser.click();
    }

    public void createUser(String name, String email) {
        LOGGER.info("Enter New User's name and email.");
        nameField.sendKeys(name);
        emailField.sendKeys(email);
    }

    public void addCountry(String country) {
        LOGGER.info("Enter New User's country.");
        countryField.click();
        countryFieldInput.sendKeys(country, Keys.ENTER);
    }

    public void pickPermissions(String permissions) {
        LOGGER.info("Select New User's permissions.");
        select(PERMISSIONS_FIELD, permissions);
    }

    public void submit() {
        LOGGER.info("New User created.");
        submitButton.click();
        Assert.assertEquals(getElementText(USER_ADD_CONFIRMATION), "User Add Confirmation");
        Assert.assertEquals(getElementText(ADDED_SUCCESSFULLY), "User added successfully");
    }

    public void searchUser(String searchValue) {
        LOGGER.info("Search for User.");
        searchUserField.sendKeys(searchValue);
        searchButton.click();
        Assert.assertEquals(getElementText(SEARCH_TBODY + "/tr/td[3]"), searchValue);
    }

    public void changeStatus(String status) {
        LOGGER.info("Change User's status.");
        select(SELECT_STATUS, status);
        Assert.assertEquals(getElementText(POPUP_H2), "Are you sure to change status?");
        popupYesButton.click();
    }

    public void editUser() {
        LOGGER.info("Edit User's name and country.");
        editButton.click();
        nameField.sendKeys(" (Edited!)");
        addCountry("Bulgaria");
        submitButton.click();
        Assert.assertEquals(getElementText(ADDED_SUCCESSFULLY), "User updated successfully");
    }

    public void deleteUser() throws InterruptedException {
        LOGGER.info("User was deleted.");
        deleteButton.click();
        Assert.assertEquals(getElementText(POPUP_H2), "Are you sure to delete this user?");
        Thread.sleep(500);
        popupYesButton.click();
        searchButton.click();
        Thread.sleep(500);
        Assert.assertEquals(getElementText(NO_USER_FOUND), "No User Found");
    }

}
