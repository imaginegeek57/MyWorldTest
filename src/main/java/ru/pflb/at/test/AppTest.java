package ru.pflb.at.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.pflb.at.page.MainPage;
import ru.pflb.at.page.elements.EventElement;
import ru.pflb.at.techno.BaseTest;
import ru.pflb.at.techno.SWDriver;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class AppTest extends BaseTest {

    @BeforeEach
    public void setUp() {
        loginHomePage.login(userProperties);
        loginHomePage.closeAdvert();
    }


    @Test
    public void sent_mail_positive_test() {
        mailPage
                .enterMail();
        System.out.println();


    }


    @Test
    public void test_test() {
        MainPage mainPage = new MainPage(SWDriver.getInstance());
        EventElement event = mainPage.getEventByIndex(6);
        assertThat(event.getText(), equalTo("#Кот"));
        mainPage.getMainMenu().pressFriend();
        System.out.println();

    }

}

