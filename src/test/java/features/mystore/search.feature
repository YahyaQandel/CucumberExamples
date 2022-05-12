Feature: Search in mystore website
  Scenario: search for already exists items in mystore
    Given I visit mystore website
    When I type "dress" in search field
    And I press search icon
    Then I should find 7 results found
    And I should find "\"DRESS\"" in page heading
