package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailPage extends AbstractPage {

    @FindBy(css = "img[role='button'][data-tooltip]")
    private WebElement moreInformationButton;
    @FindBy(css = "span.go")
    private WebElement fromLable;
    @FindBy(css = "tr h2")
    private WebElement subjectLabel;
    @FindBy(css = ".ii.gt")
    private WebElement text;

    public MailPage(WebDriver driver) {
        super(driver);
    }

    public String getFrom() {
        moreInformationButton.click();
        return fromLable.getText();
    }

    public String getSubject() {
        return subjectLabel.getText();
    }

    public String getMailText() {
        return text.getText();
    }

    @Override
    public void waitLoading() {
        waitForElementEnabled(getDriver().findElement(By.cssSelector("img[role='button'][data-tooltip]")));
    }
}
