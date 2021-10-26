package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.logging.Logger;


public class SearchDiplomasPage extends BasePage {

    public SearchDiplomasPage(WebDriver driver){
        super(driver);
    }
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(SearchDiplomasPage.class));

    // CONSTANTS
    public static final String ORG = "Lab08";
    public static final String TEMPLATE = "ChrisTest06";
    public static final String EMAIL = "kristiana.georgieva@lab08.com";
    public static final String DIPLOMAS_MENU = "/html/body/div/div/div[1]/div/div[3]/div/ul/li[16]/a";
    public static final String SELECT_RESULTS_TBODY = "//*[@id='SearchedList']/tbody";

    // PAGE ELEMENTS
    @FindBy(xpath = DIPLOMAS_MENU)
    private WebElement diplomasMenu;

    @FindBy(xpath = "/html/body/div/div/div[1]/div/div[3]/div/ul/li[16]/ul/li[2]/a")
    private WebElement searchDiplomasMenu;

    @FindBy(xpath = "//*[@id='demo-form2']/div[1]/div[1]/span/span[1]/span")
    private WebElement selectOrg;

    @FindBy(xpath = "/html/body/span/span/span[1]/input")
    private WebElement selectOrgInput;

    @FindBy(xpath = "//*[@id='template-listing']/span/span[1]/span")
    private WebElement selectTemplate;

    @FindBy(xpath = "/html/body/span/span/span[1]/input")
    private WebElement selectTemplateInput;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[3]/div/div[1]/form/div[1]/div[3]/input")
    private WebElement searchByEmailOrName;

    @FindBy(xpath = "//*[@id='demo-form2']/button")
    private WebElement searchButton;


    // METHODS
    public void goToDiplomasMenu() {
        scrollTo(DIPLOMAS_MENU);
        diplomasMenu.click();
        searchDiplomasMenu.click();
    }

    public void search() {
        searchButton.click();
    }

    public void selectOrg(String orgName) {
        selectOrg.click();
        selectOrgInput.sendKeys(orgName, Keys.ENTER);

    }

    public void selectTemplate(String templateName) {
        selectTemplate.click();
        selectTemplateInput.sendKeys(templateName, Keys.ENTER);
    }

    public void searchByEmail(String email) {
        searchByEmailOrName.sendKeys(email);
    }

    public void areResultsCorrect(String searchResult, String type) {
        LOGGER.info("Checking if all search results are correct.");
        if (elementExists(SELECT_RESULTS_TBODY)) {
            int j = switch (type) {
                case "id" -> 1;
                case "name" -> 2;
                case "email" -> 3;
                case "org" -> 4;
                case "template" -> 5;
                default -> 0;
            };
            List<WebElement> listTr = bpDriver.findElements(By.xpath(SELECT_RESULTS_TBODY + "/tr"));
            for (int i = 1; i < listTr.size(); i++) {
                List<WebElement> list = bpDriver.findElements(By.xpath(SELECT_RESULTS_TBODY + "/tr[" + i + "]/td[" + j + "]"));
                for (WebElement webElement : list) {
                    Assert.assertEquals(webElement.getText().trim(), searchResult);
                }
            }
        }
    }

}
