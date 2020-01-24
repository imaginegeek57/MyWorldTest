Feature: Add post to music

      # Выполняем авторизацию
  Background: Authorization
    Given I do authorization to email

  @PostMusic
  Scenario: Add post to music positive test

    Given I open a music window
    Given I search music from internet by name: "50 cent"
    Then I add new publish: "#50forever!"
