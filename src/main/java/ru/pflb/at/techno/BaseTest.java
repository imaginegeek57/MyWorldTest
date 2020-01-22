package ru.pflb.at.techno;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.pflb.at.page.LoginHomePage;
import ru.pflb.at.page.MailPage;
import ru.pflb.at.page.MainPage;
import ru.pflb.at.techno.webConfig.WebConfig;


public abstract class BaseTest {

    public WebConfig webConfig;
    public UserProperties userProperties;
    public SWDriver swDriver;
    public LoginHomePage loginHomePage;
    public MailPage mailPage;
    public MainPage mainPage;

    @BeforeEach
    public void baseSetUp() {
        webConfig = new WebConfig();
        userProperties = new UserProperties();
        swDriver = SWDriver.getInstance();
        loginHomePage = new LoginHomePage(swDriver);
        mailPage = new MailPage(swDriver);
        mainPage = new MainPage(swDriver);
    }

    @AfterEach
    public void baseTearDown() {
        swDriver.close();
    }
}
