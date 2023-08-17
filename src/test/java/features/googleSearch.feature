Feature: google search
  Scenario: validate that google text search redirects to a new search page
    Given user navigates to google.com search screen
    When user types 'Test example by selenium' in search text field
    And user clicks Google search or press enter
    Then user should be navigated to search page with title 'Test example by selenium - Google Search' and url contains 'https://www.google.com/search?,q=Test+example+by+selenium'
