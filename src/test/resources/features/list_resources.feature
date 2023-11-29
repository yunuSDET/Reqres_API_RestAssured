@wip
Feature: List Sources Functionality

  Background: Used path
    Given I use this path "api/unknown"


  Scenario Outline: Verify page, per_page, total, total_pages
    When I use get method
    Then status code should be 200
    And verify the value of "<element>" element from response is <value>

    Examples:
      | element     | value |
      | page        | 1     |
      | per_page    | 6     |
      | total       | 12    |
      | total_pages | 2     |


  Scenario Outline: List all data with 2000, 2004 and 2009 years
    Given I use this query "page" "<pageNumber>"
    When I use get method
    Then status code should be 200
    And print each element of "data" array from response with this condition "year" "=" <year>

    Examples:
      | pageNumber |year|
      | 1          |2000|
      | 2          |2000|
      | 1          |2004|
      | 2          |2004|
      | 1          |2009|
      | 2          |2009|
