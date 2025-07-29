package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

import base.BaseTest;
import pages.LoginPage;
import pages.PurchasePage;
import base.PropertiesUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductSteps extends BaseTest {
    private static final Logger log = LogManager.getLogger(ProductSteps.class);

    SoftAssert softAssert = new SoftAssert();
    PurchasePage purchasePage;

    @Given("I am on the product page logged in as {string} with {string}")
    public void i_am_logged_in_on_product_page(String username, String password) {
        try {
            log.info("Navigating to base URL and logging in with username: {}", username);
            BaseTest.webDriver.get(PropertiesUtil.get("base.url"));

            LoginPage loginPage = new LoginPage(BaseTest.webDriver, username, password);
            loginPage.LoginToTheSystem(true);
            log.info("Login successful, initializing PurchasePage");
            purchasePage = new PurchasePage(BaseTest.webDriver);

        } catch (Exception e) {
            log.error("Error during login or navigating to product page", e);
            throw e;
        }
    }

    @Then("I should see {int} Add to Cart buttons")
    public void validate_cart_buttons(int expected) {
        try {
            log.info("Validating number of Add to Cart buttons, expecting {}", expected);
            List<WebElement> buttons = BaseTest.webDriver.findElements(By.className("btn_inventory"));
            int actual = buttons.size();
            log.info("Found {} Add to Cart buttons", actual);

            softAssert.assertEquals(actual, expected, "Mismatch in cart buttons");
            softAssert.assertAll();

        } catch (Exception e) {
            log.error("Error while validating Add to Cart buttons", e);
            throw e;
        }
    }

    @Then("I should see {int} price labels")
    public void validate_price_labels(int expected) {
        try {
            log.info("Validating number of price labels, expecting {}", expected);
            List<WebElement> prices = BaseTest.webDriver.findElements(By.className("inventory_item_price"));
            int actual = prices.size();
            log.info("Found {} price labels", actual);

            softAssert.assertEquals(actual, expected, "Mismatch in price labels");
            softAssert.assertAll();

        } catch (Exception e) {
            log.error("Error while validating price labels", e);
            throw e;
        }
    }
}
