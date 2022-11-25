Feature: Search in mystore website
  Scenario: validate search feature for sample product is working
    Given I visit mystore website
    When I type "jeans" in search field and press search icon
    Then I should find 3 items found
    And I should find "ATX Jeans" in results items
