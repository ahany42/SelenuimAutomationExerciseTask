package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    protected static AppiumDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        if (driver == null) {
            System.out.println("Initializing Appium Driver...");

            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "emulator-5554");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
            capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
            capabilities.setCapability("noReset", true);
            capabilities.setCapability("fullReset", false);

            URL appiumServerUrl = new URL("http://localhost:4723/wd/hub");

            driver = new AndroidDriver (appiumServerUrl, capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            System.out.println("Appium Driver Initialized.");
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("Appium Driver Quit.");
        }
    }
}
