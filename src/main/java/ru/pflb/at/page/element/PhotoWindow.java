package ru.pflb.at.page.element;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.pflb.at.techno.BaseElement;
import ru.pflb.at.techno.SWDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

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
        WebElement textElement = getRoot().findElement(cssSelector(".b-photo-upload__edit-item-expanded__description"));
        textElement.sendKeys(text);
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Сохранить'
     */
    public PhotoWindow clickSavePhoto() {
        LOG.info("Фотография сохранена");
        WebElement element = getRoot().findElement(xpath("//div[text()='Сохранить']"));
        new WebDriverWait(getWebDriver(), 60)
                .until(ExpectedConditions.invisibilityOf(element));
        element.click();
        screenshot();
        return this;
    }

    public PhotoWindow clickButtonPhotoLeftMenu() {
        LOG.info("В левом меню жмем кнопку 'ФОТО'");
        WebElement element = getWebDriver().findElement(By.xpath("//ul[@class='b-left-menu__items']"))
                .findElement(By.xpath("./li[@data-id='photo']"));
        element.click();
        return this;
    }

    public PhotoWindow openPhotoInAlbum() {
        LOG.info("Открываем фото в альбоме");
        WebElement webElement = getWebDriver().findElement(By.xpath("//a[@href='/mail/performance.test/photo/_mypagephoto']"));
        webElement.click();
        WebElement webElement1 = getWebDriver().findElement(By.xpath("//div[@class='b-catalog__photo-item can-edit']/a"));
        new WebDriverWait(getWebDriver(), 20)
                .until(ExpectedConditions.invisibilityOf(webElement1));
        webElement1.click();
        return this;
    }

    public PhotoWindow checkPhotoDescription(Matcher <String> matcher) {
        LOG.info("Проверяем описание фото в альбоме");
        WebElement webElement1 = getWebDriver().findElement(By.cssSelector(".b-photo__content-description-text"));
        String result = webElement1.getText();
        assertThat("не удовлетворяет условию", result, matcher);
        return this;
    }
}
