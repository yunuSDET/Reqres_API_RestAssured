
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
      | pageNumber | year |
      | 1          | 2000 |
      | 2          | 2000 |
      | 1          | 2004 |
      | 2          | 2004 |
      | 1          | 2009 |
      | 2          | 2009 |



  Scenario Outline:Verify that all color codes starts with "#" and have 7 characters (including "#")
    Given I use this query "page" "<pageNumber>"
    When I use get method
    Then status code should be 200
    And verify that "data.color" list starts with "#" and have 7 characters


    Examples:
      | pageNumber |
      | 1          |
      | 2          |



  @wip
  Scenario Outline: Verify that all the value of pantone_values in following format "##-####"
    Given I use this query "page" "<pageNumber>"
    When I use get method
    Then status code should be 200
    And verify that each element of "data.pantone_value" is in the following format NN-NNNN

    Examples:
      | pageNumber |
      | 1          |
      | 2          |



  Scenario: Verify the year of second element of data in first page is 2001
    Given I use this query "page" "1"
    When I use get method
    Then status code should be 200
    And verify the value of "data.year" lists 2. element is 2001

