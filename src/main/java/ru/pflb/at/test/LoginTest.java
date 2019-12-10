package ru.pflb.at.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.pflb.at.config.SWDriver;
import ru.pflb.at.page.LoginHomePage;

import static ru.pflb.at.config.Article.LOGIN;
import static ru.pflb.at.config.Article.PASSWORD;

public class LoginTest {

    public SWDriver swDriver;
    public LoginHomePage loginHomePage;

    @BeforeEach
    public void setUp() {
        swDriver = SWDriver.getInstance();
        loginHomePage = new LoginHomePage(swDriver);
    }

    @Test
    public void login_positive_test() {
        loginHomePage
                .open()
                .checkLogin(LOGIN)
                .checkPassword(PASSWORD)
                .enter()
                .screenshot();
    }

    @AfterEach
    public void tearDown() {
        loginHomePage.close();
    }

}
