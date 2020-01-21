package ru.pflb.at.page.elements;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.pflb.at.techno.BaseElements;
import ru.pflb.at.techno.SWDriver;

public class NewEventForm extends BaseElements {

    private static final Logger LOG = LogManager.getLogger(NewEventForm.class);

    /**
     * Конструктор класса
     *
     * @param swDriver
     * @param rootElement
     */
    public NewEventForm(WebElement rootElement, SWDriver swDriver) {
        super(rootElement, swDriver);
    }

    /**
     * Установить статус checkbox
     * по умолчанию 'true'
     *
     * @param value
     * @return
     */
    public NewEventForm setWriteStatus(boolean value) {
        LOG.info("Установлеваем статус checkbox");
        WebElement checkboxElement = getRoot().findElement(By.id("b-publisher__controls__status__checkbox"));
        WebElement labelElement = getRoot().findElement(By.cssSelector("label[for='b-publisher__controls__status__checkbox']"));
        if (value != ("true".equals(checkboxElement.getAttribute("checked")))) {
            labelElement.click();
        }
        screenshot();
        return this;
    }

    /**
     * Выбираем текстовое поле "Расскажите о новом событии..."
     */
    public NewEventForm pressNewEvent() {
        LOG.info("Выбираем текстовое поле 'Расскажите о новом событии...'");
        WebElement webElement = getRoot().findElement(By.cssSelector(".b-publisher__text"));
        webElement.click();
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Фото'
     */
    public NewEventForm pressPhoto() {
        LOG.info("Жмем кнопку 'Фото'");
        WebElement webElement = getRoot().findElement(By.cssSelector(".icon-crumbs_make-photo"));
        webElement.click();
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Музыка'
     */
    public NewEventForm pressMusic() {
        LOG.info("Жмем кнопку 'Музыка'");
        WebElement webElement = getRoot().findElement(By.xpath("//div/div[text()='Музыка']"));
        webElement.click();
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Добавить публекацию'
     */
    public NewEventForm pressPublish() {
        LOG.info("Жмем кнопку 'Добавить публекацию'");
        WebElement webElement = getRoot().findElement(By.cssSelector(".b-publisher__controls__submit"));
        webElement.click();
        screenshot();
        return this;
    }

    /**
     * Вводим название записи для публикации
     */
    public NewEventForm enterPublishName(String text) {
        LOG.info("В поле 'Публикации' записано: {}", text);
        WebElement webElement = getRoot().findElement(By.cssSelector(".b-publisher__text"));
        webElement.sendKeys(text);
        screenshot();
        return this;
    }
}
