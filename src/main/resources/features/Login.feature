Feature: Email Authorization

# Выполняем авторизацию

  @Authorization
  Scenario: Login positive test
    Given I do authorization to email

    #название сценария и шага, ключевое слово
  @CheckAuthorization
  Scenario: Login positive test
    Then I check authorization my email