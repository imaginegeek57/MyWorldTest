package ru.pflb.at.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.pflb.at.techno.BasePage;
import ru.pflb.at.techno.SWDriver;

public class PhotoPage extends BasePage {

    /**
     * Конструктор класса
     *
     * @param swDriver
     */
    public PhotoPage(SWDriver swDriver) {
        super(swDriver);
    }

    /**
     * Текстовое поле "Искать"
     */
    @FindBy(css = ".b-publisher__text")
    private WebElement buttonSearch;

    /**
     * Кнопка "Фото"
     */
    @FindBy(css = ".icon-crumbs_make-photo")
    private WebElement buttonPhoto;

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
     * Кнопка "Поделиться"
     */
    @FindBy(css = ".b-publisher__controls__submit")
    private WebElement buttonPublish;

    /**
     * Жмем кнопку 'Искать'
     */
    public PhotoPage pressSearch() {
        buttonSearch.click();
        LOG.info("Жмем кнопку 'Искать'");
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Фото'
     */
    public PhotoPage enterPhoto() {
        buttonPhoto.click();
        LOG.info("Жмем кнопку 'Фото'");
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Добавить по ссылке из интернета'
     */
    public PhotoPage addByLink() {
        addPhotoByLink.click();
        LOG.info("Жмем кнопку 'Добавить по ссылке'");
        screenshot();
        return this;
    }

    /**
     * Вводим URL
     */
    public PhotoPage writeUrl(String url) {
        writeURL.sendKeys(url);
        LOG.info("В поле 'URL' записано: {}", url);
        return this;
    }

    /**
     * Жмем кнопку 'Добавить фото'
     */
    public PhotoPage uploadPhoto() {
        buttonUpload.click();
        LOG.info("Фотография загружена");
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Сохранить'
     */
    public PhotoPage savePhoto() {
        new WebDriverWait(getWebDriver(), 10);
        savePhoto.click();
        LOG.info("Фотография сохранена");
        screenshot();
        return this;
    }

    /**
     * Текстовое поле описание фотографии
     */
    public PhotoPage describePhoto(String text) {
        new WebDriverWait(getWebDriver(), 10);
        buttondescribe.sendKeys(text);
        LOG.info("Добавлено описания фотографии: {}", text);
        screenshot();
        return this;
    }


    /**
     * Вводим название записи для публикации
     */
    public PhotoPage publish(String text) {
        buttonSearch.sendKeys(text);
        LOG.info("В поле 'Публикации' записано: {}", text);
        return this;
    }

    /**
     * Жмем кнопку 'Добавить публекацию'
     */
    public PhotoPage addPublish() {
        buttonPublish.click();
        LOG.info("Жмем кнопку 'Добавить публекацию'");
        screenshot();
        return this;
    }
}
