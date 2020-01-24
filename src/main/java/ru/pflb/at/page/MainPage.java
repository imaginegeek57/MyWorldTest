package ru.pflb.at.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.pflb.at.page.element.*;
import ru.pflb.at.techno.BasePage;
import ru.pflb.at.techno.SWDriver;

public class MainPage extends BasePage {

    public static final Logger LOG = LogManager.getLogger(MainPage.class);

    /**
     * Конструктор класса
     *
     * @param swDriver
     */
    public MainPage(SWDriver swDriver) {
        super(swDriver);
    }


    @FindBy(css = "div[data-mru-fragment='publisher']")
    private WebElement newEventFormRoot;

    /**
     * Получение формы добавления события
     *
     * @return
     */
    public NewEventForm getNewEventForm() {
        return new NewEventForm(newEventFormRoot, getSwDriver());
    }

    @FindBy(xpath = "//div[@class='b-left-menu']")
    private WebElement MainMenuRoot;

    /**
     * Получение формы работы с главным меню
     *
     * @return
     */
    public MainMenu getMainMenu() {
        return new MainMenu(MainMenuRoot, getSwDriver());
    }

    @FindBy(css = "div.b-photo-upload-popup")
    private WebElement photoWindowRoot;

    /**
     * Получение формы всплывающего окна 'Фото'
     *
     * @return
     */
    public PhotoWindow getPhotoWindow() {
        return new PhotoWindow(photoWindowRoot, getSwDriver());
    }

    @FindBy(xpath = "//div[@class='b-popup b-audio-upload-popup show']")
    private WebElement MusicWindowRoot;

    /**
     * Получение формы всплывающего окна 'Музыка'
     *
     * @return
     */
    public MusicWindow getMusicWindow() {
        return new MusicWindow(MusicWindowRoot, getSwDriver());
    }

    @FindBy(css = ".content-wrapper_today")
    private WebElement HistoryEventRoot;

    /**
     * Получение формы истории событий
     *
     * @return
     */
    public HistoryEvent getHistoryEvent() {
        return new HistoryEvent(HistoryEventRoot, getSwDriver());
    }
}
