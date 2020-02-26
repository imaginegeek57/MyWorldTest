Feature: Email Authorization

# Выполняем авторизацию

  @Authorization
  Scenario: Login positive test
    Given I do authorization to email

    #название сценария и шага, ключевое слово
  @CheckAuthorization
  Scenario: Login and escape positive test
    Given I do authorization to email
    Then I check authorization my email
    And Check correct exit from account

  @LoginError
  Scenario: Login negative test
    Given Check correct exit from account: "12345"

