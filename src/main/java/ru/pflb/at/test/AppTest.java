package ru.pflb.at.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.pflb.at.page.MainPage;
import ru.pflb.at.techno.BaseTest;
import ru.pflb.at.techno.SWDriver;

public class AppTest extends BaseTest {

    @BeforeEach
    public void setUp() {
        loginHomePage.login(webConfig, userProperties);
        loginHomePage.closeAdvert();
    }

    @Test
    public void test_photo() {
        MainPage mainPage = new MainPage(SWDriver.getInstance());
        mainPage.getNewEventForm()
                .clickNewEvent()
                .clickPhoto();
        mainPage.getPhotoWindow()
                .addPhotoByLink()
                .writeUrl(webConfig.getImageUrl())
                .clickUploadPhoto()
                .writeDescribePhoto("Мой кот")
                .clickSavePhoto();
        mainPage.getNewEventForm()
                .setCheckboxStatus(true)
                .writePublishName("#Кот")
                .clickPublish();
        mainPage.getHistoryEvent()
                .clickRemove()
                .clickYes();
    }

    @Test
    public void test_music() {
        MainPage mainPage = new MainPage(SWDriver.getInstance());
        mainPage.getNewEventForm()
                .clickNewEvent()
                .clickMusic();
        mainPage.getMusicWindow()
                .clickAddFromSearch()
                .writeMusicName("50 cent")
                .markTrack()
                .clickAddTrack();
        mainPage.getNewEventForm()
                .writePublishName("#50forefer!")
                .clickPublish();
    }

    @Test
    public void test_history() {
        MainPage mainPage = new MainPage(SWDriver.getInstance());
        mainPage.getHistoryEvent()
                .clickRemove()
                .clickYes();
    }

    @Test
    public void test_comment() {
        MainPage mainPage = new MainPage(SWDriver.getInstance());
        mainPage.getHistoryEvent()
                .clickComment()
                .writeComment("Hi")
                .clickSent();
    }
}



