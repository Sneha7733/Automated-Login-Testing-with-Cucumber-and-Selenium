Feature: Login Functionality
  As a user
  I want to test login functionality
  So that I can verify valid and invalid scenarios

  Scenario: Valid Login
    Given the user navigates to the login page
    When the user enters username "tomsmith" and password "SuperSecretPassword!"
    Then the user should be redirected to the Secure Area page

  Scenario: Invalid Login
    Given the user navigates to the login page
    When the user enters username "wrongusername" and password "wrongpassword"
    Then an error message "Your username is invalid!" should be displayed

  Scenario: Empty Fields
    Given the user navigates to the login page
    When the user enters username "" and password ""
    Then an error message "Your username is invalid!" should be displayed for both fields


  @bonus
  Scenario Outline: Data-driven Login
    Given the user navigates to the login page
    When the user enters username "<username>" and password "<password>"
    Then the result should be "<message>"

    Examples:
      | username      | password              | message                         |
      | tomsmith      | SuperSecretPassword!  | Secure Area                     |
      | tomandcherry  | SuperSunSolar         | Your username is invalid!       |
      |               |                       | Your username is invalid!          |


