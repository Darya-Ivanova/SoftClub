package test;

import Pages.InboxPage;
import core.utils.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Login test")
    public void loginTest() {
        Log.info("Login");
        InboxPage inboxPage = gmailLogin();
        Log.info("Check that InboxPage opened");
        Assert.assertEquals(inboxPage.getCurrentUrl(), "https://mail.google.com/mail/u/0/#inbox", "Wrong URL");
    }
}
