Feature: Add post to music

      # Выполняем авторизацию
  Background: Authorization
    Given I do authorization to email

  @PostMusic
  Scenario: Add post to music positive test

    Given I open a music window
    And I search music from internet by name: "50 cent"
    And I write text for new publish: "#50forever!"
    When I publish a new event
    Then The last publish has text: "#50forever!"
    And The last publish has time: "только что"
    And I remove a publish
