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
//              //  .pressSearch()
//                .enterMusic()
//                .addMusicFrom()
//                .searchMusic("50 cent")
//                .enterSearch()
//                .addTracks()
//                .pressSearch()
//                .publish("#50forever!")
//                .addPublish();
//    }
}
