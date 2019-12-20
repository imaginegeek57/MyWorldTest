Feature: Email Authorization


  Scenario: Login positive test
    Given I open the login page
    When I write login
    And I write password
    And I enter the site
    Then I check my Email