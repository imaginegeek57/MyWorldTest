package ru.pflb.at.page.elements;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.pflb.at.techno.BasePage;
import ru.pflb.at.techno.SWDriver;

public class NewEventForm extends BasePage {

    public static final Logger LOG = LogManager.getLogger(NewEventForm.class);

    /**
     * Конструктор класса
     *
     * @param swDriver
     */
    public NewEventForm(SWDriver swDriver) {
        super(swDriver);
    }

    /**
     * Текстовое поле "Расскажите о новом событии..."
     */
    @FindBy(css = ".b-publisher__text")
    private WebElement buttonSearch;

    /**
     * Кнопка "Музыка"
     */
    @FindBy(xpath = "//div/div[text()='Музыка']")
    private WebElement buttonMusic;

    /**
     * Кнопка "Фото"
     */
    @FindBy(css = ".icon-crumbs_make-photo")
    private WebElement buttonPhoto;

    /**
     * Кнопка "Добавить публекацию"
     */
    @FindBy(css = ".b-publisher__controls__submit ")
    private WebElement buttonPublish;

    /**
     * Жмем кнопку 'Искать'
     */
    public NewEventForm pressSearch() {
        buttonSearch.click();
        LOG.info("Жмем кнопку 'Искать'");
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Фото'
     */
    public NewEventForm enterPhoto() {
        buttonPhoto.click();
        LOG.info("Жмем кнопку 'Фото'");
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Музыка'
     */
    public NewEventForm enterMusic() {
        buttonMusic.click();
        LOG.info("Жмем кнопку 'Музыка'");
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Добавить публекацию'
     */
    public NewEventForm addPublish() {
        buttonPublish.click();
        LOG.info("Жмем кнопку 'Добавить публекацию'");
        screenshot();
        return this;
    }

    /**
     * Вводим название записи для публикации
     */
    public NewEventForm publish(String text) {
        buttonSearch.sendKeys(text);
        LOG.info("В поле 'Публикации' записано: {}", text);
        return this;
    }
}
