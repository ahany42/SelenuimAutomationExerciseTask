package tests;

import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    @BeforeMethod
    public void beforeTestMethod() {
        logger.info("App launched and ready for login.");
    }

    @AfterMethod
    public void afterTestMethod() {
        logger.info("After test cleanup not implemented (consider resetting app if needed).");
    }

    @Test(priority = 1)
    public void invalidUsernameLogin() {
        logger.info("Running test: invalid username");
        new LoginPage(driver, "WrongUserName", getPassword()).LoginToTheSystem(false);
    }

    @Test(priority = 2)
    public void emptyUsernameAndPassword() {
        logger.info("Running test: empty username and password");
        new LoginPage(driver, "", "").LoginToTheSystem(false);
    }

    @Test(priority = 3)
    public void invalidPasswordLogin() {
        logger.info("Running test: invalid password");
        new LoginPage(driver, getUsername(), "WrongPassword").LoginToTheSystem(false);
    }

    @Test(priority = 4)
    public void invalidUsernameAndPasswordLogin() {
        logger.info("Running test: invalid username and password");
        new LoginPage(driver, "WrongUserName", "WrongPassword").LoginToTheSystem(false);
    }

    @Test(priority = 5)
    public void lockedOutUserLogin() {
        logger.info("Running test: locked out user");
        new LoginPage(driver, getLockedUsername(), getPassword()).LoginToTheSystem(false);
    }

    @Test(priority = 6)
    public void validLogin() {
        logger.info("Running test: valid login");
        new LoginPage(driver, getUsername(), getPassword()).LoginToTheSystem(true);
    }

    // Utility getters (can be replaced with PropertiesUtil if available)
    private String getUsername() {
        return "standard_user"; // Replace with actual or loaded from properties
    }

    private String getPassword() {
        return "secret_sauce";
    }

    private String getLockedUsername() {
        return "locked_out_user";
    }
}
