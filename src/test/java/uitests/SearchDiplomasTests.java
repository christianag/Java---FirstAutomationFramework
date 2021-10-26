package uitests;

import core.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.SearchDiplomasPage;

public class SearchDiplomasTests extends BaseClass {

    @BeforeMethod
    public void goToSearchDiplomas() {
        app.searchDiplomasPage().goToDiplomasMenu();
    }

    @Test
    public void searchByOrg() {
        app.searchDiplomasPage().selectOrg(SearchDiplomasPage.ORG);
        app.searchDiplomasPage().search();
        app.searchDiplomasPage().areResultsCorrect(SearchDiplomasPage.ORG, "org");
    }

    @Test
    public void searchByTemplate() {
        app.searchDiplomasPage().selectTemplate(SearchDiplomasPage.TEMPLATE);
        app.searchDiplomasPage().search();
        app.searchDiplomasPage().areResultsCorrect(SearchDiplomasPage.TEMPLATE, "template");
    }

    @Test
    public void searchByEmail() {
        app.searchDiplomasPage().searchByEmail(SearchDiplomasPage.EMAIL);
        app.searchDiplomasPage().search();
        app.searchDiplomasPage().areResultsCorrect(SearchDiplomasPage.EMAIL, "email");
    }

    @Test
    public void serachByOrgAndTemplate() throws InterruptedException {
        app.searchDiplomasPage().selectOrg(SearchDiplomasPage.ORG);
        Thread.sleep(500);
        app.searchDiplomasPage().selectTemplate(SearchDiplomasPage.TEMPLATE);
        app.searchDiplomasPage().search();
        app.searchDiplomasPage().areResultsCorrect(SearchDiplomasPage.ORG, "org");
        app.searchDiplomasPage().areResultsCorrect(SearchDiplomasPage.TEMPLATE, "template");
    }

    @Test
    public void serachByOrgAndEmail() throws InterruptedException {
        app.searchDiplomasPage().selectOrg(SearchDiplomasPage.ORG);
        Thread.sleep(500);
        app.searchDiplomasPage().searchByEmail(SearchDiplomasPage.EMAIL);
        app.searchDiplomasPage().search();
        app.searchDiplomasPage().areResultsCorrect(SearchDiplomasPage.ORG, "org");
        app.searchDiplomasPage().areResultsCorrect(SearchDiplomasPage.EMAIL, "email");
    }

    @Test
    public void serachByTemplateAndEmail() throws InterruptedException {
        app.searchDiplomasPage().selectTemplate(SearchDiplomasPage.TEMPLATE);
        Thread.sleep(500);
        app.searchDiplomasPage().searchByEmail(SearchDiplomasPage.EMAIL);
        app.searchDiplomasPage().search();
        app.searchDiplomasPage().areResultsCorrect(SearchDiplomasPage.TEMPLATE, "template");
        app.searchDiplomasPage().areResultsCorrect(SearchDiplomasPage.EMAIL, "email");
    }

    @Test
    public void searchByAll() throws InterruptedException {
        app.searchDiplomasPage().selectOrg(SearchDiplomasPage.ORG);
        Thread.sleep(500);
        app.searchDiplomasPage().selectTemplate(SearchDiplomasPage.TEMPLATE);
        Thread.sleep(500);
        app.searchDiplomasPage().searchByEmail(SearchDiplomasPage.EMAIL);
        Thread.sleep(500);
        app.searchDiplomasPage().search();
        app.searchDiplomasPage().areResultsCorrect(SearchDiplomasPage.ORG, "org");
        app.searchDiplomasPage().areResultsCorrect(SearchDiplomasPage.TEMPLATE, "template");
        app.searchDiplomasPage().areResultsCorrect(SearchDiplomasPage.EMAIL, "email");
    }

}
