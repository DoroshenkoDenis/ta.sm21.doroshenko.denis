Feature: Registration page

  @RegAndLoginTest
  Scenario Outline: : New user registration with "<Role>" Role
    Given user goes to registration page by opening Chrome
    When user enter "<Username>" in the Username field
    And user enter "<Password>" in the Password field
    And user enter "<Confirm password>" in the Repeat Password field
    And user enter "<Email>" in the Email field
    And user select "<Role>" from Role dropdown
    And user press the Registration button
    Then user with "<Role>" should see successful notification on the Login page
    When user enter Username in the Username field on the Login page
    And user enter "<Password>" in the Password field on the Login page
    And user with "<Role>" press the Login button
    Then user should see the current Username on the Start page

    Examples:
      | Username | Password   | Confirm password | Email          | Role         |
      | Admin_    | Password1+ | Password1+       | -@testmail.com | Admin        |
      | ReadWrite_    | Password1+ | Password1+       | _@testmail.com | Read / Write |
      | ReadOnly_   | Password1+ | Password1+       | .@testmail.com | Read Only    |

#  не могу добиться визуализации подсказок во время теста для получения скриншота
  @HintsTest
  Scenario Outline: : Check "<Current>" hints on Registration page
    Given user goes to registration page by opening Chrome
    Then the user points the mouse on the hint in the "<Current>" field and see the "<Text>"

    Examples:
      | Current         | Text                                                                                                                                                              |
      | Username        | Login must contain only alphanumeric characters and contain at least 6 characters                                                                                 |
      | Password        | The Password must have at least 8 characters, at least 1 digit, at least 1 lower case letter, at least 1 upper case letter, at least 1 non-alphanumeric character |
      | Repeat Password | The Repeat password must be the same as the Password                                                                                                              |
      | Email           | Enter here valid e-mail address                                                                                                                                   |
      | Role:           | Pick corresponding role                                                                                                                                           |

# Тесты должны упасть требования R1.4 не реализованы
  @UsernameFieldTest
  Scenario Outline: : New user registration without "<symbol>" for the "Username" textbox
    Given user goes to registration page by opening Chrome
    When user fills Username without "<symbol>"
    And user press the Registration button
    Then user should see error "<notification>" from the "Username" field
    Examples:
      | symbol | notification                               |
      | digit  | Login must contain at least 1 digit        |
      | letter | Login must contain at least 1 latin letter |


  @PasswordFieldTest
  Scenario Outline: : New user registration with "<password>" for the "Password" textbox
    Given user goes to registration page by opening Chrome
    When user fills Password with "<password>"
    And user press the Registration button
    Then user should see error "<notification>" from the "Password" field
    Examples:
      | password   | notification                                              |
      | Password++ | At least one digit must be in password                    |
      | password1= | At least one upper letter must be in password             |
      | PASSWORD1+ | At least one lower letter must be in password             |
      | Password12 | At least one non alpha numeric symbol must be in password |


