package uitests;

import core.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.UserManagementPage;

public class UserManagementTests extends BaseClass {

    @BeforeMethod
    public void goToUserManagementMenu() {
        app.userManagementPage().goToUserManagementMenu();
    }

    @Test
    public void createNewUser() {
        app.userManagementPage().addNewUser();
        app.userManagementPage().createUser("Test Test", UserManagementPage.EMAIL);
        app.userManagementPage().pickPermissions("User");
        app.userManagementPage().submit();
    }

    @Test (dependsOnMethods = {"createNewUser"})
    public void editNewUser() {
        app.userManagementPage().searchUser(UserManagementPage.EMAIL);
        app.userManagementPage().editUser();
    }

    @Test (dependsOnMethods = {"editNewUser"})
    public void changeUserStatus() {
        app.userManagementPage().searchUser(UserManagementPage.EMAIL);
        app.userManagementPage().changeStatus("Inactive");

    }

    @Test (dependsOnMethods = {"changeUserStatus"})
    public void deleteNewUser() throws InterruptedException {
        app.userManagementPage().searchUser(UserManagementPage.EMAIL);
        app.userManagementPage().deleteUser();
    }

}
