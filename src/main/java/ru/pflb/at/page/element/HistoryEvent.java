package ru.pflb.at.page.element;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.pflb.at.techno.BaseElement;
import ru.pflb.at.techno.SWDriver;

public class HistoryEvent extends BaseElement {

    private static final Logger LOG = LogManager.getLogger(HistoryEvents.class);

    /**
     * Конструктор класса
     *
     * @param rootElement
     * @param swDriver
     */
    public HistoryEvent(WebElement rootElement, SWDriver swDriver) {
        super(rootElement, swDriver);
    }

    public String getPublishTime() {
        LOG.info("Получаем время публекации");
        WebElement webElement = getRoot().findElement(By.cssSelector(".b-history-event_time"));
        return webElement.getText();
    }

    public String getPostAuthor() {
        LOG.info("Получаем автора поста");
        WebElement webElement = getRoot().findElement(By.cssSelector(".b-history-event__ownername"));
        return webElement.getText();
    }

    public String getText() {
        LOG.info("Получаем содержимое поста");
        WebElement webElement = getRoot().findElement(By.cssSelector(".b-history-event__body"));
        return webElement.getText();
    }

    public HistoryEvent checkPublicationTime(Matcher <String> matcher) {
        LOG.info("Проверяем время публикации: {}", matcher);
        MatcherAssert.assertThat("не удовлетворяет условию", getPublishTime(), matcher);
        return this;
    }

    public HistoryEvent checkPublicationAuthor(Matcher <String> matcher) {
        LOG.info("Проверяем автора публикации: {}", matcher);
        MatcherAssert.assertThat("не удовлетворяет условию", getPostAuthor(), matcher);
        return this;
    }

    public HistoryEvent checkPublicationText(Matcher <String> matcher) {
        LOG.info("Проверяем текст публикации: {}", matcher);
        MatcherAssert.assertThat("не удовлетворяет условию", getText(), matcher);
        return this;
    }


}
