Feature: vodafone website
  Scenario: check if vodafone.com.eg search has specific information
    Given I go to vodafone website
    When I click on the search icon
    And I type in search field "internet"
    Then I Should find "Machine To Machine" as the first result



#Feature: vodafone website
#  Scenario Outline: check if vodafone.com.eg search has specific information
#    Given I go to vodafone website
#    When I click on the search icon
#    And I type in search field "<search_text>"
#    Then I Should find "<search_result>" as the first result
#
#    Examples:
#      | search_text       | search_result       |
#      | internet          | Machine To Machine |
#      | account           | Manage Your Account |