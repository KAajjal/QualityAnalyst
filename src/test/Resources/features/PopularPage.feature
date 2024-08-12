Feature: Popular Page Tests

  Scenario: Test Movies Display on Popular Page
    Given user is on popular page
    Then movies are displayed on popular page
    Then click on Spider man movie and redirect to the movie page

