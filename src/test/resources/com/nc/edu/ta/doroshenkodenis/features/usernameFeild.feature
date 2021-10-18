Feature: Username Field Checking

  @UsernameFieldTest
  Scenario Outline: : New user registration without "<symbol>" for the "Username" textbox
    Given user goes to registration page by opening Chrome
    When user fills Username without "<symbol>"
    Then user should see error "<notification>" from the "Username" field
    Examples:
      | symbol | notification |
      | digit | Login must contain at least 1 digit  |
      | letter | Login must contain at least 1 latin letter |


