Feature: Authorization to my world

  @PositiveTest
  @CorrectAuthorization
  Scenario: Login and logout
    Given I do authorization to email
    Then I check authorization my email
    When Click button 'ВЫХОД'
    Then Check correct exit from account

  @NegativeTest
  @LoginError
  Scenario: Login error, incorrect password
    Given Enter correct login to account
    Given Enter wrong password: "abc12345"
    When Click button 'ВОЙТИ'
    Then Page has string about error

