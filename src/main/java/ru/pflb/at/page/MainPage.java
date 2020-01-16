package ru.pflb.at.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.pflb.at.page.elements.AddMusic;
import ru.pflb.at.page.elements.AddPhoto;
import ru.pflb.at.page.elements.NewEventForm;
import ru.pflb.at.techno.BasePage;
import ru.pflb.at.techno.SWDriver;

public class MainPage extends BasePage {

    public static final Logger LOG = LogManager.getLogger(MainPage.class);

    /**
     * Конструктор класса
     *
     * @param swDriver
     */
    protected MainPage(SWDriver swDriver) {
        super(swDriver);
    }

    public SWDriver swDriver;

    NewEventForm newEventForm = new NewEventForm(swDriver);
    AddPhoto addPhoto = new AddPhoto(swDriver);
    AddMusic addMusic = new AddMusic(swDriver);


    public static void main(String[] args) {

    }
}
