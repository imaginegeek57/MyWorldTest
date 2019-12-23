package ru.pflb.at.steps;

import io.cucumber.java8.En;
import ru.pflb.at.page.LoginHomePage;
import ru.pflb.at.page.PhotoPage;
import ru.pflb.at.techno.SWDriver;
import ru.pflb.at.techno.UserProperties;

public class AddPhotoSteps implements En {

    public UserProperties userProperties;
    public SWDriver swDriver;
    public LoginHomePage loginHomePage;
    public PhotoPage photoPage;

    public static final String PICTURE_URL = "https://avatars.mds.yandex.net/get-pdb/1976538/7ea9875b-c3cb-49ff-9ab3-9dc436be6ab4/s1200";


    public AddPhotoSteps() {
        userProperties = new UserProperties();
        swDriver = SWDriver.getInstance();
        loginHomePage = new LoginHomePage(swDriver);
        photoPage = new PhotoPage(swDriver);


        Given("I open a photo tab", () -> {
            photoPage.enterPhoto();
        });

        When("I add a photo from internet by this link: {url}", (String url) -> {
            photoPage
                    .addPhoto()
                    .addByLink()
                    .mailToUser(url)
                    .uploadPhoto()
                    .enterPhoto();
        });

    }
}
