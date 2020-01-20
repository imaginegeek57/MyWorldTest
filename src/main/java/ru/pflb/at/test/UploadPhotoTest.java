package ru.pflb.at.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.pflb.at.techno.BaseTest;

@Deprecated
public class UploadPhotoTest extends BaseTest {

    /**
     * URL картинки
     */
    public static final String IMAGE_URL = "https://avatars.mds.yandex.net/get-pdb/1976538/7ea9875b-c3cb-49ff-9ab3-9dc436be6ab4/s1200";

    @BeforeEach
    public void setUp() {
        loginHomePage.login(userProperties);
        loginHomePage.closeAdvert();
    }

    @Test
    public void upload_photo_by_link() {
//        mainPage.getNewEventForm()
//                .addPhoto();
//        mainPage.getAddPhotoWindow()
//                .fromUrl()
//                .setUrl(IMAGE_URL)
//                .upload()
//                .setDescribe("Мой кот")
//                .save();
//        mainPage.getNewEventForm()
//                .setText("#кот")
//                .enterPublishName();






//        photoPage
//                .pressNewEvent()
//                .pressPhoto()
//                .addByLink()
//                .writeUrl(IMAGE_URL)
//                .uploadPhoto()
//                .describePhoto("Мой кот")
//                .savePhoto()
//                .enterPublishName("#кот")
//                .pressPublish();
    }
}
