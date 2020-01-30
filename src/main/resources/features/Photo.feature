Feature: Add post to photo

    # Выполняем авторизацию
  Background: Authorization
    Given I do authorization to email

  @PostPhoto
  Scenario: Add post to photo positive test

    Given I open a photo window
    Given I choose to upload a photo from the Internet
    Given I add a photo from internet by link
    Given I write a description for the photo: "Мой кот"
    Given I write text for new publish: "#Кот"
    And I click button 'publish'
    Then I compare text into my publish: "#Кот"
    And I compare time into my publish: "только что"
    And I remove a publication

