package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {
    public static WebDriver webDriver;

    public static void initDriver() {
        if (webDriver == null) {
            ChromeOptions options = new ChromeOptions();
            webDriver = new ChromeDriver(options);
            webDriver.manage().window().maximize();
//            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        }
    }

    public static void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
