Feature: Product Count Verification

  Scenario: Verify number of Add to Cart buttons
    Given I am on the product page logged in as "standard_user" with "secret_sauce"
    Then I should see 6 Add to Cart buttons

  Scenario: Verify number of product prices
    Given I am on the product page logged in as "standard_user" with "secret_sauce"
    Then I should see 6 price labels
