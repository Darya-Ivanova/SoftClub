package Pages;

import Pages.component.NewMailForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage extends AbstractPage {

    @FindBy(css = ".gb_oc a.gb_f")
    private WebElement accountButton;
    @FindBy(css = ".gb_Ta a.gb_Zf")
    private WebElement logoutButton;
    @FindBy(css = ".L3[gh='cm']")
    private WebElement newMailButton;
    @FindBy(xpath = "//tr[@jsmodel='nXDxbd']")
    private WebElement newMailRow;

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage logout() {
        accountButton.click();
        logoutButton.click();
        return PageFactory.initElements(super.getDriver(), LoginPage.class);
    }

    public void sendMail(String to, String subject, String text) {
        newMailButton.click();
        NewMailForm newMailForm = PageFactory.initElements(getDriver(), NewMailForm.class);
        newMailForm.sendMail(to, subject, text);
    }

    public MailPage openNewMail() {
        waitForElementEnabled(newMailRow);
        newMailRow.click();
        return PageFactory.initElements(getDriver(), MailPage.class);
    }

    @Override
    public void waitLoading() {
        waitForElementEnabled(getDriver().findElement(By.cssSelector(".gb_oc a.gb_f")));
    }
}
