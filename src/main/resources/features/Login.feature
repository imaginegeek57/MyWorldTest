Feature: Authorization to my world

  @CorrectAuthorization
  Scenario: Login and logout positive test
    Given I do authorization to email
    Then I check authorization my email
    When Click button 'EXIT'
    Then Check correct exit from account

  @LoginError
  Scenario: Login negative test
    Given Write correct login to account
    And Write random characters to password: "abc12345"
    When Click button 'ENTER'
    Then Page has string about error

