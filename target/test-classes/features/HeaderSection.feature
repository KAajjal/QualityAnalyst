Feature: Header Section Tests

  Scenario: Test Header Logo
    Given user is on any page with header section
    Then header logo is displayed

  Scenario: Test Navigation to Popular Page
    Given user is on any page with header section
    Then Popular link is displayed and check Popular Functionality

  Scenario: Test Navigation to Search Page
    Given user is on any page with header section
    Then Search link is displayed and check Search Functionality


  Scenario: Test Navigation to Account Page
    Given user is on any page with header section
    Then Account link is displayed and check Account Functionality

  Scenario: Test Navigation to Home Page
    Given user is on any page with header section
    Then home link is displayed and check Home Functionality


