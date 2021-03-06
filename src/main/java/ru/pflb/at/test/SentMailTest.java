package ru.pflb.at.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.pflb.at.techno.BaseTest;

public class SentMailTest extends BaseTest {

    @BeforeEach
    public void setUp() {
        loginHomePage.login(webConfig, userProperties);
        loginHomePage.closeAdvert();
    }

    @Test
    public void sent_mail_positive_test() {
        mailPage
                .clickMail()
                .clickNewMail()
                .mailToUser("performance.test@mail.ru")
                .writeSubject("тест")
                .writeLetter("Текст письма")
                .clickSent();
    }
}
