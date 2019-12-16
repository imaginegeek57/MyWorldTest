package ru.pflb.at.test;

import org.junit.jupiter.api.Test;
import ru.pflb.at.techno.BaseTest;

public class LoginMailTest extends BaseTest {

    @Test
    public void login_positive_test() {
        loginHomePage
                .open()
                .checkLogin(userProperties.getLogin())
                .checkPassword(userProperties.getPassword())
                .enter();
    }

    @Test
    public void login_wrong_password_test() {
        loginHomePage
                .open()
                .checkLogin(userProperties.getLogin())
                .checkPassword("1234")
                .enter();

        assert "Неправильное имя пользователя или пароль".equals(loginHomePage.getErrorMessage());
    }

}
