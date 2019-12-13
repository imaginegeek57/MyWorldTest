package ru.pflb.at.techno;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.pflb.at.page.MailPage;
import ru.pflb.at.page.RegistrationPage;


public abstract class BaseTest {

    public UserProperties userProperties;
    public SWDriver swDriver;

    public RegistrationPage registrationHomePage;
    public MailPage mailPage;

    @BeforeEach
    public void baseSetUp() {
        userProperties = new UserProperties();
        swDriver = SWDriver.getInstance();
        registrationHomePage = new RegistrationPage(swDriver);
        mailPage = new MailPage(swDriver);
    }

    @AfterEach
    public void baseTearDown() {
        swDriver.close();
    }
}
