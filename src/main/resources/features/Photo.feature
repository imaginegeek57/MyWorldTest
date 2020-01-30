Feature: Add post to photo

    # Выполняем авторизацию
  Background: Authorization
    Given I do authorization to email

  @PostPhoto
  Scenario: Add post to photo positive test

    Given I open a photo window
    And I choose to upload a photo from the Internet
    And I add a photo from internet by link
    And I write a description for the photo: "Мой кот"
    And I write text for new publish: "#Кот"
    When I publish a new event
    Then The last publish has text: "#Кот"
    And The last publish has time: "только что"
    And I remove a publication