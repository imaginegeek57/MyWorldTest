package ru.pflb.at.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.pflb.at.page.RegistrationPage;
import ru.pflb.at.techno.SWDriver;
import ru.pflb.at.techno.UserProperties;

public class LoginTest {

    public UserProperties userProperties;
    public SWDriver swDriver;
    public RegistrationPage loginHomePage;

    @BeforeEach
    public void setUp() {
        userProperties = new UserProperties();
        swDriver = SWDriver.getInstance();
        loginHomePage = new RegistrationPage(swDriver);
    }

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

    @AfterEach
    public void tearDown() {
        swDriver.close();
    }

}
