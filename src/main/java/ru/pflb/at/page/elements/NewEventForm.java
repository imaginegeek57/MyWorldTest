package ru.pflb.at.page.elements;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.pflb.at.techno.SWDriver;

//TODO Base element page
public class NewEventForm {

    public static final Logger LOG = LogManager.getLogger(NewEventForm.class);

    private SWDriver swDriver;
    private WebElement rootElement;

    public NewEventForm(WebElement rootElement, SWDriver swDriver) {
        this.rootElement = rootElement;
        this.swDriver = swDriver;
    }

    public NewEventForm setWriteStatus(boolean value) {
        WebElement checkboxElement = this.rootElement.findElement(By.id("b-publisher__controls__status__checkbox"));
        WebElement labelElement = this.rootElement.findElement(By.cssSelector("label[for='b-publisher__controls__status__checkbox']"));
        if (value != ("true".equals(checkboxElement.getAttribute("checked")))) {
            labelElement.click();
        }
        return this;
    }

    /**
     * Выбираем текстовое поле "Расскажите о новом событии..."
     */
    public NewEventForm pressNewEvent() {
        WebElement webElement = rootElement.findElement(By.cssSelector(".b-publisher__text"));
        webElement.click();
        LOG.info("Выбираем текстовое поле 'Расскажите о новом событии...'");
        return this;
    }

    /**
     * Жмем кнопку 'Фото'
     */
    public NewEventForm pressPhoto() {
        WebElement webElement = rootElement.findElement(By.cssSelector(".icon-crumbs_make-photo"));
        webElement.click();
        LOG.info("Жмем кнопку 'Фото'");
        return this;
    }

    /**
     * Жмем кнопку 'Музыка'
     */
    public NewEventForm pressMusic() {
        WebElement webElement = rootElement.findElement(By.xpath("//div/div[text()='Музыка']"));
        webElement.click();
        LOG.info("Жмем кнопку 'Музыка'");
        return this;
    }

    /**
     * Жмем кнопку 'Добавить публекацию'
     */
    public NewEventForm pressPublish() {
        WebElement webElement = rootElement.findElement(By.cssSelector("b-publisher__controls__submit"));
        webElement.click();
        LOG.info("Жмем кнопку 'Добавить публекацию'");
        return this;
    }

    /**
     * Вводим название записи для публикации
     */
    public NewEventForm enterPublishName(String text) {
        WebElement webElement = rootElement.findElement(By.cssSelector(".b-publisher__text"));
        webElement.sendKeys(text);
        LOG.info("В поле 'Публикации' записано: {}", text);
        return this;
    }
}
