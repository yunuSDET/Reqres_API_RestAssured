Feature: List User Functionality

  Scenario: List all users from first/second page
    Given I use this path "api/users"
    And I use this query "page" "1"
    When I use get method
    Then status code should be 200


  Scenario: Verify that content type is "application/json; charset=utf-8" for first/second page
    Given I use this path "api/users"
    And I use this query "page" "2"
    When I use get method
    Then status code should be 200
    And headers "Content-Type" should have this value "application/json; charset=utf-8"


  Scenario: Verify that host is "reqres.in" for first/second page
    Given I use this path "api/users"
    And I use this query "page" "1"
    Then host should be "reqres.in"



  Scenario: Verify that connection is "keep-alive" for first/second page
    Given I use this path "api/users"
    And I use this query "page" "1"
    When I use get method
    Then status code should be 200
    And headers "Connection" should have this value "keep-alive"




  Scenario: Check if the response time is less then 250 for first/second page
    Given I use this path "api/users"
    And I use this query "page" "1"
    When I use get method
    Then status code should be 200
    And check response time less than 250 ms





