package ru.pflb.at.steps;

import io.cucumber.java8.En;
import ru.pflb.at.page.LoginHomePage;
import ru.pflb.at.page.elements.PhotoWindow;
import ru.pflb.at.techno.SWDriver;
import ru.pflb.at.techno.UserProperties;

public class AddPhotoSteps implements En {

    public UserProperties userProperties;
    public SWDriver swDriver;
    public LoginHomePage loginHomePage;
    public PhotoWindow photoPage;

    public AddPhotoSteps() {
        userProperties = new UserProperties();
        swDriver = SWDriver.getInstance();
        loginHomePage = new LoginHomePage(swDriver);
        photoPage = new PhotoWindow(swDriver);


        Given("I upload a photo from internet by link: {string}", (String url) -> {
//            photoPage
//                    .pressSearch()
//                    .enterPhoto()
//                    .addByLink()
//                    .writeUrl(url)
//                    .uploadPhoto();
        });

        Then("I write describe to photo: {string} and make new publish: {string}", (String describe, String publish) -> {
//            photoPage
//                    .describePhoto(describe)
//                    .savePhoto()
//                    .publish(publish)
//                    .addPublish();

        });
    }
}
