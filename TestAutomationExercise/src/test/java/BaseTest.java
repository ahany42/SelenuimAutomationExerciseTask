import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestNG;
import java.io.IOException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class BaseTest {
    public static WebDriver driver;
    public Logger logger = LogManager.getLogger(getClass());
    public WebDriver getDriver() {
        return driver;
    }
    @BeforeSuite
    public void setup() {
        logger.info("Setting Up Driver");
        driver = new ChromeDriver();
        driver.get("https://www.automationexercise.com/login");
        driver.manage().window().maximize();
        ConfigReader.loadProperties("src/test/resources/config.properties");

    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        logger.info("Tearing Down");
        if (driver != null) {
            driver.quit();
        }
    }
}