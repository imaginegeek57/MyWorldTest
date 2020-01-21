package ru.pflb.at.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.pflb.at.page.MainPage;
import ru.pflb.at.techno.BaseTest;
import ru.pflb.at.techno.SWDriver;

public class AppTest extends BaseTest {

    /**
     * URL картинки
     */
    public static final String IMAGE_URL = "https://avatars.mds.yandex.net/get-pdb/1976538/7ea9875b-c3cb-49ff-9ab3-9dc436be6ab4/s1200";

    @BeforeEach
    public void setUp() {
        loginHomePage.login(userProperties);
        loginHomePage.closeAdvert();
    }

    @Test
    public void test_photo() throws InterruptedException {
        MainPage mainPage = new MainPage(SWDriver.getInstance());
        mainPage.getNewEventForm()
                .pressNewEvent()
                .pressPhoto();
        mainPage.getPhotoWindow()
                .addPhotoByLink()
                .writeUrl(IMAGE_URL)
                .uploadPhoto()
                .describePhoto("Мой кот")
                .savePhoto();
        mainPage.getNewEventForm()
                .enterPublishName("#Кот")
                .pressPublish();
    }

    @Test
    public void test_test() throws InterruptedException {
        MainPage mainPage = new MainPage(SWDriver.getInstance());
        mainPage.getNewEventForm()
                .pressNewEvent()
                .pressMusic();
        mainPage.getMusicWindow()
                .clickAddFromSearch()
                .enterMusicName("50 cent")
                .markTrack()
                .clickAddTrack();
        mainPage.getNewEventForm()
                .enterPublishName("#50forefer!")
                .pressPublish();
    }

}



