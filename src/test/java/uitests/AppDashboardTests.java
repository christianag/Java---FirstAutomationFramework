package uitests;

import core.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppDashboardTests extends BaseClass {

    @BeforeMethod
    public void goToDashboard() {
        app.appDashboardPage().logIntoAppDashboard("kristiana.georgieva@lab08.com", "kigQDT21");
    }

    @Test
    public void claimDiploma() {
        app.appDashboardPage().areThereAnyPendingDiplomas();
//        app.appDashboardPage().claimDiploma("ChrisTest_designs");

    }

}
