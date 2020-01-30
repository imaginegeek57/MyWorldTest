package ru.pflb.at.steps;

import io.cucumber.java8.En;
import ru.pflb.at.page.LoginHomePage;
import ru.pflb.at.page.MainPage;
import ru.pflb.at.techno.SWDriver;
import ru.pflb.at.techno.UserProperties;
import ru.pflb.at.techno.webConfig.WebConfig;

public class PhotoStep implements En {

    public WebConfig webConfig;
    public UserProperties userProperties;
    public SWDriver swDriver;
    public LoginHomePage loginHomePage;
    public MainPage mainPage;

    public PhotoStep() {
        webConfig = new WebConfig();
        userProperties = new UserProperties();
        swDriver = SWDriver.getInstance();
        loginHomePage = new LoginHomePage(swDriver);
        mainPage = new MainPage(swDriver);


        Given("I open a photo window", () -> {
            mainPage.getNewEventForm()
                    .clickNewEvent()
                    .clickPhoto();
        });

        Given("I choose to upload a photo from the Internet", () -> {
            mainPage.getPhotoWindow()
                    .addPhotoByLink();
        });

        Given("I add a photo from internet by link", () -> {
            mainPage.getPhotoWindow()
                    .writeUrl(webConfig.getImageUrl())
                    .clickUploadPhoto();
        });

        Given("I write a description for the photo: {string}", (String link) -> {
            mainPage.getPhotoWindow()
                    .writeDescribePhoto(link)
                    .clickSavePhoto();
        });

    }
}
