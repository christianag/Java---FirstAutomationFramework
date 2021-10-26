package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.util.List;
import java.util.logging.Logger;

public class TemplateDesignsPage extends BasePage {

    public TemplateDesignsPage(WebDriver driver){
        super(driver);
    }
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(LoginPage.class));

    //CONSTANTS
    public static final String TEMPLATE_DESIGNS_MENU = "/html/body/div/div/div[1]/div/div[3]/div/ul/li[11]/a";
    public static final String POPUP_H2 = "//*[@id='swal2-title']";
    public static final String CREATE_DESIGN_H3 = "/html/body/div/div/div[3]/div[1]/div/h3";
    public static final String SIDEBAR_H4 = "//*[@id='app']/div/div/div/div/div/div[2]/div/div[2]/div[2]/div[1]/h4";
    public static final String ADD_FIELD_BUTTONS = "//*[@id='app']/div/div/div/div/div/div[2]/div/div[1]/div[3]/div[3]/div[1]/button";
    public static final String DATES_DIV = "//*[@id='undefined-picker-container-DatePicker']/div/div[3]/span/div";

    //PAGE ELEMENTS
    @FindBy(xpath = TEMPLATE_DESIGNS_MENU)
    private WebElement templateDesignsMenu;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div/div[1]/div[1]/a[1]")
    private WebElement addDesignButton;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div/div[1]/div[1]/a[2]")
    private WebElement createDesignButton;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div/div[1]/div[2]/div[1]/div/div[2]/input")
    private WebElement orgSearchField;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div/div[1]/div[2]/div[2]/input")
    private WebElement searchByNameField;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div/div[1]/div[2]/div[2]/span/button")
    private WebElement searchButton;

    @FindBy(id = "design-name")
    private WebElement designNameField;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div/div/div/div/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div/div/div[2]")
    private WebElement selectOrgField;

    @FindBy(xpath = "//*[@id='SetUpDesign-1']/div/div[2]/div/div/div/div/div[2]/input")
    private WebElement selectOrgFieldInput;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div/div/div/div/div[2]/div/div/div[2]/div[2]/div[1]/div/div[3]/div/div/div/div/div[2]")
    private WebElement selectLanguageField;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div/div/div/div/div[2]/div/div/div[2]/div[2]/div[1]/div/div[3]/div/div/div/div/div[2]/input")
    private WebElement selectLanguageFieldInput;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div/div/div/div/div[2]/div/div/div[3]/div[2]/button")
    private WebElement nextButton;

    @FindBy(xpath = "/html/body/div[2]/div/div[3]/button[3]")
    private WebElement popupOkButton;

    @FindBy(xpath = "/html/body/div[2]/div/div[3]/button[1]")
    private WebElement popupCancelButton;

    @FindBy(xpath = "//*[@id='SelectLayout4']/div/div[2]")
    private WebElement layout;

    @FindBy(xpath = "//*[@id='app']/div/div/div/div/div/div[2]/div/div[1]/div[1]/button[1]")
    private WebElement assDesignBackground;

    @FindBy(xpath = "//*[@id='app']/div/div/div/div/div/div[2]/div/div[1]/div[1]/button[2]")
    private WebElement addNewElement;

    @FindBy(xpath = "//*[@id='app']/div/div/div/div/div/div[2]/div/div[1]/div[1]/button[3]")
    private WebElement addNewField;

    @FindBy(xpath = "//*[@id='app']/div/div/div/div/div/div[2]/div/div[1]/div[1]/button[4]")
    private WebElement viewDesignInfo;

    @FindBy(xpath = "//*[@id='app']/div/div/div/div/div/div[2]/div/div[1]/div[1]/button[5]")
    private WebElement previewMode;

    @FindBy(xpath = "//*[@id='app']/div/div/div/div/div/div[2]/div/div[2]/div[2]/div[1]/button")
    private WebElement sidebarCloseButton;

    @FindBy(xpath = "//*[@id='app']/div/div/div/div/div/div[2]/div/div[2]/div[2]/div[2]/div/button[1]")
    private WebElement text;

    @FindBy(xpath = "//*[@id='app']/div/div/div/div/div/div[2]/div/div[2]/div[2]/div[2]/div/button[2]")
    private WebElement image;

    @FindBy(xpath = "//*[@id='app']/div/div/div/div/div/div[2]/div/div[2]/div[2]/div[2]/div/button[3]")
    private WebElement separator;

    @FindBy(xpath = "//*[@id='app']/div/div/div/div/div/div[2]/div/div[2]/div[2]/div[2]/div/button[4]")
    private WebElement box;

    @FindBy(xpath = "//*[@id='app']/div/div/div/div/div/div[2]/div/div[1]/div[2]/button[1]")
    private WebElement saveDesign;

    @FindBy(xpath = "//*[@id='app']/div/div/div/div/div/div[2]/div/div[1]/div[2]/button[2]")
    private WebElement saveDesignDropdown;

    @FindBy(xpath = "//*[@id='app']/div/div/div/div/div/div[2]/div/div[1]/div[2]/ul")
    private WebElement saveAndCreateTemplate;

    @FindBy(xpath = "//*[@id='app']/div/div/div/div/div/div[2]/div/div[2]/div[2]/div[3]/input")
    private WebElement previewValueInput;

    @FindBy(xpath = "//*[@id='undefined-wrapper']/input")
    private WebElement inputForDates;

    @FindBy(id = "tinymce")
    private WebElement courseDescription;

    @FindBy(id = "tinymce_widget_preview_1__ifr")
    private WebElement courseDescriptionIframe;

    @FindBy(xpath = "//*[@id='app']/div/div/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[2]/div[1]/div/button")
    private WebElement badgeButton;

    //METHODS
    public void goToTemplateDesignsMenu() {
        LOGGER.info("Going to Template Designs menu.");
        scrollTo(TEMPLATE_DESIGNS_MENU);
        templateDesignsMenu.click();
    }

    public void setUpDesignName(String name) throws InterruptedException {
        LOGGER.info("Add design name.");
        createDesignButton.click();
        clickNext();
        Assert.assertEquals(getElementText(POPUP_H2), "Sorry, can't create design without name");
        popupCancelButton.click();
        designNameField.sendKeys(name);
    }

    public void setUpOrgName(String orgName) throws InterruptedException {
        LOGGER.info("Select organization for the design.");
        clickNext();
        Assert.assertEquals(getElementText(POPUP_H2), "Sorry, no organization selected");
        popupOkButton.click();
        selectOrgField.click();
        selectOrgFieldInput.sendKeys(orgName, Keys.ENTER);
        Thread.sleep(500);
    }

    public void setLanguage(String language) {
        LOGGER.info("Select design language.");
        selectLanguageField.click();
        selectLanguageFieldInput.sendKeys(language, Keys.ENTER);
    }

    public void clickNext() throws InterruptedException {
        LOGGER.info("Click 'next' button.");
        nextButton.click();
        Thread.sleep(500);
    }

    public void selectPageFormat(String format) throws InterruptedException {
        LOGGER.info("Selecting page format.");
        clickNext();
        Assert.assertEquals(getElementText(POPUP_H2), "Sorry, no page format selected");
        popupCancelButton.click();
        int pageID = switch (format) {
            case "A4 Landscape" -> 2;
            case "Letter Portrait" -> 3;
            case "Letter Landscape" -> 4;
            default -> 1; // "A4 Portrait"
        };
        WebElement pageFormat = bpDriver.findElement(By.xpath("//*[@id='SelectPageFormat2']/div/div[" + pageID + "]"));
        pageFormat.click();
        clickNext();
    }

    public void selectLayout() throws InterruptedException {
        LOGGER.info("Selecting default blank layout.");
        clickNext();
        Assert.assertEquals(getElementText(POPUP_H2), "Sorry, no layout selected");
        popupOkButton.click();
        layout.click();
        clickNext();
        Assert.assertEquals(getElementText(CREATE_DESIGN_H3), "Create Design");
    }

    public void addElement() {
        LOGGER.info("Picking a new element.");
        addNewElement.click();
        Assert.assertEquals(getElementText(SIDEBAR_H4), "Select Element Type");
    }

    public void addTextElement(int num) {
        LOGGER.info("Adding a text element.");
        addElement();
        text.click();
        Assert.assertEquals(getElementText(SIDEBAR_H4), "Text");
        Assert.assertTrue(elementExists("//*[@id='page__content']/div[" + num + "]/div[1]"));
    }

    public void addImageElement(int num) {
        LOGGER.info("Adding an image element.");
        addElement();
        image.click();
        Assert.assertEquals(getElementText(SIDEBAR_H4), "Image");
        Assert.assertTrue(elementExists("//*[@id='page__content']/div[" + num + "]/div[1]"));
    }

    public void addSeparatorElement(int num) {
        LOGGER.info("Adding a separator element.");
        addElement();
        separator.click();
        Assert.assertEquals(getElementText(SIDEBAR_H4), "Separator");
        Assert.assertTrue(elementExists("//*[@id='page__content']/div[" + num + "]/div[1]"));
    }

    public void addBoxElement(int num) {
        LOGGER.info("Adding a box element.");
        addElement();
        box.click();
        Assert.assertEquals(getElementText(SIDEBAR_H4), "Box");
        Assert.assertTrue(elementExists("//*[@id='page__content']/div[" + num + "]/div[1]"));
    }

    public void addNewField(String choice) {
        LOGGER.info("Adding a new field.");
        addNewField.click();
        List<WebElement> buttons = bpDriver.findElements(By.xpath(ADD_FIELD_BUTTONS));
        for (WebElement button : buttons) {
            if (button.getText().trim().equals(choice)) {
                button.click();
                break;
            }
        }
        // different fields have different settings in the sidebar pop-up.
        // this is meant to accommodate those that lack a preview value field
        if (choice.equals("Course Description")) {
            bpDriver.switchTo().frame(courseDescriptionIframe);
            courseDescription.sendKeys(choice);
            bpDriver.switchTo().defaultContent();
        } else if (choice.contains("Date")) {
            inputForDates.click();
            datePicker(DATES_DIV, "25");
        } else if (choice.equals("Preview Badge")) {
            badgeButton.click();
        } else if (choice.contains("Verification QR Code")) {
            sidebarCloseButton.click();
        } else {
            addPreviewValue(choice);
        }
    }

    public void addPreviewValue(String choice) {
        LOGGER.info("Entering a preview value.");
        previewValueInput.click();
        previewValueInput.sendKeys(choice);
        sidebarCloseButton.click();
    }

}
