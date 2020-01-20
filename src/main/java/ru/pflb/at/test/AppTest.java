package ru.pflb.at.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.pflb.at.page.MainPage;
import ru.pflb.at.techno.BaseTest;
import ru.pflb.at.techno.SWDriver;

public class AppTest extends BaseTest {

    @BeforeEach
    public void setUp() {
        loginHomePage.login(userProperties);
        loginHomePage.closeAdvert();
    }

    @Test
    public void test_test() {
//            MainPage mainPage = new MainPage(SWDriver.getInstance());
//            mainPage.getNewEventForm()
//                    .pressMusic()
//                    .pressPhoto()
//            mainPage.getNewEventForm()
//            .setWriteStatus(true);
//            System.out.println();

        MainPage mainPage = new MainPage(SWDriver.getInstance());

        mainPage.getNewEventForm()
                .pressNewEvent()
                .setWriteStatus(true)
                .pressPhoto();
    }


}



