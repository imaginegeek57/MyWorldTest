package ru.pflb.at.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.pflb.at.techno.SWDriver;

public class UploadPhotoByLink extends BasePage {

    /**
     * Конструктор класса
     *
     * @param swDriver
     */
    public UploadPhotoByLink(SWDriver swDriver) {
        super(swDriver);
    }

    /**
     * Кнопка "Закрыть рекламу"
     */
    @FindBy(xpath = "//div[@class='b-popup__header__close icon-crumbs_delete-album icon-crumbs_delete-album']")
    private WebElement buttonAdvert;

    /**
     * Кнопка "Фото"
     */
    @FindBy(xpath = "//li[@data-id='photo'")
    private WebElement buttonPhoto;

    /**
     * Кнопка "Добавить фото"
     */
    @FindBy(xpath = "//div[@data-mru-fragment='content-tools/photo/upload/button']")
    private WebElement buttonAddPhoto;

    /**
     * Кнопка "Добавить фото по ссылке из интернета"
     */
    @FindBy(xpath = "//div[@class='b-photo-upload__link']/div")
    private WebElement addPhotoByLink;

    /**
     * Текстовое поле "URL"
     */
    @FindBy(css = "input.b-photo-upload__network__item__input")
    private WebElement writeURL;

    /**
     * Кнопка "Загрузить фото"
     */
    @FindBy(xpath = "//div[@data-item-id='0']/input")
    private WebElement buttonDownload;

    /**
     * Жмем кнопку 'Закрыть рекламу'
     */
    public UploadPhotoByLink closeAdvert() {
        buttonAdvert.click();
        LOG.info("Реклама закрыта");
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Фото'
     */
    public UploadPhotoByLink enterPhoto() {
        buttonPhoto.click();
        LOG.info("Жмем кнопку 'Фото'");
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Добавить фото'
     */
    public UploadPhotoByLink addPhoto() {
        buttonAddPhoto.click();
        LOG.info("Жмем кнопку 'Добавить Фото'");
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Добавить по ссылке из интернета'
     */
    public UploadPhotoByLink addByLink() {
        addPhotoByLink.click();
        LOG.info("Жмем кнопку 'Добавить по ссылке'");
        screenshot();
        return this;
    }

    /**
     * Вводим URL
     */
    public UploadPhotoByLink mailToUser(String url) {
        writeURL.sendKeys(url);
        LOG.info("В поле 'URL' записано: {}", url);
        return this;
    }

    /**
     * Жмем кнопку 'Добавить фото'
     */
    public UploadPhotoByLink downloadPhotoLink() {
        buttonDownload.click();
        LOG.info("Фотография загружена");
        screenshot();
        return this;
    }


}
