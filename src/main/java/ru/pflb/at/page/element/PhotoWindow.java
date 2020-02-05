package ru.pflb.at.page.element;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import ru.pflb.at.techno.BaseElement;
import ru.pflb.at.techno.SWDriver;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

public class PhotoWindow extends BaseElement {

    public static final Logger LOG = LogManager.getLogger(PhotoWindow.class);

    /**
     * Конструктор класса
     *
     * @param swDriver
     * @param rootElement
     */
    public PhotoWindow(WebElement rootElement, SWDriver swDriver) {
        super(rootElement, swDriver);
    }

    /**
     * Жмем кнопку 'Добавить фото по ссылке из интернета'
     */
    public PhotoWindow addPhotoByLink() {
        LOG.info("Жмем кнопку 'Добавить фото по ссылке из интернета'");
        WebElement elementAddByLink = getRoot().findElement(cssSelector(".b-photo-upload__link__button-network"));
        elementAddByLink.click();
        screenshot();
        return this;
    }

    /**
     * Вводим URL
     */
    public PhotoWindow writeUrl(String url) {
        LOG.info("В поле 'URL' записано: {}", url);
        WebElement elementwriteUrl = getRoot().findElement(cssSelector(".b-photo-upload__network__item__input"));
        elementwriteUrl.sendKeys(url);
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Загрузить'
     */
    public PhotoWindow clickUploadPhoto() {
        LOG.info("Фотография загружена");
        WebElement elementAddByLink = getRoot().findElement(xpath("//div[text()='Загрузить']"));
        elementAddByLink.click();
        screenshot();
        return this;
    }

    /**
     * Текстовое поле описание фотографии
     */
    public PhotoWindow writeDescribePhoto(String text) {
        LOG.info("Добавлено описания фотографии: {}", text);
        WebElement elementAddByLink = getRoot().findElement(cssSelector(".b-photo-upload__edit-item-expanded__description"));
        elementAddByLink.sendKeys(text);
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Сохранить'
     */
    public PhotoWindow clickSavePhoto() {
        LOG.info("Фотография сохранена");
        WebElement elementAddByLink = getRoot().findElement(xpath("//div[text()='Сохранить']"));
        webWait(10).until(invisibilityOfElementLocated(xpath("//div[text()='Сохранить']")));
        elementAddByLink.click();
        screenshot();
        return this;
    }
}
