package ru.pflb.at.steps;

import io.cucumber.java8.En;
import ru.pflb.at.page.LoginHomePage;
import ru.pflb.at.page.MainPage;
import ru.pflb.at.techno.SWDriver;
import ru.pflb.at.techno.UserProperties;
import ru.pflb.at.techno.webConfig.WebConfig;

public class MusicStep implements En {

    public WebConfig webConfig;
    public UserProperties userProperties;
    public SWDriver swDriver;
    public LoginHomePage loginHomePage;
    public MainPage mainPage;

    public MusicStep() {
        webConfig = new WebConfig();
        userProperties = new UserProperties();
        swDriver = SWDriver.getInstance();
        loginHomePage = new LoginHomePage(swDriver);
        mainPage = new MainPage(swDriver);

        Given("I open a music window", () -> {
            mainPage.getNewEventForm()
                    .clickNewEvent()
                    .clickMusic();
        });

        Given("I search music from internet by name: {string}", (String text) -> {
            mainPage.getMusicWindow()
                    .clickAddFromSearch()
                    .writeMusicName(text)
                    .markTrack()
                    .clickAddTrack();
        });

        Then("I add new publish: {string}", (String text) -> {
            mainPage.getNewEventForm()
                    .writePublishName(text)
                    .clickPublish();
        });
    }
}
