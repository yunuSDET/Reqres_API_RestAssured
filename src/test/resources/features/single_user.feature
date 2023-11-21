Feature: Single User Functionality

  Background: Used path
    Given I use this path "api/users"


  Scenario: Verify id, email, first_name,last_name for first/second page
    Given I use this path "4"
    When I use get method
    Then status code should be 200
    And verify the value of "data.id" element from response is 4
    And verify the value of "data.email" element from response is "eve.holt@reqres.in"
    And verify the value of "data.first_name" element from response is "Eve"
    And verify the value of "data.last_name" element from response is "Holt"


  Scenario Outline: Check user list includes  specific users with below ids
    Given I use this query "page" "<pageNumber>"
    When I use get method
    Then status code should be 200
    And verify that following list "data.id" include this element "<id>"

    Examples:
      | pageNumber | id |
      | 1          | 3  |
      | 1          | 4  |
      | 1          | 2  |
      | 2          | 9  |
      | 2          | 8  |
      | 2          | 10 |


  Scenario Outline: Check if the avatars is accessible for each user
    Given I use this query "page" "<pageNumber>"
    When I use get method
    Then status code should be 200
    And verify that listed links "data.avatar" is working
    Examples:
      | pageNumber |
      | 1          |
      | 2          |


  Scenario Outline: Access the single user page with invalid ids and verify that status code 404
    Given I use this path "<id>"
    When I use get method
    Then status code should be 404

    Examples:
      | id  |
      | 654 |
      | 758 |
      | 284 |
      | 105 |
      | 159 |
      | 743 |
      | 119 |
      | 905 |



