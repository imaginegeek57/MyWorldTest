package ru.pflb.at.page.element;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.pflb.at.techno.BaseElement;
import ru.pflb.at.techno.SWDriver;

import java.util.List;
import java.util.Random;

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
    public HistoryEvent removeLastPublish() {
        LOG.info("Жмем кнопку 'Удалить запись'");
        new WebDriverWait(getWebDriver(), 0, 500);
        WebElement webElement = getRoot().findElement(By.cssSelector(".history_icon-settings-ico"));
        webElement.click();
        WebElement webElement1 = getRoot().findElement(By.xpath("//a[@data-event-control='remove']"));
        webElement1.click();
        WebElement webElement2 = getRoot().findElement(By.xpath("//span[@class='ui-button-main mr10 js-bubble__confirm-yes']"));
        webElement2.click();
        screenshot();
        return this;
    }

    /**
     * Записываем комментарий в текстовое поле 'Написать комментарий...'
     */
    public HistoryEvent writeComment(String text) {
        LOG.info("Добавлен комментарий: {}", text);
        WebElement webElement = getRoot().findElement(By.cssSelector(".b-comments__history-button"));
        webElement.click();
        WebElement webElement1 = getRoot().findElement(By.cssSelector("textarea[placeholder='Написать комментарий...']"));
        webElement1.sendKeys(text);
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

    /**
     * Удаляем последний комментарий
     */
    public HistoryEvent removeLastComment() {
        LOG.info("Комментарий удален");
        WebElement webElement = getRoot().findElement(By.cssSelector(".b-comments__settings"));
        webElement.click();
        WebElement webElement1 = getRoot().findElement(By.cssSelector(".js-ui-bubble"));
        webElement1.click();
        screenshot();
        return this;
    }

    /**
     * Кликаем случайный смайл
     *
     * @return events
     */
    public HistoryEvent clickRandomSmile() {
        WebElement webElement = getRoot().findElement(By.cssSelector(".b-comments-writer__smiles-more"));
        webElement.click();
        List <WebElement> elements = getRoot().findElements(By.cssSelector(".b-comments-writer__smiles-list__item"));
        Random random = new Random();
        int num = random.nextInt(elements.size());
        WebElement smile = elements.get(num);
        smile.click();
        return this;
    }

    public HistoryEvent checkPublicationTime(Matcher <String> matcher) {
        LOG.info("Проверяем время публикации: {}", matcher);
        WebElement webElement = getRoot().findElement(By.cssSelector(".b-history-event_time"));
        String result = webElement.getText();
        assertThat("не удовлетворяет условию", result, matcher);
        return this;
    }

    public String getDescriptionOfPublish() {
        LOG.info("Получаем описание поста");
        WebElement webElement = getRoot().findElement(By.cssSelector(".b-history-event__action"));
        return webElement.getText();
    }

    public HistoryEvent checkPublicationDescription(Matcher <String> matcher) {
        LOG.info("Проверяем описание публикации: {}", matcher);
        assertThat("не удовлетворяет условию", getDescriptionOfPublish(), matcher);
        return this;
    }

    public HistoryEvent checkPublicationText(Matcher <String> matcher) {
        LOG.info("Проверяем текст публикации: {}", matcher);
        WebElement webElement = getRoot().findElement(By.xpath("//div[@class='b-history-event__body']/div/div"));
        String result = webElement.getText();
        assertThat("не удовлетворяет условию", result, matcher);
        return this;
    }

    public HistoryEvent checkComments(Matcher <String> matcher) {
        LOG.info("Проверяем текст комментария: {}", matcher);
        WebElement webElement = getRoot().findElement(By.cssSelector(".b-comments__item-text"));
        String result = webElement.getText();
        assertThat("не удовлетворяет условию", result, matcher);
        return this;
    }

}
