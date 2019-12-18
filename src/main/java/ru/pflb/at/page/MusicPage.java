package ru.pflb.at.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
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
     *
     */
    @FindBy(xpath = "//textarea[@placeholder='Расскажите о новом событии...']")
    private WebElement buttonTell;

    /**
     *
     */
    @FindBy(xpath = "//div/div[text()='Музыка']")
    private WebElement buttonMus;

    /**
     * Кнопка "Ещё"
     */
    @FindBy(xpath = "//i[@class='b-history_filter-more__icon ui-icon']")
    private WebElement buttonElse;

    /**
     * Кнопка "Музыка"
     */
    @FindBy(xpath = "//li/div[text()='Музыка']")
    private WebElement buttonMusic;

    /**
     * Кнопка добавить музыку из поиска
     */
    @FindBy(css = "//button[@class='b-audio-upload__link__button b-audio-upload__link__button-search ui-button-gray']")
    private WebElement addMusic;

    /**
     * Текстовое поле "Поиск"
     */
    @FindBy(xpath = "//input[@placeholder='Поиск']")
    private WebElement searchMus;

    /**
     * Веб элемент "tracks list"
     */
    @FindBy(xpath = "//div[@class='b-audio-upload__search-form__content__list']")
    private WebElement tracksList;

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
     * Жмем кнопку 'Музыка'
     */
    public MusicPage enterMusic() {
        buttonMusic.click();
        LOG.info("Жмем кнопку 'Музыка'");
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Ещё'
     */
    public MusicPage pressElse() {
        buttonElse.click();
        LOG.info("Жмем кнопку 'Ещё'");
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
        searchMus.sendKeys(search);
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
}
