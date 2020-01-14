Feature: Email Authorization

# Выполняем авторизацию
  Background: Authorization
    Given I am authorizing by email

  Scenario: Login positive test

    Then I  check my Email