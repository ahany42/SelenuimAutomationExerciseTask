package steps;

import io.cucumber.java.en.*;
import base.BaseTest;
import pages.LoginPage;
import base.PropertiesUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class LoginSteps extends BaseTest {
    LoginPage loginPage;
    private static final Logger logger = LogManager.getLogger(LoginSteps.class);
    @Given("I am on the login page")
    public void i_am_on_login_page() {
        BaseTest.webDriver.get(PropertiesUtil.get("base.url"));
        String username = PropertiesUtil.get("username");
        String password = PropertiesUtil.get("password");
        loginPage = new LoginPage(BaseTest.webDriver, username, password);
        logger.info("LoginPage object created with default credentials");
    }

    @When("I login with username {string} and password {string}")
    public void login_with_credentials(String username, String password) {
        loginPage = new LoginPage(BaseTest.webDriver, username, password);
        logger.info("Attempting login with username: '{}' and password: '{}'", username, password);
    }

    @Then("login should be {string}")
    public void login_should_be(String result) {
        boolean expected = result.equals("success");
        loginPage.LoginToTheSystem(expected);
        logger.info("Login validation completed");
    }
}
