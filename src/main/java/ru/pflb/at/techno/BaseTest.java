package ru.pflb.at.techno;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.pflb.at.page.LoginHomePage;
import ru.pflb.at.page.MailPage;
import ru.pflb.at.page.MainPage;
import ru.pflb.at.page.elements.MusicWindow;
import ru.pflb.at.page.elements.PhotoWindow;


public abstract class BaseTest {

    public UserProperties userProperties;
    public SWDriver swDriver;
    public LoginHomePage loginHomePage;
    public MailPage mailPage;
    public PhotoWindow photoPage;
    public MusicWindow musicPage;
    public MainPage mainPage;

    @BeforeEach
    public void baseSetUp() {
        userProperties = new UserProperties();
        swDriver = SWDriver.getInstance();
        loginHomePage = new LoginHomePage(swDriver);
        mailPage = new MailPage(swDriver);
        photoPage = new PhotoWindow(swDriver);
//        musicPage = new MusicWindow(swDriver);
        mainPage = new MainPage(swDriver);
    }

    @AfterEach
    public void baseTearDown() {
        swDriver.close();
    }
}
