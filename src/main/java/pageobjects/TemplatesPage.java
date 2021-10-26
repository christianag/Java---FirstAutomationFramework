package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.util.List;
import java.util.logging.Logger;

public class TemplatesPage extends BasePage {

    public TemplatesPage(WebDriver driver) {
        super(driver);
    }
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(TemplatesPage.class));
    static int languageID = 1;

    // CONSTANTS
    public static final String NEW_TEMPLATE_NAME = "ChrisTest_designviewPT";
    public static final String ORG_NAME = "Lab08";
    public static final String TEMPLATES_MENU = "//ul[@class='nav side-menu']//li[14]/a";
    public static final String TEMPLATE_TYPE = "//*[@id='template-type-select']";
    public static final String PRESENTATION_VIEW = "//*[@id='presentation_view_select']";
    public static final String PREVIEW_PDF = "//button[@id='previewPDF']";
    public static final String PREVIEW_ONLINE = "//button[@id='previewPDF']";
    public static final String SUCCESSFULLY_SUBMITTED = "/html/body/div/div/div[3]/p";
    public static final String SEARCH_RESULTS_TABLE = "//*[@id='app']/div/div/div[2]/table/tbody";
    public static final String DELETE_TEMPLATE_POPUP = "/html/body/div[2]/div";
    public static final String SEARCH_ORG_LIST = "/html/body/div/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div[1]/div/div/div[3]/ul/li";
    public static final String SELECT_DESIGN_LIST = "//*[@id='1-designs']/div/div/div[3]/ul/li";
    public static final String SELECT_EXPIRY_DATE = "/html/body/div[1]/div/div[3]/div[3]/div/div/div/div/form/div[10]/div/select";

    // PAGE ELEMENTS
    @FindBy(xpath = TEMPLATES_MENU)
    private WebElement templatesMenu;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div/div[1]/div/div[1]/a")
    private WebElement addNewTemplateButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div[3]/div/div/div/div/form/div[2]/div[1]/div/div/div/div[2]")
    private WebElement orgField;

    @FindBy(xpath = "//*[@id='templateFrom']/div[2]/div[1]/div/div/div/div[2]/input")
    private WebElement orgFieldInput;

    @FindBy(xpath = "//*[@id='templateFrom']/div[2]/div[3]/div/div/div/div[2]")
    private WebElement languageField;

    @FindBy(xpath = "//*[@id='templateFrom']/div[2]/div[3]/div/div/div/div[2]/input")
    private WebElement languageFieldInput;

    @FindBy(xpath = "//*[@id='extra_name']")
    private WebElement nameField;

    @FindBy(xpath = "//*[@id='template-type-select']")
    private WebElement templateType;

    @FindBy(xpath = PREVIEW_PDF)
    private WebElement previewPdf;

    @FindBy(xpath = PREVIEW_ONLINE)
    private WebElement previewOnline;

    @FindBy(xpath = "//*[@id='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div[2]/input")
    private WebElement searchByTemplateName;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div[2]/span/button")
    private WebElement searchTemplateButton;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div[1]/div/div")
    private WebElement searchOrganizationField;

    @FindBy(xpath = "//*[@id='app']/div/div/div[2]/table/tbody/tr/td[7]/a[1]")
    private WebElement actionsGraduationHat;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div/div[2]/table/tbody/tr/td[7]/a[3]")
    private WebElement actionsDeleteButton;

    @FindBy(xpath = "/html/body/div[2]/div/div/button[3]")
    private WebElement popUpButtonOK;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div[3]/div/div[2]/div/button")
    private WebElement manageTagsButton;

    @FindBy(xpath = "//*[@id='IssueDiplomas2']/div/div[2]/div[1]/div/div/div/div/div[2]")
    private WebElement selectOrgField;

    @FindBy(xpath = "//*[@id='IssueDiplomas2']/div/div[2]/div[2]/div[1]/div/div/div/div/div[2]")
    private WebElement selectTemplate;


    // METHODS
    public void goToTemplatesMenu() {
        LOGGER.info("Going to Templates menu.");
        scrollTo(TEMPLATES_MENU);
        templatesMenu.click();
    }

    public void searchTemplateNameField(String name) throws InterruptedException {
        LOGGER.info("Searching for template via Search Template Name field.");
        searchByTemplateName.sendKeys(name);
        Thread.sleep(500);
        searchTemplateButton.click();
        Thread.sleep(500);
    }

    public void addNewTemplate() {
        LOGGER.info("Adding a new template.");
        addNewTemplateButton.click();
    }

    public void selectOrg(String orgName) {
        LOGGER.info("Selecting an organization.");
        orgField.click();
        orgFieldInput.sendKeys(orgName, Keys.ENTER);
    }

    public void selectLanguage(String language) {
        LOGGER.info("Getting language ID number.");
        languageID = switch (language) {
            case "Danish" -> 2;
            case "Portuguese" -> 3;
            case "Dutch" -> 4;
            case "Italian" -> 5;
            case "Russian" -> 6;
            case "Lithuanian" -> 7;
            case "Polish" -> 8;
            case "Icelandic" -> 9;
            case "Spanish" -> 10;
            case "German" -> 11;
            case "French" -> 12;
            case "Turkish" -> 13;
            default -> 1; // English
        };
        LOGGER.info("Entering preferred language.");
        languageField.click();
        languageFieldInput.sendKeys(language, Keys.ENTER);
    }

        public void enterTemplateName (String templateName){
            LOGGER.info("Entering the template name and title.");
            WebElement titleField = bpDriver.findElement(By.id("name" + languageID + "-first"));
            nameField.sendKeys(templateName);
            titleField.sendKeys(templateName);
        }

        public void selectTypeAndPresentation (String templateType, String presentationView){
            scrollTo(TEMPLATE_TYPE);
            LOGGER.info("Selecting template type and preview.");
            select(TEMPLATE_TYPE, templateType);
            select(PRESENTATION_VIEW, presentationView);
        }

        public void selectDesign (String designName){
            LOGGER.info("Selecting the design.");
            WebElement selectDesign = bpDriver.findElement(By.xpath("//*[@id='" + languageID + "-designs']/div/div/div[2]"));
            WebElement selectDesignInput = bpDriver.findElement(By.xpath("//*[@id='" + languageID + "-designs']/div/div/div[2]/input"));
            selectDesign.click();
            selectDesignInput.sendKeys(designName, Keys.ENTER);
        }

        public void setExpiryDate (String date){
            LOGGER.info("Selecting the expiry date.");
            select(SELECT_EXPIRY_DATE, date);
        }

        public void testPreviewOptions () {
            LOGGER.info("Testing the preview template options.");
            scrollTo(PREVIEW_PDF);
            previewPdf.click();
            previewOnline.click();
        }

        public void submitNewTemplate() {
            switchBrowserTabs(0);
            LOGGER.info("Submitting the new template.");
            submitButton.click();
            if (elementExists(SUCCESSFULLY_SUBMITTED)) {
                doesElementExist(SUCCESSFULLY_SUBMITTED, "Template added successfully");
            }
        }

        public void doesTemplateExist(String templateName){
            LOGGER.info("Checking if the template exists via search fields.");
            if (elementExists(SEARCH_RESULTS_TABLE + "//td[3]")) {
                LOGGER.info("Template exists!");
                Assert.assertEquals(getElementText(SEARCH_RESULTS_TABLE + "//td[3]"), templateName);
            } else {
                LOGGER.info("Template does not exist.");
                Assert.assertEquals(getElementText(SEARCH_RESULTS_TABLE + "//td"), "No Template Found");
            }
        }

        public void testSearchOrgField (String orgName) throws InterruptedException {
            LOGGER.info("Testing the Search Organization field.");
            searchOrganizationField.click();
            searchOrganizationField.sendKeys(orgName, Keys.ENTER);
            Thread.sleep(1500);
        }

        public void areAllResultsUnderTheCorrectOrg (String orgName){
            LOGGER.info("Checking if all search results belong to the correct organization.");
            if (elementExists(SEARCH_RESULTS_TABLE)) {
                List<WebElement> list = bpDriver.findElements(By.xpath(SEARCH_RESULTS_TABLE + "//td[4]"));
                for (WebElement webElement : list) {
                    Assert.assertEquals(webElement.getText().trim(), orgName);
                }
            }
        }

        public void deleteTemplate (String templateName){
            LOGGER.info("Deleting template.");
            actionsDeleteButton.click();
            if (elementExists(DELETE_TEMPLATE_POPUP)) {
                popUpButtonOK.click();
                doesTemplateExist(templateName);
            }
        }

        public void issueDiplomaAction (String orgName, String templateName) throws InterruptedException {
            LOGGER.info("Testing the Issue Diploma action button.");
            actionsGraduationHat.click();
            Thread.sleep(500);
            Assert.assertEquals(selectOrgField.getText().trim(), orgName);
            Assert.assertEquals(selectTemplate.getText().trim(), templateName);
        }
}
