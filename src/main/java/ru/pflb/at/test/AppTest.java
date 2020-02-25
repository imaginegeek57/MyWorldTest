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
                .writeDescribePhoto("Мой кот")
                .clickSavePhoto();
        mainPage.getNewEventForm()
                .setCheckboxStatus(true)
                .writePublishName("Ура! #Кот")
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
        mainPage.getPhotoWindow()
                .checkDescriptionOfPhoto(equalTo("Ура! #Кот"));
    }

    @Test
    public void test_comment() {
        MainPage mainPage = new MainPage(SWDriver.getInstance());
        mainPage.getHistoryEvent()
                .writeComment("Hi 12345")
                .putRandomSmile()
                .clickSent()
                .checkComments(equalTo("Hi 12345"));

    }

    @Test
    public void test_comment1() {
        MainPage mainPage = new MainPage(SWDriver.getInstance());
        mainPage.getHistoryEvent()
                .checkPublicationDescription(equalTo("Вы"))
                .checkPublicationText(equalTo("wfwwd #Кот"));
        //        .checkPublicationTime(equalTo("1 час назад"));
    }

    @Test
    public void checkPhotoFilter() {
        MainPage mainPage = new MainPage(SWDriver.getInstance());
        mainPage.getHistoryEvents()
                .clickPhoto()
                .checkPhotoFilter();
    }

    @Test
    public void checkRecordFilter() {
        MainPage mainPage = new MainPage(SWDriver.getInstance());
        mainPage.getHistoryEvents()
                .clickPhoto()
                .checkPhotoFilter()
                .clickRecords()
                .checkRecordFilter();
    }

}



