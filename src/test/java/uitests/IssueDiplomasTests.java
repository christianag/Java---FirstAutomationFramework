package uitests;

import core.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.IssueDiplomasPage;

public class IssueDiplomasTests extends BaseClass {

    @BeforeMethod
    public void goToIssueDiplomasMenu() {
        app.issueDiplomasPage().goToDiplomasMenu();
    }

    @Test
    public void issueDiplomaWithExcel() throws InterruptedException {
        app.issueDiplomasPage().selectIssuanceType("Single");
        app.issueDiplomasPage().selectOrg("Organization Name");
        app.issueDiplomasPage().selectTemplate("Template Name");
        app.issueDiplomasPage().clickNext();
        app.issueDiplomasPage().inputType("Upload Excel", IssueDiplomasPage.EXCEL_FILE);
        app.issueDiplomasPage().clickNext();
        app.issueDiplomasPage().issueDiplomasNow();
    }

    @Test
    public void issueDiplomaWithInput() throws InterruptedException {
        app.issueDiplomasPage().selectIssuanceType("Single");
        app.issueDiplomasPage().selectOrg("Organization Name"");
        app.issueDiplomasPage().selectTemplate("Template Name");
        app.issueDiplomasPage().clickNext();
        app.issueDiplomasPage().inputType("Input Form");
        app.issueDiplomasPage().inputForm("Diploma Name", "test@test.com", "10/22/2021");
        app.issueDiplomasPage().clickNext();
        app.issueDiplomasPage().issueDiplomasNow();
    }

    @Test
    public void issueBundleWithExcel() throws InterruptedException {
        app.issueDiplomasPage().selectIssuanceType("Bundle");
        app.issueDiplomasPage().selectOrg("Organization Name");
        app.issueDiplomasPage().selectTemplate("Bundle Name");
        app.issueDiplomasPage().clickNext();
        app.issueDiplomasPage().inputType("Upload Excel", IssueDiplomasPage.EXCEL_FILE);
        app.issueDiplomasPage().clickNext();
        app.issueDiplomasPage().issueDiplomasNow();
    }

    @Test
    public void issueBundleWithInput() throws InterruptedException {
        app.issueDiplomasPage().selectIssuanceType("Bundle");
        app.issueDiplomasPage().selectOrg("Organization Name");
        app.issueDiplomasPage().selectTemplate("Bundle Name");
        app.issueDiplomasPage().clickNext();
        app.issueDiplomasPage().inputType("Input Form");
        app.issueDiplomasPage().inputForm("Diploma Name", "test@test.com", "10/22/2021");
        app.issueDiplomasPage().clickNext();
        app.issueDiplomasPage().issueDiplomasNow();
    }

    @Test
    public void postponeDiplomaWithDate() throws InterruptedException {
        app.issueDiplomasPage().selectIssuanceType("Single");
        app.issueDiplomasPage().selectOrg("Organization Name");
        app.issueDiplomasPage().selectTemplate("Template Name");
        app.issueDiplomasPage().clickNext();
        app.issueDiplomasPage().inputType("Upload Excel", IssueDiplomasPage.EXCEL_FILE);
        app.issueDiplomasPage().clickNext();
        app.issueDiplomasPage().setPostponeDate();
        app.issueDiplomasPage().postponeToSpecificDate("10/30/2021");
        app.issueDiplomasPage().issueDiplomaLater();
    }

    @Test
    public void postponeDiplomaNoPlannedTime() throws InterruptedException {
        app.issueDiplomasPage().selectIssuanceType("Single");
        app.issueDiplomasPage().selectOrg("Organization Name");
        app.issueDiplomasPage().selectTemplate("Template Name");
        app.issueDiplomasPage().clickNext();
        app.issueDiplomasPage().inputType("Input Form");
        app.issueDiplomasPage().inputForm("Diploma Name", "test@test.com", "10/22/2021");
        app.issueDiplomasPage().clickNext();
        app.issueDiplomasPage().setPostponeDate();
        app.issueDiplomasPage().noPlannedTime();
        app.issueDiplomasPage().issueDiplomaLater();
    }

    @Test
    public void postponeBundleWithDate() throws InterruptedException {
        app.issueDiplomasPage().selectIssuanceType("Bundle");
        app.issueDiplomasPage().selectOrg("Organization Name");
        app.issueDiplomasPage().selectTemplate("Bundle Name");
        app.issueDiplomasPage().clickNext();
        app.issueDiplomasPage().inputType("Input Form");
        app.issueDiplomasPage().inputForm("Diploma Name", "test@test.com", "10/22/2021");
        app.issueDiplomasPage().clickNext();
        app.issueDiplomasPage().setPostponeDate();
        app.issueDiplomasPage().postponeToSpecificDate("10/31/2021");
        app.issueDiplomasPage().issueDiplomaLater();
    }

    @Test
    public void postponeBundleNoPlannedTime() throws InterruptedException {
        app.issueDiplomasPage().selectIssuanceType("Bundle");
        app.issueDiplomasPage().selectOrg("Organization Name");
        app.issueDiplomasPage().selectTemplate("Bundle Name");
        app.issueDiplomasPage().clickNext();
        app.issueDiplomasPage().inputType("Upload Excel", IssueDiplomasPage.EXCEL_FILE);
        app.issueDiplomasPage().clickNext();
        app.issueDiplomasPage().setPostponeDate();
        app.issueDiplomasPage().noPlannedTime();
        app.issueDiplomasPage().issueDiplomaLater();
    }

}
