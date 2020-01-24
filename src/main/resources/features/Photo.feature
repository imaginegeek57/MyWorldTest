Feature: Add post to photo

    # Выполняем авторизацию
  Background: Authorization
    Given I do authorization to email

  @PostPhoto
  Scenario: Add post to photo positive test

    Given I open a photo window
    Given I click upload photo from internet
    Given I add photo from internet by link
    Then I write describe to photo: "Мой кот"


