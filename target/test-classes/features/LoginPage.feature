Feature: Login Page UI Tests

  Scenario: Test Login Page UI
    Given user is on login page
    Then website logo and login button is displayed  and check the heading text ,username and password

  Scenario: submission Empty Inputs
    Given user is on login page
    When I click on login button then an error message will be shown


  Scenario: login With Empty Username
    Given user is on login page
    And enter the password only then an error message will be shown


  Scenario: login With Empty Password
    Given user is on login page
    And enter the username only then an error message will be shown


  Scenario: login With invalid credentials
    Given user is on login page
    And enter the wrong username and password then an error message will be shown


  Scenario: login With Valid credentials
    Given user is on login page
    Then I enter the correct username and password and I will navigate to the home page