package ru.pflb.at.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.pflb.at.techno.BasePage;
import ru.pflb.at.techno.SWDriver;

public class MusicPage extends BasePage {

    /**
     * Конструктор класса
     *
     * @param swDriver
     */
    public MusicPage(SWDriver swDriver) {
        super(swDriver);
    }

    /**
     * Текстовое поле "Искать"
     */
    @FindBy(css = ".b-publisher__text")
    private WebElement buttonSearch;

    /**
     * Кнопка "Музыка"
     */
    @FindBy(xpath = "//div/div[text()='Музыка']")
    private WebElement buttonMusic;

    /**
     * Кнопка добавить музыку из поиска
     */
    @FindBy(css = ".b-audio-upload__link__button-search")
    private WebElement addMusic;
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
     * Кнопка "Поделиться"
     */
    @FindBy(css = ".b-publisher__controls__submit ")
    private WebElement buttonPublish;

    /**
     * Жмем кнопку 'Музыка'
     */
    public MusicPage enterMusic() {
        buttonMusic.click();
        LOG.info("Жмем кнопку 'Музыка'");
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Искать'
     */
    public MusicPage pressSearch() {
        buttonSearch.click();
        LOG.info("Жмем кнопку 'Искать'");
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Добавить из поиска'
     */
    public MusicPage addMusicFrom() {
        new WebDriverWait(getWebDriver(), 10);
        addMusic.click();
        LOG.info("Жмем кнопку 'Добавить из поиска'");
        screenshot();
        return this;
    }

    /**
     * Вводим название музыки для поиска
     */
    public MusicPage searchMusic(String search) {
        searchMusic.sendKeys(search);
        LOG.info("В поле 'Поиск' записано: {}", search);
        return this;
    }

    /**
     * Отмечаем выбранные треки
     */
    public MusicPage enterSearch() {
        checkBox.click();
        LOG.info("Треки выбранны");
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Добавить выбранные треки'
     */
    public MusicPage addTracks() {
        addTrack.click();
        LOG.info("Жмем кнопку 'Добавить выбранные треки'");
        screenshot();
        return this;
    }

    /**
     * Вводим название записи для публикации
     */
    public MusicPage publish(String text) {
        buttonSearch.sendKeys(text);
        LOG.info("В поле 'Публикации' записано: {}", text);
        return this;
    }

    /**
     * Жмем кнопку 'Добавить публекацию'
     */
    public MusicPage addPublish() {
        buttonPublish.click();
        LOG.info("Жмем кнопку 'Добавить публекацию'");
        screenshot();
        return this;
    }
}
