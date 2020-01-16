package ru.pflb.at.page.elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.pflb.at.techno.BasePage;
import ru.pflb.at.techno.SWDriver;

public class AddMusic extends BasePage {

    public static final Logger LOG = LogManager.getLogger(AddMusic.class);

    /**
     * Конструктор класса
     *
     * @param swDriver
     */
    public AddMusic(SWDriver swDriver) {
        super(swDriver);
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
    public AddMusic addMusicFromSearch() {
        new WebDriverWait(getWebDriver(), 10);
        addFromSearch.click();
        LOG.info("Жмем кнопку 'Добавить из поиска'");
        screenshot();
        return this;
    }

    /**
     * Вводим название музыки для поиска
     */
    public AddMusic searchMusic(String search) {
        searchMusic.sendKeys(search);
        LOG.info("В поле 'Поиск' записано: {}", search);
        return this;
    }

    /**
     * Отмечаем выбранные треки
     */
    public AddMusic enterSearch() {
        checkBox.click();
        LOG.info("Треки выбранны");
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Добавить выбранные треки'
     */
    public AddMusic addTracks() {
        addTrack.click();
        LOG.info("Жмем кнопку 'Добавить выбранные треки'");
        screenshot();
        return this;
    }
}
