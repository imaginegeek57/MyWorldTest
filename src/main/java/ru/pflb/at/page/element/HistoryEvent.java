package ru.pflb.at.page.element;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.pflb.at.techno.BaseElement;
import ru.pflb.at.techno.SWDriver;

import static org.hamcrest.MatcherAssert.assertThat;

public class HistoryEvent extends BaseElement {

    private static final Logger LOG = LogManager.getLogger(HistoryEvent.class);

    /**
     * Конструктор класса
     *
     * @param rootElement
     * @param swDriver
     */
    public HistoryEvent(WebElement rootElement, SWDriver swDriver) {
        super(rootElement, swDriver);
    }

    /**
     * Жмем кнопку 'Удалить запись'
     */
    public HistoryEvent clickRemove() {
        LOG.info("Жмем кнопку 'Удалить запись'");
        WebElement webElement1 = getRoot().findElement(By.cssSelector(".history_icon-settings-ico"));
        webElement1.click();
        WebElement webElement2 = getRoot().findElement(By.xpath("//a[@data-event-control='remove']"));
        webElement2.click();
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'ДА'
     */
    public HistoryEvent clickYes() {
        LOG.info("Жмем кнопку 'ДА'");
        WebElement webElement = getRoot().findElement(By.xpath("//span[@class='ui-button-main mr10 js-bubble__confirm-yes']"));
        webElement.click();
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Комментировать '
     */
    public HistoryEvent clickComment() {
        LOG.info("Жмем кнопку 'Комментировать'");
        WebElement webElement = getRoot().findElement(By.xpath("//span[text()='Комментировать']"));
        webElement.click();
        screenshot();
        return this;
    }

    /**
     * Текстовое поле 'Написать комментарий...'
     */
    public HistoryEvent writeComment(String text) {
        LOG.info("Добавлен комментарий: {}", text);
        WebElement webElement = getRoot().findElement(By.cssSelector("textarea[placeholder='Написать комментарий...']"));
        webElement.sendKeys(text);
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Отправить'
     */
    public HistoryEvent clickSent() {
        LOG.info("Жмем кнопку 'Отправить'");
        WebElement webElement = getRoot().findElement(By.xpath("//button[text()='Отправить']"));
        webElement.click();
        screenshot();
        return this;
    }

    public String getPublishTime() {
        LOG.info("Получаем время публикации");
        WebElement webElement = getRoot().findElement(By.cssSelector(".b-history-event_time"));
        //webWait(10).until(invisibilityOfElementLocated(cssSelector(".b-history-event_time")));
        return webElement.getText();
    }

    public String getDescriptionOfPublish() {
        LOG.info("Получаем описание поста");
        WebElement webElement = getRoot().findElement(By.cssSelector(".b-history-event__action"));
        return webElement.getText();
    }

    public String getPublishText() {
        LOG.info("Получаем текс поста");
        WebElement webElement = getRoot().findElement(By.xpath("//div[@class='b-history-event__body']/div/div"));
        return webElement.getText();
    }

    public HistoryEvent checkPublicationTime(Matcher <String> matcher) {
        LOG.info("Проверяем время публикации: {}", matcher);
        assertThat("не удовлетворяет условию", getPublishTime(), matcher);
        return this;
    }

    public HistoryEvent checkPublicationAuthor(Matcher <String> matcher) {
        LOG.info("Проверяем автора публикации: {}", matcher);
        assertThat("не удовлетворяет условию", getDescriptionOfPublish(), matcher);
        return this;
    }

    public HistoryEvent checkPublicationText(Matcher <String> matcher) {
        LOG.info("Проверяем текст публикации: {}", matcher);
        assertThat("не удовлетворяет условию", getPublishText(), matcher);
        return this;
    }
}
