Feature: Input Validation - karate test
  Background:
    * def urlBase = 'http://localhost:8090/book/queryByName'

  Scenario: queryByName test
    Given url urlBase
    And request {name:'Clean Code'}
    When method POST
    Then status 200
    And match $..data.name contains 'Clean Code'