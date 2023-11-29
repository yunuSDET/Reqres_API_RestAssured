
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


  Scenario Outline: Check if the id from response matches with given id
    Given I use this path "<id>"
    When I use get method
    Then status code should be 200
    And verify the value of "data.id" element from response is <id>

    Examples:
      | id |
      | 3  |
      | 4  |
      | 2  |
      | 9  |
      | 8  |
      | 10 |


  Scenario: Check if the avatars of given id is accessible
    Given I use this path "5"
    When I use get method
    Then status code should be 200
    And "data.avatar" url should be working



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



