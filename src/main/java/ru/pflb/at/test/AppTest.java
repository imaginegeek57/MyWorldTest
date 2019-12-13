package ru.pflb.at.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.pflb.at.techno.BaseTest;

public class AppTest extends BaseTest {

    @BeforeEach
    public void setUp() {
        registrationHomePage.login(userProperties);
    }

    @Test
    public void sent_mail_positive_test() {
        mailPage.closeAd()
                .enterMail();
        System.out.println();
    }

}

