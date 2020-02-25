package ru.pflb.at.test;

import org.junit.jupiter.api.Test;
import ru.pflb.at.techno.BaseTest;

import static org.hamcrest.Matchers.equalTo;

public class LoginStepMailTest extends BaseTest {

    @Test
    public void login_positive_test() {
        loginHomePage
                .goToWebPage(webConfig.getUrl())
                .writeLogin(userProperties.getLogin())
                .writePassword(userProperties.getPassword())
                .clickEnter()
                .assertThatCurrentUserMail(equalTo(userProperties.getMail()));
    }

    @Test
    public void login_wrong_password_test() {
        loginHomePage
                .goToWebPage(webConfig.getUrl())
                .writeLogin(userProperties.getLogin())
                .writePassword("1234")
                .clickEnter()
                .assertThatErrorMessage(equalTo("Неправильное имя пользователя или пароль"));
    }

    @Test
    public void Exit_test() {
        loginHomePage
                .goToWebPage(webConfig.getUrl())
                .writeLogin(userProperties.getLogin())
                .writePassword(userProperties.getPassword())
                .clickEnter()
                .closeAdvert()
                .clickExit()
                .assertThatCurrentUrl();
    }


}
