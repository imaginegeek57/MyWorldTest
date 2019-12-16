package ru.pflb.at.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
     * Кнопка "Музыка"
     */
    @FindBy(xpath = "//li[@data-id='music']/a")
    private WebElement buttonMusic;

    /**
     * Текстовое поле "search music"
     */
    @FindBy(css = "//input[@name='query']")
    private WebElement searchMusic;

    /**
     * Кнопка "Enter"
     */
    @FindBy(xpath = "//button")
    private WebElement buttonEnterSearch;


}
