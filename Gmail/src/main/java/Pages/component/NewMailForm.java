package Pages.component;

import Pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewMailForm extends AbstractPage {

    @FindBy(css = "textarea[name='to']")
    private WebElement toInput;
    @FindBy(css = "input[name='subjectbox']")
    private WebElement subjectInput;
    @FindBy(css = "div.editable")
    private WebElement mailTextInput;
    @FindBy(css = ".L3.aoO")
    private WebElement sendButton;

    public NewMailForm(WebDriver driver) {
        super(driver);
    }

    public void sendMail(String to, String subject, String text) {
        toInput.sendKeys(to);
        subjectInput.sendKeys(subject);
        mailTextInput.sendKeys(text);
        sendButton.click();
    }

    @Override
    public void waitLoading() {
        waitForElementEnabled(getDriver().findElement(By.cssSelector(".L3.aoO")));
    }
}
