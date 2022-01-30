Feature: Google translate
  @flakyTest
  Scenario Outline: Translate from English to arabic
    Given I go to "https://vidscola.com/"
    When I select auto detect language
    And choose to translate into Arabic
    And Type "<text>"
    Then Should translate into "<arabicText>"


    Examples:
      | text              | arabicText   |
      | software Engineer | مهندس برمجيات|
      | automated testing | الاختبار الآلي |