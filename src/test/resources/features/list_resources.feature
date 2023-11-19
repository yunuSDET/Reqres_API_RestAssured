@wip
Feature: List Sources Functionality

  Background: Used path
    Given I use this path "api/unknown"


  Scenario: Verify page, per_page, total, total_pages
    When I use get method
    Then status code should be 200
    And verify the value of "page" element from response is 1
    And verify the value of "per_page" element from response is 6
    And verify the value of "total" element from response is 12
    And verify the value of "total_pages" element from response is 2


  Scenario Outline: List all data with 2000 and 2001 years
    Given I use this query "page" "<pageNumber>"
    Then status code should be 200
    And print each element of "data" array from response with this condition "id" "=" "2000"

    Examples:
      | pageNumber |
      | 1          |
      | 2          |


