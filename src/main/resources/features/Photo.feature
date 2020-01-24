Feature: Add post to photo

    # Выполняем авторизацию
  Background: Authorization

  @PostPhoto
  Scenario: Add post to photo positive test

    Given I do authorization to email
    Given I open a photo window
    Given I click upload photo from internet
    Given I add photo from internet by link
    Then I write describe to photo: "Мой кот"
    Then I add new publish: "#50forever!"


