package test;

import Pages.InboxPage;
import Pages.LoginPage;
import core.browserDriver.BrowserFactory;
import core.utils.Log;
import core.utils.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void startBrowser() {
        Log.info("Start Tests in: " + getClass().getSimpleName());
        startDriver();
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        closeDriver();
        Log.info("End of Tests in: " + getClass().getSimpleName() + "\n");
    }

    protected void startDriver() {
        Log.debug("Start WebDriver");
        driver = new BrowserFactory().getWebDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    protected void closeDriver() {
        Log.debug("Close WebDriver");
        driver.quit();
    }

    public InboxPage gmailLogin() {
        driver.get("https://mail.google.com");
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        return loginPage.login(TestProperties.getEmail(), TestProperties.getPassword());
    }
}
