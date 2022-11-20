package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class WebDriverInstance {
    public static RemoteWebDriver initialize(Boolean isRunningOnHub) {
        RemoteWebDriver webDriver = null;
        URL URL_ADDRESS;

        //Set caps for general
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, Browser.CHROME);

        //Browser caps
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--incognito", "--start-maximized", "window-size=1920,1080");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        //options.setHeadless(true);

        //Merge general caps and browser caps
        options = options.merge(capabilities);

        WebDriverManager.chromedriver().setup();

        if (isRunningOnHub) {
            try {
                URL_ADDRESS = new URL(System.getProperty("urlHub", "http://172.20.0.2:4444/wd/hub"));
                webDriver = new RemoteWebDriver(URL_ADDRESS, options);
            } catch (Exception e) {
                System.out.println("Error : " + e);
            }
        } else {
            webDriver = new ChromeDriver(options);
        }
        assert webDriver != null;
        webDriver.get("https://magento.softwaretestingboard.com");
        return webDriver;
    }
}