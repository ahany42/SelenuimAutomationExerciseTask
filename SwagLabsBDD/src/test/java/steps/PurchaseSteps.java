package steps;

import io.cucumber.java.en.*;
import base.BaseTest;
import pages.LoginPage;
import pages.PurchasePage;
import base.PropertiesUtil;
public class PurchaseSteps extends BaseTest {
    PurchasePage purchasePage;

    @Given("I am logged in as {string} with {string}")
    public void i_am_logged_in(String username, String password) {
        BaseTest.webDriver.get(PropertiesUtil.get("base.url"));
        LoginPage loginPage = new LoginPage(BaseTest.webDriver, username, password);
        loginPage.LoginToTheSystem(true);
    }

    @When("I add item {string} to the cart")
    public void i_add_item_to_cart(String productName) {
        purchasePage = new PurchasePage(BaseTest.webDriver);
        purchasePage.AddToCart(productName);
    }

    @Then("the cart should contain {int} item")
    public void cart_should_contain_items(int expectedCount) {
        purchasePage.NumberOfItemsInCart();
    }

    @Given("I have items in the cart")
    public void i_have_items_in_cart() {
        purchasePage = new PurchasePage(BaseTest.webDriver);
        purchasePage.ClickOnCart();
    }

    @When("I fill checkout form with {string}, {string}, {string}")
    public void fill_checkout_form(String first, String last, String zip) {
        purchasePage.CheckOut();
        purchasePage.CheckOutForm(first, last, zip);
    }

    @And("I finish the purchase")
    public void i_finish_purchase() {
        purchasePage.FinishPurchase();
    }

    @Then("the order should be completed successfully")
    public void order_completed() {

    }
}
