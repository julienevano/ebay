package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import commonUtils.ConfigReader;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseDriver {

    public WebDriver driver;
    ConfigReader configReader = new ConfigReader();

    public WebDriver chooseDriver(String browser) {
        if (browser.contains("chrome")) {
          driver = initializeChromeDriver();
        } else if (browser.contains("Firefox")) {
          driver = initializeFirefoxDriver();

        } else {
            System.out.println("Not Configured yet");
        }
return driver;
    }

    public WebDriver initializeChromeDriver() {
        String chromeDriver = configReader.getPropertyValue("webdriver.chrome.driver");
        System.setProperty("webdriver.chrome.driver", chromeDriver);
        driver = new ChromeDriver();
        return driver;
    }

    public WebDriver initializeFirefoxDriver() {
        String geckoDriver = configReader.getPropertyValue("webdriver.gecko.driver");
        System.setProperty("webdriver.gecko.driver",geckoDriver);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
        return driver;
    }
}
