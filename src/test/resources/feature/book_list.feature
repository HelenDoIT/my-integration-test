Feature: Input Validation - BookController

  - Endpoints that accept user input in some form should response as expected

  Scenario Outline: When getting a book info by get request, valid input should be responded to as expected

    Given api get list
    When a request is made to endpoint
    Then the response should have status code 200
    Examples:
      | username | apiName |
      | user | list |