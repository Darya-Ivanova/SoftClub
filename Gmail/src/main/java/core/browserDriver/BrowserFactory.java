package core.browserDriver;

import core.utils.Log;
import core.utils.TestProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    private BrowserType browserType;
    private WebDriver webDriver;

    public BrowserFactory() {
        this.browserType = BrowserType.getBrowserType(TestProperties.getBrowserType());
        webDriver = getInstance();
    }

    private WebDriver getInstance() {
        Log.info("Getting " + browserType.name() + " browser");
        switch (browserType) {
            case FireFox:
                return getFireFox();
            case Chrome:
                return getChromeDriver();
            case Edge:
                return getEdgeDriver();
            default:
                throw new IllegalArgumentException("Invalid browserType specified");
        }
    }

    private FirefoxDriver getFireFox() {
        return new FirefoxDriver();
    }

    private ChromeDriver getChromeDriver() {
        return new ChromeDriver();
    }

    private EdgeDriver getEdgeDriver() {
        return new EdgeDriver();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
