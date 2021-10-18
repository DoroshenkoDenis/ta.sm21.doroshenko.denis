Feature: Check hints

  @HintsTest
  Scenario Outline: : Check hints on Registration page
    Given user navigates to registration page by Chrome
    Then the user points the mouse on the hint in the "<Current>" field AND see the "<Text>"

    Examples:
      | Current         | Text                                                                                                                                                              |
      | Username        | Login must contain only alphanumeric characters and contain at least 6 characters                                                                                 |
      | Password        | The Password must have at least 8 characters, at least 1 digit, at least 1 lower case letter, at least 1 upper case letter, at least 1 non-alphanumeric character |
      | Repeat Password | The Repeat password must be the same as the Password                                                                                                              |
      | Email           | Enter here valid e-mail address                                                                                                                                   |
      | Role:           | Pick corresponding role                                                                                                                                           |
