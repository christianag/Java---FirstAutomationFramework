package uitests;

import core.BaseClass;
import org.testng.annotations.*;
import pageobjects.OrganizationsPage;

public class OrganizationsTests extends BaseClass {

    @BeforeMethod
    public void goToOrgMenu() {
        app.organizationsPage().goToOrganizationsMenu();
    }

    @Test
    public void addNewOrg() {
        app.organizationsPage().fillOutNewOrgForm(OrganizationsPage.NEW_ORG_NAME);
        app.organizationsPage().wasSubmissionSuccessful();
    }

    @Test (dependsOnMethods={"addNewOrg"})
    public void searchNewOrg() throws InterruptedException {
        app.organizationsPage().findOrg(OrganizationsPage.NEW_ORG_NAME);
        if (app.organizationsPage().doesOrgExist(OrganizationsPage.NEW_ORG_NAME)) {
            app.organizationsPage().ifOrgIsFoundDoTheseSmokeTests();
        } else {
            app.organizationsPage().noOrgFound();
        }
    }

    @Test (dependsOnMethods={"searchNewOrg"})
    public void editNewOrg() throws InterruptedException {
        app.organizationsPage().findOrg(OrganizationsPage.NEW_ORG_NAME);
        app.organizationsPage().editOrg(OrganizationsPage.NEW_ORG_NAME);
    }

    @Test (dependsOnMethods={"editNewOrg"})
    public void deleteNewOrg() throws InterruptedException {
        app.organizationsPage().findOrg(OrganizationsPage.NEW_ORG_NAME);
        if (app.organizationsPage().doesOrgExist(OrganizationsPage.NEW_ORG_NAME)) {
            app.organizationsPage().deleteOrg();
        } else {
            app.organizationsPage().noOrgFound();
        }
    }

}
