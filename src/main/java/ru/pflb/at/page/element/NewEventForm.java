package ru.pflb.at.page.element;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.pflb.at.techno.BaseElement;
import ru.pflb.at.techno.SWDriver;

public class NewEventForm extends BaseElement {

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
    public NewEventForm setCheckboxStatus(boolean value) {
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
    public NewEventForm clickNewEvent() {
        LOG.info("Выбираем текстовое поле 'Расскажите о новом событии...'");
        WebElement webElement = getRoot().findElement(By.cssSelector(".b-publisher__text"));
        webElement.click();
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Фото'
     */
    public NewEventForm clickPhoto() {
        LOG.info("Жмем кнопку 'Фото'");
        WebElement webElement = getRoot().findElement(By.cssSelector(".icon-crumbs_make-photo"));
        webElement.click();
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Музыка'
     */
    public NewEventForm clickMusic() {
        LOG.info("Жмем кнопку 'Музыка'");
        WebElement webElement = getRoot().findElement(By.xpath("//div/div[text()='Музыка']"));
        webElement.click();
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Добавить публекацию'
     */
    public NewEventForm clickPublish() {
        LOG.info("Жмем кнопку 'Добавить публекацию'");
        WebElement webElement = getRoot().findElement(By.cssSelector(".b-publisher__controls__submit"));
        webElement.click();
        new WebDriverWait(getWebDriver(), 0, 800);
        screenshot();
        return this;
    }

    /**
     * Вводим название записи для публикации
     */
    public NewEventForm writePublishName(String text) {
        LOG.info("В поле 'Публикации' записано: {}", text);
        WebElement webElement = getRoot().findElement(By.cssSelector(".b-publisher__text"));
        webElement.sendKeys(text);
        screenshot();
        return this;
    }


}
