Feature: SwagLabs Login

  Scenario Outline: User attempts to login with different credentials
    Given I am on the login page
    When I login with username "<username>" and password "<password>"
    Then login should be "<result>"

    Examples:
      | username         | password       | result        |
      | WrongUserName    | secret_sauce   | failure       |
      | standard_user    | WrongPassword  | failure       |
      | WrongUserName    | WrongPassword  | failure       |
      | locked_out_user  | secret_sauce   | failure       |
      | standard_user    | secret_sauce   | success       |
      |                  |                | failure       |
