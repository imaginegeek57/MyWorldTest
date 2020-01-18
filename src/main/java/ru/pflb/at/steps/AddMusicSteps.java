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
        musicPage = new MusicWindow(swDriver);

        Given("I open a page and search music: {string}", (String text) -> {
//            musicPage
//                    .pressSearch()
//                    .enterMusic()
//                    .addMusicFrom()
//                    .searchMusic(text);
        });

        Then("I add a music track with # to my publish: {string}", (String text) -> {
//            musicPage
//                    .enterSearch()
//                    .addTracks()
//                    .pressSearch()
//                    .publish(text)
//                    .addPublish();
        });

    }
}
