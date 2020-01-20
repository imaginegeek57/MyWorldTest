package ru.pflb.at.test;

import org.junit.jupiter.api.BeforeEach;
import ru.pflb.at.techno.BaseTest;

public class MusicWindowStepsTest extends BaseTest {

    @BeforeEach
    public void setUp() {
        loginHomePage.login(userProperties);
        loginHomePage.closeAdvert();
    }

//    @Test
//    public void add_music_track_test() {
//        musicPage
//              //  .pressNewEvent()
//                .pressMusic()
//                .addMusicFrom()
//                .enterMusicName("50 cent")
//                .markTrack()
//                .pressAddTracks()
//                .pressNewEvent()
//                .enterPublishName("#50forever!")
//                .pressPublish();
//    }
}
