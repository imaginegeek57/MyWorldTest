package ru.pflb.at.techno;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.pflb.at.page.LoginHomePage;
import ru.pflb.at.page.MailPage;
import ru.pflb.at.page.elements.AddMusic;
import ru.pflb.at.page.elements.AddPhoto;


public abstract class BaseTest {

    public UserProperties userProperties;
    public SWDriver swDriver;
    public LoginHomePage loginHomePage;
    public MailPage mailPage;
    public AddPhoto photoPage;
    public AddMusic musicPage;

    @BeforeEach
    public void baseSetUp() {
        userProperties = new UserProperties();
        swDriver = SWDriver.getInstance();
        loginHomePage = new LoginHomePage(swDriver);
        mailPage = new MailPage(swDriver);
        photoPage = new AddPhoto(swDriver);
        musicPage = new AddMusic(swDriver);
    }

    @AfterEach
    public void baseTearDown() {
        swDriver.close();
    }
}
