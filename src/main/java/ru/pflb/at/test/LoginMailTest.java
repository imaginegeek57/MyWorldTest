package ru.pflb.at.test;

import org.junit.jupiter.api.Test;
import ru.pflb.at.techno.BaseTest;

import static org.hamcrest.Matchers.equalTo;

public class LoginMailTest extends BaseTest {

    @Test
    public void login_positive_test() {
        loginHomePage
                .open()
                .checkLogin(userProperties.getLogin())
                .checkPassword(userProperties.getPassword())
                .enter()
                .assertThatCurrentUserMail(equalTo(userProperties.getMail()));
    }

    @Test
    public void login_wrong_password_test() {
        loginHomePage
                .open()
                .checkLogin(userProperties.getLogin())
                .checkPassword("1234")
                .enter()
                .assertThatErrorMessage(equalTo("Неправильное имя пользователя или пароль"));
    }
}
