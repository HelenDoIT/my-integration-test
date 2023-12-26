Feature: Using karate to test BookListController
  Background:
    * def urlBase = 'http://localhost:8090/book/listAll'
  Scenario: Return a list of users
    Given url urlBase
    When method GET
    Then status 200