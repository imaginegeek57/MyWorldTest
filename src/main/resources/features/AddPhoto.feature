Feature: Add post to photo

    # Выполняем авторизацию
  Background: Authorization
    Given I am authorizing by email

  @Current
  Scenario: Add post to photo positive test

    Given I open a pho
    When I add a photo from internet by link: "https://avatars.mds.yandex.net/get-pdb/1976538/7ea9875b-c3cb-49ff-9ab3-9dc436be6ab4/s1200"

