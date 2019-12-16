package ru.pflb.at.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.pflb.at.techno.BaseTest;

public class SentMailTest extends BaseTest {

    @BeforeEach
    public void setUp() {
        loginHomePage.login(userProperties);
        loginHomePage.closeAdvert();
    }

    @Test
    public void sent_mail_positive_test() {
        mailPage
                .enterMail()
                .newMail()
                .mailToUser("performance.test@mail.ru")
                .mailSubject("тест")
                .letterBody("Текст письма")
                .sentTo();
    }

}
