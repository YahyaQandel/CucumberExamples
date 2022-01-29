Feature: Vidscola website
  Scenario: check if vidscola.com has this course
    Given I visit "https://vidscola.com/"
    When I select the search icon
    And I search for "testing automation"
    And I select AGILE TESTING AUTOMATION WORKSHOP course
    Then I should find "AGILE TESTING AUTOMATION WORKSHOP" as course title