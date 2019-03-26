package Pages;

import core.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

    @FindBy(css = "#identifierId")
    private WebElement emailInput;
    @FindBy(css = "#identifierNext")
    private WebElement emailNextButton;
    @FindBy(css = "#password input")
    private WebElement passwordInput;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public InboxPage login(String email, String password) {
        Log.info("Login with " + email);
        emailInput.sendKeys(email);
        emailNextButton.click();
        waitForElementEnabled(passwordInput);
        passwordInput.sendKeys(password);
        passwordInput.sendKeys(Keys.ENTER);
        return PageFactory.initElements(super.getDriver(), InboxPage.class);
    }

    @Override
    public void waitLoading() {
        waitForElementEnabled(getDriver().findElement(By.cssSelector("#identifierId,#password input")));
    }
}
