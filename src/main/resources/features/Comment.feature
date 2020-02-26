Feature: Filter for events

      # Выполняем авторизацию
  Background: Authorization
    Given I do authorization to email

  @WriteComment
  Scenario: Check filter publications positive test

    Given I open a photo window
    And I choose to upload a photo from the Internet
    And I add a photo from internet by link
    And I write a description for the photo: "Мой кот"
    And I write text for new publish: "#Кот"
    And I publish a new event
    When I write new comment: "funny picture"
    And I put random smile
    And I click button sent
    Then Check that text of comment and smile equals my last comment: "funny picture"
