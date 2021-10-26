package uitests;

import core.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TemplateDesignsTests extends BaseClass {

    @Test
    public void setUpDesignBuilderPage() throws InterruptedException {
        app.templateDesignsPage().goToTemplateDesignsMenu();
        app.templateDesignsPage().setUpDesignName("Automation Design Name");
        app.templateDesignsPage().setUpOrgName("Organization Name");
        app.templateDesignsPage().setLanguage("English");
        app.templateDesignsPage().clickNext();
        app.templateDesignsPage().selectPageFormat("A4 Portrait");
        app.templateDesignsPage().selectLayout();
    }

    @Test (dependsOnMethods = {"setUpDesignBuilderPage"})
    public void addNewElements() {
        app.templateDesignsPage().addTextElement(1);
        app.templateDesignsPage().addBoxElement(2);
        app.templateDesignsPage().addImageElement(3);
        app.templateDesignsPage().addSeparatorElement(4);
    }

    @Test (dependsOnMethods = {"setUpDesignBuilderPage"})
    public void addFields() {
        app.templateDesignsPage().addNewField("Course Title");
        app.templateDesignsPage().addNewField("Course Description");
        app.templateDesignsPage().addNewField("Template Type");
        app.templateDesignsPage().addNewField("Receiver's Name");
        app.templateDesignsPage().addNewField("Issue Date");
        app.templateDesignsPage().addNewField("Preview Badge");
        app.templateDesignsPage().addNewField("Verification Link");
        app.templateDesignsPage().addNewField("Verification QR Code");
        app.templateDesignsPage().addNewField("Expiry Date");
    }

}
