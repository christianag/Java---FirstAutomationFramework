package uitests;

import core.BaseClass;
import org.testng.annotations.*;
import pageobjects.TemplatesPage;

public class TemplatesTests extends BaseClass {

    @BeforeMethod
    public void goToTemplatesMenu() {
        app.templatesPage().goToTemplatesMenu();
    }

    @Test
    public void addNewTemplate() {
        app.templatesPage().addNewTemplate();
        app.templatesPage().selectOrg(TemplatesPage.ORG_NAME);
        app.templatesPage().selectLanguage("Portuguese");
        app.templatesPage().enterTemplateName(TemplatesPage.NEW_TEMPLATE_NAME);
        app.templatesPage().selectDesign("ChrisTest_designviewPT");
        app.templatesPage().selectTypeAndPresentation("Diploma", "Design view");
        app.templatesPage().setExpiryDate("10 years");
        app.templatesPage().testPreviewOptions();
        app.templatesPage().submitNewTemplate();
    }

    @Test (dependsOnMethods = {"addNewTemplate"})
    public void searchForTemplate() throws InterruptedException {
        app.templatesPage().searchTemplateNameField(TemplatesPage.NEW_TEMPLATE_NAME);
        app.templatesPage().doesTemplateExist(TemplatesPage.NEW_TEMPLATE_NAME);
    }

    @Test (dependsOnMethods = {"searchForTemplate"})
    public void issueDiplomaViaGraduationHatAction() throws InterruptedException {
        app.templatesPage().searchTemplateNameField(TemplatesPage.NEW_TEMPLATE_NAME);
        app.templatesPage().doesTemplateExist(TemplatesPage.NEW_TEMPLATE_NAME);
        app.templatesPage().issueDiplomaAction(TemplatesPage.ORG_NAME, TemplatesPage.NEW_TEMPLATE_NAME);
    }

    @Test (dependsOnMethods = {"issueDiplomaViaGraduationHatAction"})
    public void deleteTemplate() throws InterruptedException {
        app.templatesPage().searchTemplateNameField(TemplatesPage.NEW_TEMPLATE_NAME);
        app.templatesPage().doesTemplateExist(TemplatesPage.NEW_TEMPLATE_NAME);
        app.templatesPage().deleteTemplate(TemplatesPage.NEW_TEMPLATE_NAME);
    }

    @Test (dependsOnMethods = {"deleteTemplate"})
    public void testSearchOrgField() throws InterruptedException {
        app.templatesPage().testSearchOrgField(TemplatesPage.ORG_NAME);
        app.templatesPage().areAllResultsUnderTheCorrectOrg(TemplatesPage.ORG_NAME);
    }

}
