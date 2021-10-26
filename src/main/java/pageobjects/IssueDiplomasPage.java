package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.util.logging.Logger;

public class IssueDiplomasPage extends BasePage {

    public IssueDiplomasPage(WebDriver driver){
        super(driver);
    }
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(IssueDiplomasPage.class));

    // CONSTANTS
    public static final String DIPLOMAS_MENU = "/html/body/div/div/div[1]/div/div[3]/div/ul/li[16]/a";
    public static final String ISSUANCE_TYPE_FIELD = "/html/body/div/div/div[3]/div[3]/div/div/div/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div/div/div[2]";
    public static final String SELECT_ORG_FIELD = "/html/body/div/div/div[3]/div[3]/div/div/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div/div/div/div/div/div[2]";
    public static final String SELECT_TEMPLATE_FIELD = "/html/body/div/div/div[3]/div[3]/div/div/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[1]/div/div/div/div/div[2]";
    public static final String INPUT_TYPE = "/html/body/div/div/div[3]/div[3]/div/div/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div";
    public static final String EXCEL_FILE = "C:\\Users\\Kristiana\\Desktop\\Java\\FirstAutomationTests\\automation.xls";
    public static final String SUCCESSFUL_DIPLOMA_ISSUANCE = "//*[@id='appV]/div/div/div/div/section/div/h3";
    public static final String ISSUE_DIPLOMAS_NOW_BUTTON = "//*[@id='app']/div/div/div/div/div[2]/div/div[3]/div[2]/button[1]";
    public static final String CALENDAR_DAYS_LIST = "/html/body/div/div/div[3]/div[3]/div/div/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/form/div/div/div[3]/div/div/div/div[1]/div/div/div[3]";
    public static final String POSTPONE_POPUP = "//*[@id='app']/div/div/div/div/div[2]/div[2]/div/div";
    public static final String NO_PLANNED_TIME = "//*[@id='app']/div/div/div/div/div[2]/div[2]/div/div/div[1]/div[2]/div";
    public static final String POSTPONE_CALENDAR_DAYS = "/html/body/div/div/div[3]/div[3]/div/div/div/div/div[2]/div[2]/div/div/div[1]/div[2]/span/div[2]/div[1]/div[1]/div/div/div[1]/div[1]/div/div[3]/span/div";

    // PAGE ELEMENTS
    @FindBy(xpath = DIPLOMAS_MENU)
    private WebElement diplomasMenu;

    @FindBy(xpath = "/html/body/div/div/div[1]/div/div[3]/div/ul/li[16]/ul/li[1]/a")
    private WebElement issueDiplomasMenu;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div/div/div/div[2]/div/div[3]/div[2]/button")
    private WebElement nextButton;

    @FindBy(xpath = ISSUANCE_TYPE_FIELD)
    private WebElement selectIssuanceType;

    @FindBy(xpath = ISSUANCE_TYPE_FIELD + "/input")
    private WebElement selectIssuanceTypeInput;

    @FindBy(xpath = SELECT_ORG_FIELD)
    private WebElement selectOrgField;

    @FindBy(xpath = SELECT_ORG_FIELD + "/input")
    private WebElement selectOrgFieldInput;

    @FindBy(xpath = SELECT_TEMPLATE_FIELD)
    private WebElement selectTemplateField;

    @FindBy(xpath = SELECT_TEMPLATE_FIELD + "/input")
    private WebElement selectTemplateFieldInput;

    @FindBy(xpath = INPUT_TYPE + "/input[2]")
    private WebElement manualInput;

    @FindBy(xpath = "//*[@id='file']")
    private WebElement uploadFile;

    @FindBy(xpath = ISSUE_DIPLOMAS_NOW_BUTTON)
    private WebElement issueDiplomasNowButton;

    @FindBy(xpath = "//*[@id='app']/div/div/div/div/div[2]/div/div[3]/div[2]/button[2]")
    private WebElement issueDiplomasLaterButton;

    @FindBy(xpath = "//*[@id='app']/div/div/div/div/section/button")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@id='IssueDiplomas2']/div/div[2]/div[3]/div/div[2]/div/div[2]/form/div/div/div[1]/input")
    private WebElement inputNameField;

    @FindBy(xpath = "//*[@id='IssueDiplomas2']/div/div[2]/div[3]/div/div[2]/div/div[2]/form/div/div/div[2]/input")
    private WebElement inputEmailField;

    @FindBy(xpath = "//*[@id='undefined-wrapper']/input")
    private WebElement inputDateField;

    @FindBy(xpath = "//*[@id='undefined-wrapper']/div/div/div[2]/button")
    private WebElement inputDateButton;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/form/div/div/div[3]/div/div/div/div[2]/button")
    private WebElement calendarOkButton;

    @FindBy(xpath = NO_PLANNED_TIME + "/label")
    private WebElement noPlannedTimeLabel;

    @FindBy(xpath = NO_PLANNED_TIME + "/input")
    private WebElement noPlannedTimeCheckbox;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div/div/div/div[2]/div[2]/div/div/div[2]/button[2]")
    private WebElement getIssueDiplomasLaterButton2;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div/div/div/div[2]/div[2]/div/div/div[1]/div[2]/span/div[2]/div[1]/div[1]/input")
    private WebElement postponeCalendarInput;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div/div/div/div[2]/div[2]/div/div/div[1]/div[2]/span/div[2]/div[1]/div[1]/div/div/div[2]/button")
    private WebElement postponeCalendarOkButton;


    // METHODS
    public void goToDiplomasMenu() {
        scrollTo(DIPLOMAS_MENU);
        diplomasMenu.click();
        issueDiplomasMenu.click();
    }

    public void clickNext() {
        LOGGER.info("Clicking 'Next' button.");
        nextButton.click();
    }

    public void selectIssuanceType(String type) {
        LOGGER.info("Selecting issuence type: " + type);
        selectIssuanceType.click();
        selectIssuanceTypeInput.sendKeys(type, Keys.ENTER);
        clickNext();
    }

    public void selectOrg(String orgName) throws InterruptedException {
        LOGGER.info("Selecting organization: " + orgName);
        selectOrgField.click();
        selectOrgFieldInput.sendKeys(orgName, Keys.ENTER);
        Thread.sleep(500);
    }

    public void selectTemplate(String templateName) throws InterruptedException {
        LOGGER.info("Selecting template: "+ templateName);
        selectTemplateField.click();
        selectTemplateFieldInput.sendKeys(templateName, Keys.ENTER);
        Thread.sleep(500);
    }

    public void inputType(String inputType, String... excelFile) throws InterruptedException {
        LOGGER.info("Selecting input type.");
        if(inputType.matches("Upload Excel")) {
            LOGGER.info("Inputting issuance data via excel file.");
            uploadFile.sendKeys(excelFile);
        } else {
            manualInput.click();
        }
        Thread.sleep(500);
    }

    public void inputForm(String name, String email, String date) throws InterruptedException {
        LOGGER.info("Filling out the input form manually.");
        scrollToBottomOfPage();
        inputNameField.sendKeys(name);
        inputEmailField.sendKeys(email);
        inputDateField.sendKeys(date);
        inputDateField.click();
        datePicker(CALENDAR_DAYS_LIST, getDayFromDate(date));
        calendarOkButton.click();
        Thread.sleep(500);
    }


    public void issueDiplomasNow() throws InterruptedException {
        LOGGER.info("Issuing diploma now.");
        Thread.sleep(500);
        scrollTo(ISSUE_DIPLOMAS_NOW_BUTTON);
        issueDiplomasNowButton.click();
        if(elementExists(SUCCESSFUL_DIPLOMA_ISSUANCE)) {
            Assert.assertEquals(getElementText(SUCCESSFUL_DIPLOMA_ISSUANCE), "All done!");
        }
    }

    public void setPostponeDate() throws InterruptedException {
        LOGGER.info("Issuing diploma later.");
        Thread.sleep(500);
        scrollTo(ISSUE_DIPLOMAS_NOW_BUTTON);
        issueDiplomasLaterButton.click();
        if(elementExists(POSTPONE_POPUP)) {
            Assert.assertEquals(noPlannedTimeLabel.getText().trim(), "No planned time");
        }
    }

    public void noPlannedTime() {
        LOGGER.info("Click 'No planned time' checkbox.");
        noPlannedTimeCheckbox.click();
    }

    public void postponeToSpecificDate(String date) {
        LOGGER.info("Selecting postpone date.");
        postponeCalendarInput.click();
        datePicker(POSTPONE_CALENDAR_DAYS, getDayFromDate(date));
        postponeCalendarOkButton.click();
    }

    public void issueDiplomaLater() {
        LOGGER.info("Click 'Issue Later' button");
        getIssueDiplomasLaterButton2.click();
        scrollToTopOfPage();
        if(elementExists(SUCCESSFUL_DIPLOMA_ISSUANCE)) {
            Assert.assertEquals(getElementText(SUCCESSFUL_DIPLOMA_ISSUANCE), "All done!");
        }
    }

    public static String getDayFromDate(String date) {
        LOGGER.info("Splitting day from provided full date.");
        String[] dateParts = date.split("/");
        return dateParts[1];
    }

}
