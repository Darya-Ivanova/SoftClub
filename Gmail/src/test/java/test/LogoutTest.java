package test;

import Pages.InboxPage;
import core.utils.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    private InboxPage inboxPage;

    @BeforeMethod
    public void login() {
        inboxPage = gmailLogin();
    }

    @Test(description = "Logout test")
    public void logoutTest() {
        Log.info("Logout");
        loginPage = inboxPage.logout();
        Log.info("Check that login page is opened");
        Assert.assertEquals(loginPage.getTitle(), "Gmail", "Wrong title");
    }
}
