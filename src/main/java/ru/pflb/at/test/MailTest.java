package ru.pflb.at.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.pflb.at.page.MailPage;
import ru.pflb.at.page.RegistrationPage;
import ru.pflb.at.techno.SWDriver;
import ru.pflb.at.techno.UserProperties;

public class MailTest {

    public UserProperties userProperties;
    public SWDriver swDriver;
    public RegistrationPage loginHomePage;
    public MailPage mailPage;

    @BeforeEach
    public void setUp() {
        userProperties = new UserProperties();
        swDriver = SWDriver.getInstance();
        loginHomePage = new RegistrationPage(swDriver);
        mailPage = new MailPage(swDriver);

        loginHomePage.login(userProperties);
    }

    @Test
    public void sent_mail_positive_test() {
        mailPage
                .enterMail();
        System.out.println();
    }


    @AfterEach
    public void tearDown() {
        swDriver.close();
    }
}
