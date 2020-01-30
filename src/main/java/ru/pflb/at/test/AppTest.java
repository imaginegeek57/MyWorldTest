package ru.pflb.at.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.pflb.at.page.MainPage;
import ru.pflb.at.techno.BaseTest;
import ru.pflb.at.techno.SWDriver;

import static org.hamcrest.Matchers.equalTo;

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
                .writeDescribePhoto("ere Мой кот")
                .clickSavePhoto();
        mainPage.getNewEventForm()
                .setCheckboxStatus(true)
                .writePublishName("wfwwd #Кот")
                .clickPublish();
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
        mainPage.getHistoryEvents();

    }

    @Test
    public void test_history() {
        MainPage mainPage = new MainPage(SWDriver.getInstance());
        mainPage.getHistoryEvents()
                .clickRemove()
                .clickYes();
    }

    @Test
    public void test_comment() {
        MainPage mainPage = new MainPage(SWDriver.getInstance());
        mainPage.getHistoryEvents()
                .clickComment()
                .writeComment("Hi")
                .clickSent();
    }

    @Test
    public void test_comment1() {
        MainPage mainPage = new MainPage(SWDriver.getInstance());
        mainPage.getHistoryEvent()
                .checkPublicationAuthor(equalTo("Вы"))
                .checkPublicationText(equalTo("wfwwd #Кот"));
        //        .checkPublicationTime(equalTo("1 час назад"));
    }
}



