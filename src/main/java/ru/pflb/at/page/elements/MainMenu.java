package ru.pflb.at.page.elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.pflb.at.techno.BasePage;
import ru.pflb.at.techno.SWDriver;

public class MainMenu extends BasePage {

    public static final Logger LOG = LogManager.getLogger(MainMenu.class);

    /**
     * Конструктор класса
     *
     * @param swDriver
     */
    public MainMenu(SWDriver swDriver) {
        super(swDriver);
    }

    /**
     * Кнопка "Лента"
     */
    @FindBy(xpath = "//span[text()='Лента']")
    private WebElement buttonLine;

    /**
     * Кнопка "Друзья"
     */
    @FindBy(xpath = "//span[text()='Друзья']")
    private WebElement buttonFriend;

    /**
     * Кнопка "Фото"
     */
    @FindBy(xpath = "//span[text()='Фото']")
    private WebElement buttonPhoto;


    /**
     * Жмем кнопку 'Лента'
     */
    public MainMenu pressLine() {
        buttonLine.click();
        LOG.info("Жмем кнопку 'Лента'");
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Друзья'
     */
    public MainMenu pressFriend() {
        buttonFriend.click();
        LOG.info("Жмем кнопку 'Друзья'");
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Фото'
     */
    public MainMenu pressPhoto() {
        buttonPhoto.click();
        LOG.info("Жмем кнопку 'Фото'");
        screenshot();
        return this;
    }

}
