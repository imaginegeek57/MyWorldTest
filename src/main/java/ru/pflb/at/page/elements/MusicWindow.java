package ru.pflb.at.page.elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.pflb.at.techno.BaseElements;
import ru.pflb.at.techno.SWDriver;

public class MusicWindow extends BaseElements {

    public static final Logger LOG = LogManager.getLogger(MusicWindow.class);

    /**
     * Конструктор класса
     *
     * @param swDriver
     * @param rootElement
     */
    public MusicWindow(WebElement rootElement, SWDriver swDriver) {
        super(rootElement, swDriver);
    }


    /**
     * Жмем кнопку 'Добавить из поиска музыки'
     */
    public MusicWindow clickAddFromSearch() {
        LOG.info("Жмем кнопку 'Добавить из поиска музыки'");
        WebElement elementAddFrom = getRoot().findElement(By.cssSelector(".b-audio-upload__link__button-search"));
        webWait(10);
        elementAddFrom.click();
        screenshot();
        return this;
    }

    /**
     * Вводим название музыки для поиска
     */
    public MusicWindow enterMusicName(String name) {
        LOG.info("В поле 'Поиск' записано: {}", name);
        WebElement elementEnterMusic = getRoot().findElement(By.xpath("//input[@placeholder='Поиск']"));
        elementEnterMusic.sendKeys(name);
        screenshot();
        return this;
    }

    /**
     * Отмечаем выбранные треки
     */
    public MusicWindow markTrack() {
        LOG.info("Выбираем трек");
        WebElement checkBox = getRoot().findElement(By.xpath("//div[@class='b-audio-upload__search-form__content__list']/div/div/i"));
        checkBox.click();
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Добавить выбранный трек'
     */
    public MusicWindow clickAddTrack() {
        LOG.info("Жмем кнопку 'Добавить выбранные треки'");
        WebElement webElement = getRoot().findElement(By.xpath("//button[text()='Добавить']"));
        webElement.click();
        screenshot();
        return this;
    }
}