package ru.pflb.at.steps;

import io.cucumber.java8.En;
import ru.pflb.at.page.LoginHomePage;
import ru.pflb.at.page.elements.MusicWindow;
import ru.pflb.at.techno.SWDriver;
import ru.pflb.at.techno.UserProperties;

public class AddMusicSteps implements En {

    public UserProperties userProperties;
    public SWDriver swDriver;
    public LoginHomePage loginHomePage;
    public MusicWindow musicPage;

    public AddMusicSteps() {
        userProperties = new UserProperties();
        swDriver = SWDriver.getInstance();
        loginHomePage = new LoginHomePage(swDriver);
//        musicPage = new MusicWindow(swDriver);

        Given("I openPage a page and search music: {string}", (String text) -> {
//            musicPage
//                    .pressNewEvent()
//                    .pressMusic()
//                    .addMusicFrom()
//                    .enterMusicName(text);
        });

        Then("I add a music track with # to my enterPublishName: {string}", (String text) -> {
//            musicPage
//                    .markTrack()
//                    .pressAddTracks()
//                    .pressNewEvent()
//                    .enterPublishName(text)
//                    .pressPublish();
        });

    }
}
