package ru.pflb.at.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.pflb.at.techno.BaseTest;

public class AddMusicTest extends BaseTest {

    /**
     * URL картинки
     */
    public static final String MUSIC_URL = "50 cent";

    @BeforeEach
    public void setUp() {
        loginHomePage.login(userProperties);
        loginHomePage.closeAdvert();
    }

    @Test
    public void upload_photo_by_link() {
        musicPage.screenshot();

    }
}
