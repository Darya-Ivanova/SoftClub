package Pages;

import core.utils.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    private WebDriver driver;
    private String title;

    public AbstractPage(WebDriver driver){
        this.driver = driver;
        waitLoading();
        title = driver.getTitle();
    }

    protected WebDriver getDriver() {
        return this.driver;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }


    public void waitForElementEnabled(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until((ExpectedCondition<Boolean>) driver -> element.isEnabled());
        } catch (Exception e) {
            Log.info(e + " : " + "Timed out waiting for element: " + element);
            e.printStackTrace();
        }
    }

    public abstract void waitLoading();
}
