package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {

    private AppiumDriver driver;  // or AppiumDriver<WebElement>
    private String userName;
    private String password;

    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    public LoginPage(AppiumDriver driver, String userName, String password) {
        this.driver = driver;
        this.userName = userName;
        this.password = password;
    }

    public void LoginToTheSystem(boolean isAuthenticated) {
        logger.info("Logging in with username: {}", userName);
        SoftAssert softAssert = new SoftAssert();

        try {
            driver.findElement(By.id("test-Username")).sendKeys(userName);
            driver.findElement(By.id("test-Password")).sendKeys(password);
            driver.findElement(By.id("test-LOGIN")).click();

            WebElement successIndicator = driver.findElement(By.xpath("//*[@text='PRODUCTS']"));
            boolean isDisplayed = successIndicator.isDisplayed();

            if (isAuthenticated) {
                softAssert.assertTrue(isDisplayed, "Expected login success, but element not displayed.");
            } else {
                softAssert.assertFalse(isDisplayed, "Expected login failure, but element displayed.");
            }
        } catch (Exception e) {
            if (isAuthenticated) {
                softAssert.fail("Expected login to succeed, but failed: " + e.getMessage());
            } else {
                logger.info("Login failed as expected.");
            }
        }

        softAssert.assertAll();
    }
}
