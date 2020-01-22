package ru.pflb.at.page.elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.pflb.at.techno.BaseElements;
import ru.pflb.at.techno.SWDriver;

public class MainMenu extends BaseElements {

    public static final Logger LOG = LogManager.getLogger(MainMenu.class);

    /**
     * Конструктор класса
     *
     * @param swDriver
     * @param rootElement
     */
    public MainMenu(WebElement rootElement, SWDriver swDriver) {
        super(rootElement, swDriver);
    }


    /**
     * Жмем кнопку 'Лента'
     *
     * @return
     */
    public MainMenu clickLine() {
        LOG.info("Жмем кнопку 'Лента'");
        WebElement elementLine = getRoot().findElement(By.cssSelector("li[data-id='feed'] > a"));
        elementLine.click();
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Друзья'
     *
     * @return
     */
    public MainMenu clickFriends() {
        LOG.info("Жмем кнопку 'Друзья'");
        WebElement elementFriends = getRoot().findElement(By.xpath("//li[@data-id='friends']/a"));
        elementFriends.click();
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Фото'
     *
     * @return
     */
    public MainMenu clickPhoto() {
        LOG.info("Жмем кнопку 'Фото'");
        WebElement elementPhoto = getRoot().findElement(By.xpath("//li[@data-id='photo']/a"));
        elementPhoto.click();
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Музыка'
     *
     * @return
     */
    public MainMenu clickMusic() {
        LOG.info("Жмем кнопку 'Музыка'");
        WebElement elementMusic = getRoot().findElement(By.xpath("//li[@data-id='music']/a"));
        elementMusic.click();
        screenshot();
        return this;
    }
}
