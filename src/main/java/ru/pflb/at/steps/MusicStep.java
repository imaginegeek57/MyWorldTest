package ru.pflb.at.steps;

import io.cucumber.java8.En;
import ru.pflb.at.page.LoginHomePage;
import ru.pflb.at.page.MainPage;
import ru.pflb.at.techno.SWDriver;
import ru.pflb.at.techno.UserProperties;
import ru.pflb.at.techno.webConfig.WebConfig;

import static org.hamcrest.Matchers.equalTo;

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

        Given("I write text for new publish: {string}", (String text) -> {
            mainPage.getNewEventForm()
                    .writePublishName(text);
        });

        And("I click button 'publish'", () -> {
            mainPage.getNewEventForm()
                    .clickPublish();
        });

        Then("I compare text into my publish: {string}", (String text) -> {
            mainPage.getHistoryEvent()
                    .checkPublicationText(equalTo(text));
        });

        Then("I compare time into my publish: {string}", (String time) -> {
            mainPage.getHistoryEvent()
                    .checkPublicationTime(equalTo(time));
        });

        And("I remove a publication", () -> {
            mainPage.getHistoryEvents()
                    .clickRemove()
                    .clickYes();
        });
    }
}
