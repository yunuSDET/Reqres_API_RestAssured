Feature: List User Functionality

  Background: Used path
    Given I use this path "api/users"


  Scenario: List all users from first/second page
    Given I use this query "page" "1"
    When I use get method
    Then status code should be 200
    And print the user list


  Scenario: Verify that content type is "application/json; charset=utf-8" for first or second page
    Given I use this query "page" "2"
    When I use get method
    Then status code should be 200
    And response headers "Content-Type" should have this value "application/json; charset=utf-8"


  Scenario: Verify that host is "reqres.in" for first or second page
    Then request headers "Host" should have this value "reqres.in"


  Scenario: Verify that connection is "keep-alive" for first or second page
    Given I use this query "page" "1"
    When I use get method
    Then status code should be 200
    And response headers "Connection" should have this value "keep-alive"


  Scenario: Check if the response time is less then 1000 ms for first or second page
    Given I use this query "page" "2"
    When I use get method
    Then status code should be 200
    And check response time less than 1000 ms


  Scenario Outline: Verify page, per_page, total, total_pages for first or second page
    Given I use this query "page" "2"
    When I use get method
    Then status code should be 200
    And verify the value of "<key>" element from response is <value>


    Examples:
      | key         | value |
      | page        | 2     |
      | per_page    | 6     |
      | total       | 12    |
      | total_pages | 2     |


  Scenario Outline: List all users
    Given I use this query "page" "<pageNumber>"
    When I use get method
    Then status code should be 200
    And print each element of "data" array from response

    Examples:
      | pageNumber |
      | 1          |
      | 2          |


  Scenario: Check if support url is working for first or second page
    Given I use this query "page" "1"
    When I use get method
    Then status code should be 200
    And "support.url" url should be working


  Scenario: List all user first names from first/second page
    Given I use this query "page" "1"
    When I use get method
    Then status code should be 200
    And print "data.first_name" from response

  Scenario Outline: List all user names whose ids are odd
    Given I use this query "page" "<pageNumber>"
    When I use get method
    Then status code should be 200
    And list each element of "data" array from response whose "id" is odd
    And print each "data.id" which has this condition "%==1"
    Examples:
      | pageNumber |
      | 1          |
      | 2          |


  Scenario Outline:Check if each email address contains first name
    Given I use this query "page" "<pageNumber>"
    When I use get method
    Then status code should be 200
    And check each "email" contains user's name "first_name" under "data" from response


    Examples:
      | pageNumber |
      | 1          |
      | 2          |


  Scenario Outline:Verify that if given ids and first_names match
    Given I use this query "page" "<pageNumber>"
    When I use get method
    Then status code should be 200
    And check "id" equals to "<id>" and "first_name" equals to "<firstName>" inside "data"

    Examples:
      | pageNumber | id | firstName |
      | 1          | 1  | George    |
      | 1          | 2  | Janet     |
      | 1          | 3  | Emma      |
      | 1          | 4  | Eve       |
      | 1          | 5  | Charles   |
      | 1          | 6  | Tracey    |
      | 2          | 7  | Michael   |
      | 2          | 8  | Lindsay   |
      | 2          | 9  | Tobias    |
      | 2          | 10 | Byron     |
      | 2          | 11 | George    |
      | 2          | 12 | Rachel    |
