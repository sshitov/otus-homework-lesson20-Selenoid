package Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static final Logger logger = LogManager.getLogger(BaseTest.class.getName());

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void create() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("78.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        logger.debug("driver is created");
    }

    public void quit(){
        if (driver != null) {
            driver.quit();
        }
        logger.debug("driver is closed");
    }

    public String currentUrl(){
        return driver.getCurrentUrl();
    }

    public ArrayList<String> getBrowserTabs(){
        return new ArrayList<>(driver.getWindowHandles());
    }

    public void selectBrowserTab(int index){
        driver.switchTo().window(getBrowserTabs().get(index));
    }

}
