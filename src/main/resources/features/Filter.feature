Feature: Filter for events

      # Выполняем авторизацию
  Background: Authorization
    Given I do authorization to email

  @FilterEvents
  Scenario: Check filter publications positive test

    Given I open a photo window
    And I choose to upload a photo from the Internet
    And I add a photo from internet by link
    And I write a description for the photo: "Мой кот"
    And I write text for new publish: "#Кот"
    And I publish a new event
    Given I open a music window
    And I search music from internet by name: "50 cent"
    And I write text for new publish: "#50forever!"
    And I publish a new event
    When I switch to publications for filter by photo
    Then Page has only events with photos
    When I switch to publications for filter by records
    Then Page has only events with records