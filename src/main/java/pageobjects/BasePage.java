package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BasePage {

    protected WebDriver bpDriver;
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(BasePage.class));

    public BasePage(WebDriver driver) {
        this.bpDriver = driver;
        PageFactory.initElements(driver, this);
    }

    // METHODS
    protected void testURL(String expected) {
        LOGGER.info("Testing if URL is as expected.");
        Assert.assertEquals(bpDriver.getCurrentUrl(), expected);
    }

    protected void scrollTo(String xpath) {
        LOGGER.info("Scrolling to an element");
        WebElement e = bpDriver.findElement(By.xpath(xpath));
        ((JavascriptExecutor) bpDriver).executeScript("arguments[0].scrollIntoView(true);", e);
    }

    protected void scrollToBottomOfPage() {
        LOGGER.info("Scrolling to bottom of page.");
        ((JavascriptExecutor) bpDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    protected void scrollToTopOfPage() {
        ((JavascriptExecutor) bpDriver).executeScript("window.scrollTo(0, 0)");
    }

    public void select(String location, String option) {
        LOGGER.info("Select an option from a dropdown.");
        Select select = new Select(bpDriver.findElement(By.xpath(location)));
        select.selectByVisibleText(option);
    }

    public void switchBrowserTabs(int tab) {
        LOGGER.info("Switching browser tabs.");
        ArrayList<String> tabs = new ArrayList<>(bpDriver.getWindowHandles());
        bpDriver.switchTo().window(tabs.get(tab));
    }

    public void doesElementExist(String xpath, String expected) {
        LOGGER.info("Check if element exists.");
        if (elementExists(xpath)) {
            Assert.assertEquals(getElementText(xpath), expected);
        }
    }

    public String getElementText(String xpath) {
        LOGGER.info("Get text of element.");
        WebElement element = bpDriver.findElement(By.xpath(xpath));
        return element.getText().trim();
    }

    protected boolean elementExists(String xpath) {
        LOGGER.info("Checking if web element exists.");
        try {
            bpDriver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void urlContains(String contains) {
        LOGGER.info("Check if URL contains a certain part.");
        String editURL = bpDriver.getCurrentUrl();
        Assert.assertTrue(editURL.contains(contains));
    }

    public void datePicker(String allDatesBox, String day) {
        LOGGER.info("Picking date from date picker pop-up.");
        WebElement table = bpDriver.findElement(By.xpath(allDatesBox));
        List<WebElement> buttons = table.findElements(By.tagName("button"));
        mainloop:
        for (WebElement button : buttons) {
            List<WebElement> spans = button.findElements(By.tagName("span"));
            for (int j = 0; j < spans.size(); j++) {
                if (spans.get(j).getText().contains(day)) {
                    button.click();
                    break mainloop;
                }
            }
        }
    }


//    protected void iterateDropdownList(String dropdown, String choice) {
//        List<WebElement> list = bpDriver.findElements(By.xpath(dropdown));
//        for(WebElement webElement : list) {
//            if(webElement.getText().trim().equals(choice)){
//                LOGGER.info(webElement.getText().trim());
//                webElement.click();
//                break;
//            }
//        }
//    }
//
//    protected void iterateThroughList(String table, String choice) {
//        WebElement tableElements = bpDriver.findElement(By.xpath(table));
//        List<WebElement> rows = tableElements.findElements(By.tagName("tr"));
//        mainloop:
//        for (int i = 0; i < rows.size(); i++) {
//            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
//            for (int j = 0; j < cols.size(); j++) {
//                if (cols.get(j).getText().contains(choice)) {
//                    cols.get(0).findElement(By.tagName("input")).click();
//                    break mainloop;
//                }
//            }
//        }
//    }


}
