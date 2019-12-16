package ru.pflb.at.techno;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.pflb.at.page.LoginHomePage;
import ru.pflb.at.page.MailPage;
import ru.pflb.at.page.MusicPage;
import ru.pflb.at.page.PhotoPage;


public abstract class BaseTest {

    public UserProperties userProperties;
    public SWDriver swDriver;

    public LoginHomePage loginHomePage;
    public MailPage mailPage;
    public PhotoPage photoPage;
    public MusicPage musicPage;

    @BeforeEach
    public void baseSetUp() {
        userProperties = new UserProperties();
        swDriver = SWDriver.getInstance();
        loginHomePage = new LoginHomePage(swDriver);
        mailPage = new MailPage(swDriver);
        photoPage = new PhotoPage(swDriver);
        musicPage = new MusicPage(swDriver);
    }

    @AfterEach
    public void baseTearDown() {
        swDriver.close();
    }
}
