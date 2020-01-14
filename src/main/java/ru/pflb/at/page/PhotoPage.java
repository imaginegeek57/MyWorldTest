package ru.pflb.at.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
     * Кнопка "Фото"
     */
    @FindBy(xpath = "//li[@data-id='photo']/a")
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
    @FindBy(xpath = "//div[text()='Загрузить']")
    private WebElement buttonUpload;

    /**
     * Кнопка "Сохранить фото"
     */
    @FindBy(xpath = "//div[text()='Сохранить']")
    private WebElement savePhoto;

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
     * Жмем кнопку 'Добавить фото'
     */
    public PhotoPage addPhoto() {
        buttonAddPhoto.click();
        LOG.info("Жмем кнопку 'Добавить Фото'");
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
    public PhotoPage mailToUser(String url) {
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

    private static final String trackRowByNumberSelector = "//div[contains(@class, 'track-row')][%d]";

    public TrackRow getTrackByNumber(int number) {
        String xpath = String.format(trackRowByNumberSelector, number);
        WebElement trackElement = getWebDriver().findElement(By.xpath(xpath));
        return new TrackRow(getWebDriver(), trackElement);
    }

    public static class TrackRow {

        private WebDriver driver;

        private WebElement rootElement;

        public TrackRow(WebDriver driver, WebElement rootElement) {
            this.driver = driver;
            this.rootElement = rootElement;
        }

        private static final By addButtonSelector = By.cssSelector("div.add-button");

        public void clickAddButton() {
            WebElement addButton = rootElement.findElement(addButtonSelector);
            addButton.click();
        }

    }
}
