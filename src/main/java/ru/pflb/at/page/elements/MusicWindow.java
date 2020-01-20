package ru.pflb.at.page.elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.pflb.at.techno.SWDriver;

public class MusicWindow {

    public static final Logger LOG = LogManager.getLogger(MusicWindow.class);

    private SWDriver swDriver;
    protected WebElement rootElement;

    public MusicWindow(WebElement rootElement, SWDriver swDriver) {
        this.rootElement = rootElement;
        this.swDriver = swDriver;
    }

    /**
     * Кнопка добавить музыку "Из поиска музыки"
     */
    @FindBy(css = ".b-audio-upload__link__button-search")
    private WebElement addFromSearch;

    /**
     * Кнопка добавить музыку "Из плейлистов"
     */
    @FindBy(css = ".b-audio-upload__link__button-albums")
    private WebElement addFromPlaylist;

    /**
     * Текстовое поле "Поиск"
     */
    @FindBy(xpath = "//input[@placeholder='Поиск']")
    private WebElement searchMusic;

    /**
     * Бокс отметки выбранных треков
     */
    @FindBy(xpath = "//div[@class='b-audio-upload__search-form__content__list']/div/div/i")
    private WebElement checkBox;

    /**
     * Кнопка добавить музыку из поиска
     */
    @FindBy(xpath = "//button[text()='Добавить']")
    private WebElement addTrack;


    /**
     * Жмем кнопку 'Добавить из поиска'
     */
    public MusicWindow pressAddFromSearch() {
        new WebDriverWait(swDriver.getDriver(), 10);
        addFromSearch.click();
        LOG.info("Жмем кнопку 'Добавить из поиска'");
        return this;
    }

    /**
     * Вводим название музыки для поиска
     */
    public MusicWindow enterMusicName(String name) {
        searchMusic.sendKeys(name);
        LOG.info("В поле 'Поиск' записано: {}", name);
        return this;
    }

    /**
     * Отмечаем выбранные треки
     */
    public MusicWindow markTraks() {
        checkBox.click();
        LOG.info("Треки выбранны");
        return this;
    }

    /**
     * Жмем кнопку 'Добавить выбранные треки'
     */
    public MusicWindow pressAddTracks() {
        addTrack.click();
        LOG.info("Жмем кнопку 'Добавить выбранные треки'");
        return this;
    }
}
