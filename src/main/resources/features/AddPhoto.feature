Feature: Add post to photo

  Scenario: Add post to photo positive test

    Given I open a photo tab
    When I add a photo link from internet
    Then I save my picture
