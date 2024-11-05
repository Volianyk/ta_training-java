Feature: Login functionality tests on Saucedemo

  Scenario Outline: Login with empty username and password
    Given  the user is on the login page "https://www.saucedemo.com/"
    When the user enters a username and password
    And clears both the username and password fields, then clicks login
    Then the error message should be "Username is required"

    Examples:
      | username | password | expectedMessage      |
      |          |          | Username is required |
