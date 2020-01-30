Feature: Add post to music

      # Выполняем авторизацию
  Background: Authorization
    Given I do authorization to email

  @PostMusic
  Scenario: Add post to music positive test

    Given I open a music window
    Given I search music from internet by name: "50 cent"
    Given I write text for new publish: "#50forever!"
    And I click button 'publish'
    Then I compare text into my publish: "#50forever!"
    And I compare time into my publish: "Только что"
    And I remove a publication
