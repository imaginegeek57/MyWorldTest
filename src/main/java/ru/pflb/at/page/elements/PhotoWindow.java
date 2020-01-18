package ru.pflb.at.page.elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.pflb.at.techno.BasePage;
import ru.pflb.at.techno.SWDriver;

public class PhotoWindow extends BasePage {

    public static final Logger LOG = LogManager.getLogger(PhotoWindow.class);

    /**
     * Конструктор класса
     *
     * @param swDriver
     */
    public PhotoWindow(SWDriver swDriver) {
        super(swDriver);
    }

    /**
     * Кнопка "Добавить фото по ссылке из интернета"
     */
    @FindBy(css = ".b-photo-upload__link__button-network")
    private WebElement addPhotoByLink;

    /**
     * Текстовое поле "URL"
     */
    @FindBy(css = ".b-photo-upload__network__item__input")
    private WebElement writeURL;

    /**
     * Кнопка "Загрузить фото"
     */
    @FindBy(xpath = "//div[text()='Загрузить']")
    private WebElement buttonUpload;

    /**
     * Текстовое поле "Описание фото"
     */
    @FindBy(css = ".b-photo-upload__edit-item-expanded__description")
    private WebElement buttondescribe;

    /**
     * Кнопка "Сохранить фото"
     */
    @FindBy(xpath = "//div[text()='Сохранить']")
    private WebElement savePhoto;

    /**
     * Жмем кнопку 'Добавить по ссылке из интернета'
     */
    public PhotoWindow addByLink() {
        addPhotoByLink.click();
        LOG.info("Жмем кнопку 'Добавить по ссылке'");
        screenshot();
        return this;
    }

    /**
     * Вводим URL
     */
    public PhotoWindow writeUrl(String url) {
        writeURL.sendKeys(url);
        LOG.info("В поле 'URL' записано: {}", url);
        return this;
    }

    /**
     * Жмем кнопку 'Добавить фото'
     */
    public PhotoWindow uploadPhoto() {
        buttonUpload.click();
        LOG.info("Фотография загружена");
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Сохранить'
     */
    public PhotoWindow savePhoto() {
        new WebDriverWait(getWebDriver(), 10);
        savePhoto.click();
        LOG.info("Фотография сохранена");
        screenshot();
        return this;
    }

    /**
     * Текстовое поле описание фотографии
     */
    public PhotoWindow describePhoto(String text) {
        new WebDriverWait(getWebDriver(), 10);
        buttondescribe.sendKeys(text);
        LOG.info("Добавлено описания фотографии: {}", text);
        screenshot();
        return this;
    }
}
