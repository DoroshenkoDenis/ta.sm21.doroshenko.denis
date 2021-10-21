Feature: Start page

  Background:
    Given the user goes to login page by opening Chrome
    And login with "Admin_Pro" and "Password1+"
    Then the user sees the Start page

  @NavigationListTest
  Scenario Outline: : Check the "<Link>"  in the Navigation List
    Given the user is logged in as "Admin_Pro"
    When the user points the mouse at Navigation and clicks the "<Link>"
    Then the user should see the current page "<Page>" and "<Page dispatcher>"

    Examples:
      | Link                  | Page                 | Page dispatcher               |
      | Inventory             | Inventory            | Top > Inventory >             |
      | Infrastructure Orders | Inventory Orders     | Top > Infrastructure Orders > |
      | Tools                 | Administrative tools | Top > Administrative tools >  |