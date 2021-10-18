Feature: Registration

  @RegTest
  Scenario Outline: : New user registration
    Given user navigates to registration page by opening Chrome
    When user enter "<Username>" in the Username field
    And user enter "<Password>" in the Password field
    And user enter "<Confirm password>" in the Repeat Password field
    And user enter "<Email>" in the Email field
    And user select "<Role>" from Role dropdown
    And user press the Registration button
    Then user should see successful notification on the Login page
    When user enter Username in the Username field on the Login page
    And user enter "<Password>" in the Password field on the Login page
    And user press the Login button
    Then user should see the current Username on the Start page

    Examples:
      | Username | Password   | Confirm password | Email          | Role         |
      | Admin    | Password1+ | Password1+       | -@testmail.com | Admin        |
      | RdWrt    | Password1+ | Password1+       | _@testmail.com | Read / Write |
      | RdOnly   | Password1+ | Password1+       | .@testmail.com | Read Only    |



