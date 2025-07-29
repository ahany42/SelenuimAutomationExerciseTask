Feature: SwagLabs Purchase Flow

  Scenario: Add item to cart
    Given I am logged in as "standard_user" with "secret_sauce"
    When I add item "Sauce Labs Backpack" to the cart
    Then the cart should contain 1 item

  Scenario: Proceed to checkout and complete purchase
    Given I have items in the cart
    When I fill checkout form with "John", "Doe", "12345"
    And I finish the purchase
    Then the order should be completed successfully
