Feature: Add post to music

      # Выполняем авторизацию
  Background: Authorization
    Given I am authorizing by email

  @PostMusic
  Scenario: Add post to music positive test

    Given I open a page and search music: "50 cent"
    Then I add a music track with # to my publish: "#50forever"
