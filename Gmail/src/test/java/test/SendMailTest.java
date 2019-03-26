package test;

import Pages.InboxPage;
import Pages.MailPage;
import core.utils.Log;
import core.utils.TestProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SendMailTest extends BaseTest {

    private InboxPage inboxPage;

    @BeforeMethod
    public void login() {
        inboxPage = gmailLogin();
    }

    @AfterMethod
    public void logout() {
        loginPage = inboxPage.logout();
    }

    @Test(description = "Sending mail")
    public void sendMailTest() {
        String to = TestProperties.getEmail();
        String subject = "Test mail";
        String mailText = "This is test mail";
        SoftAssert softAssert = new SoftAssert();

        Log.info("Sending mail");
        inboxPage.sendMail(to, subject, mailText);

        Log.info("Open incoming mail");
        MailPage mailPage = inboxPage.openNewMail();
        Log.info("Check mail information");
        softAssert.assertEquals(mailPage.getSubject(), subject, "Wrong subject");
        softAssert.assertTrue(mailPage.getFrom().contains(to), "Wrong from");
        softAssert.assertTrue(mailPage.getMailText().contains(mailText), "Wrong mail text");

        softAssert.assertAll();
    }
}
