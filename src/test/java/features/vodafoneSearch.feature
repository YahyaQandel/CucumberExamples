#Feature: vodafone.com.eg search
#  Scenario Outline: validate if vodafone.com.eg required search results appears in first row based on search keywords
#    Given I go to vodafone website
#    When I click on the search icon
#    And I type in search field "<search_text>"
#    Then I Should find "<search_result>" as the first result
#
#    Examples:
#      | search_text       | search_result       |
#      | internet          | Machine To Machine |
#      | account           | Manage Your Account |