package ru.pflb.at.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.pflb.at.page.MainPage;
import ru.pflb.at.techno.BaseTest;
import ru.pflb.at.techno.SWDriver;

public class AppTest extends BaseTest {


    @BeforeEach
    public void setUp() {
        loginHomePage.login(jacksonParser, userProperties);
        loginHomePage.closeAdvert();
    }


//    @Test
//    public void test_photo() {
//        MainPage mainPage = new MainPage(SWDriver.getInstance());
//        mainPage.getNewEventForm()
//                .pressNewEvent()
//                .pressPhoto();
//        mainPage.getPhotoWindow()
//                .addPhotoByLink()
//                .writeUrl(jacksonParser.get_Image_url())
//                .uploadPhoto()
//                .describePhoto("Мой кот")
//                .savePhoto();
//        mainPage.getNewEventForm()
//                .enterPublishName("#Кот")
//                .pressPublish();
//    }

    @Test
    public void test_test() {
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



