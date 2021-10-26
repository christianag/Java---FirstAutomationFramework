package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import java.util.List;
import java.util.logging.Logger;

public class OrganizationsPage extends BasePage {

    public OrganizationsPage(WebDriver driver) { super(driver); }
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(OrganizationsPage.class));

    // CONSTANTS
    public static final String ORG_MENU_LOCATION = "/html/body/div/div/div[1]/div/div[3]/div/ul/li[3]/a";
    public static final String NEW_ORG_NAME = "TEST Foobar – For testing purposes only";
    public static final String ORG_IMAGE= "//*[@id='image']";
    public static final String DESIGN_SUPPORT_CHECKBOX = "//*[@id='designs_checkbox']";
    public static final String SUBMIT_NEW_ORG = "//*[@id='btnSubmit']";
    public static final String NEW_ORG_IMAGE = "C:\\Users\\Kristiana\\Desktop\\Logos for Testing\\test.png";
    public static final String SUCCESSFUL_SUBMISSION = "/html/body/div/div/div[3]/p";
    public static final String ORG_SEARCH_TBODY = "/html/body/div/div/div[3]/div[3]/div/div[2]/table/tbody";
    public static final String DELETE_POPUP = "/html/body/div[3]";
    public static final String DELETE_POPUP_BUTTON = "/html/body/div[3]/div[7]/div/button";

    // PAGE ELEMENTS
    @FindBy(xpath = ORG_MENU_LOCATION)
    private WebElement organizationsMenu;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div[3]/div[3]/div/div[1]/div[1]/a")
    private WebElement addNewOrgButton;

    @FindBy(xpath = "//*[@id='name']")
    private WebElement orgNameField;

    @FindBy(xpath = "//*[@id='email']")
    private WebElement orgEmailField;

    @FindBy(xpath = "//*[@id='tinymce_en-US_desc_ifr']")
    private WebElement descriptionIframe;

    @FindBy(xpath = "//*[@id='tinymce']")
    private WebElement orgDescriptionField;

    @FindBy(xpath = "//*[@id='share_title2-first']")
    private WebElement shareTitleField;

    @FindBy(xpath = "/html/body/span/span/span[1]/input")
    private WebElement countryField;

    @FindBy(xpath = "//*[@id='link_web']")
    private WebElement linkWebField;

    @FindBy(xpath = "//*[@id='multiline-titles-check']")
    private WebElement enableMultilangTitles;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div[1]/div[2]/form/div/input")
    private WebElement searchOrgField;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div[1]/div[2]/form/div/span/button")
    private WebElement searchButton;

    @FindBy(xpath = "/html/body/div[3]")
    private WebElement popUp;

    @FindBy(xpath = ORG_IMAGE)
    private WebElement orgImage;

    @FindBy(xpath = DESIGN_SUPPORT_CHECKBOX)
    private WebElement checkboxDesignsSupport;

    @FindBy(xpath = SUBMIT_NEW_ORG)
    private WebElement submitNewOrg;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div[2]/table/tbody/tr/td[8]/a[1]")
    private WebElement editButton;


    // METHODS
    public void goToOrganizationsMenu() {
        LOGGER.info("Navigating to the Organizations menu.");
        scrollTo(ORG_MENU_LOCATION);
        organizationsMenu.click();
    }

    public void findOrg(String orgName) throws InterruptedException {
        LOGGER.info("Searching for organization: " + orgName);
        searchOrgField.sendKeys(orgName);
        searchButton.click();
        Thread.sleep(1000);
    }

    // CREATE NEW ORG METHODS
    public void iframeOrgDescription(String iframeText) {
        LOGGER.info("Entering text in description field.");
        bpDriver.switchTo().frame(descriptionIframe);
        orgDescriptionField.sendKeys(iframeText);
        bpDriver.switchTo().defaultContent();
    }

    public void fillOutNewOrgForm(String orgName) {
        LOGGER.info("Filling out the new orgnaization form.");
        addNewOrgButton.click();
        orgNameField.sendKeys(orgName);
        iframeOrgDescription("test test");
        shareTitleField.sendKeys("this is a shared title");
        scrollTo(ORG_IMAGE);
        orgImage.sendKeys(NEW_ORG_IMAGE);
        linkWebField.sendKeys("http://test.com");
        scrollTo(DESIGN_SUPPORT_CHECKBOX);
        checkboxDesignsSupport.click();
        enableMultilangTitles.click();
        scrollTo(SUBMIT_NEW_ORG);
        submitNewOrg.click();
    }

    public void wasSubmissionSuccessful() {
        LOGGER.info("Organization was created.");
        doesElementExist(SUCCESSFUL_SUBMISSION, "Organization added successfully");
    }

    public boolean doesOrgExist(String orgName) {
        LOGGER.info("Check if organization can be found via search fields.");
        if (elementExists(ORG_SEARCH_TBODY + "//td[2]")) {
            Assert.assertEquals(getElementText(ORG_SEARCH_TBODY + "//td[2]"), orgName);
            return true;
        } else {
            noOrgFound();
            return false;
        }
    }

    public void noOrgFound() {
        LOGGER.info("Organization was not found.");
        Assert.assertEquals(getElementText(ORG_SEARCH_TBODY + "//td"), "No Organization Found");
    }

    public void ifOrgIsFoundDoTheseSmokeTests() {
        LOGGER.info("Smoke tests.");
        bpDriver.findElement(By.xpath(ORG_SEARCH_TBODY + "/tr/td[5]")).click();
        String associationsURL = bpDriver.getCurrentUrl();
        Assert.assertTrue(associationsURL.contains("admin.diplomasafe.net/en-US/admin/orgz-associate/"));
        bpDriver.navigate().back();
        bpDriver.findElement(By.xpath(ORG_SEARCH_TBODY + "/tr/td[7]/select")).click();
        List<WebElement> listStatus = bpDriver.findElements(By.xpath(ORG_SEARCH_TBODY + "/tr/td[7]/select/option"));
        Assert.assertEquals(listStatus.size(), 3);
        bpDriver.findElement(By.xpath(ORG_SEARCH_TBODY + "/tr/td[8]/a[1]")).click();
        urlContains("admin.diplomasafe.net/en-US/admin/organization-edit/");
        bpDriver.navigate().back();
        bpDriver.findElement(By.xpath(ORG_SEARCH_TBODY + "/tr/td[8]/div/button")).click();
        List<WebElement> listActions = bpDriver.findElements(By.xpath(ORG_SEARCH_TBODY + "//div/ul/li"));
        Assert.assertEquals(listActions.size(), 11);
    }

    public void deleteOrg() throws InterruptedException {
        LOGGER.info("Deleting organization.");
        bpDriver.findElement(By.xpath(ORG_SEARCH_TBODY + "/tr/td[8]/a[2]")).click();
        if (elementExists(DELETE_POPUP)) {
            Thread.sleep(500);
            bpDriver.findElement(By.xpath(DELETE_POPUP_BUTTON)).click();
            Thread.sleep(500);
            bpDriver.findElement(By.xpath(DELETE_POPUP_BUTTON)).click();
            WebElement successfulDelete = bpDriver.findElement(By.xpath(DELETE_POPUP + "/h2"));
            Assert.assertEquals(successfulDelete.getText().trim(), "Success");
//            bpDriver.findElement(By.xpath(DELETE_POPUP_BUTTON)).click();
        }
    }

    public void editOrg(String orgName) {
        LOGGER.info("Editing Organization.");
        editButton.click();
        orgEmailField.sendKeys("edited@mail.com");
        iframeOrgDescription(" This is edited.");
        scrollTo(SUBMIT_NEW_ORG);
        submitNewOrg.click();
        searchOrgField.sendKeys(orgName);
        if(elementExists(ORG_SEARCH_TBODY)) {
            WebElement checkEditedEmail = bpDriver.findElement(By.xpath(ORG_SEARCH_TBODY + "/tr/td[3]"));
            Assert.assertEquals(checkEditedEmail.getText().trim(), "edited@mail.com");
        }
    }


}
