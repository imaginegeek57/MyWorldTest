package ru.pflb.at.page.element;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.pflb.at.techno.BaseElement;
import ru.pflb.at.techno.SWDriver;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class HistoryEvents extends BaseElement {

    private static final Logger LOG = LogManager.getLogger(HistoryEvents.class);

    /**
     * Конструктор класса
     *
     * @param rootElement
     * @param swDriver
     */
    public HistoryEvents(WebElement rootElement, SWDriver swDriver) {
        super(rootElement, swDriver);
    }

    /**
     * Жмем кнопку 'Фото'
     */
    public HistoryEvents clickPhoto() {
        LOG.info("Жмем кнопку 'Фото'");
        WebElement webElement = getRoot().findElement(By.xpath("//span[@data-filter='photo']"));
        webElement.click();
        screenshot();
        return this;
    }


    /**
     * Жмем кнопку 'Только записи'
     */
    public HistoryEvents clickRecords() {
        LOG.info("Жмем кнопку 'Только записи'");
        WebElement webElement = getRoot().findElement(By.xpath("//div[@data-item='filter']"));
        webElement.click();
        WebElement webElement2 = getRoot().findElement(By.xpath("//div[text()='Только записи']"));
        webElement2.click();
        screenshot();
        return this;
    }

    /**
     * Получаем список событий
     *
     * @return events
     */
    public List <HistoryEvent> getListEvents() {
        List <HistoryEvent> historyEvents = new LinkedList <>();
        List <WebElement> elements = getRoot().findElements(By.cssSelector(".b-history_event_active-area"));
        for (WebElement i : elements) {
            HistoryEvent event = new HistoryEvent(i, getSwDriver());
            historyEvents.add(event);
        }
        return historyEvents;
    }

    /**
     * Проверяем фильтрацию записей
     *
     * @return boolean
     */
    public HistoryEvents checkRecordFilter() {
        LOG.info("Проверяем фильтрацию записей");
        String action = "добавили запись";
        List <HistoryEvent> historyEvents = getListEvents();
        boolean result = historyEvents.stream()
                .map(HistoryEvent::getDescriptionOfPublish)
                .filter(HistoryEvent -> HistoryEvent.contains(action))
                .allMatch((txt -> txt.contains(action)));
        assertThat("не удовлетворяет условию", result);
        return this;
    }

    /**
     * Проверяем фильтрацию фото
     *
     * @return boolean
     */
    public HistoryEvents checkPhotoFilter() {
        LOG.info("Проверяем фильтрацию фото");
        String action = "добавили фотографию";
        List <HistoryEvent> historyEvents = getListEvents();
        boolean result = historyEvents.stream()
                .map(HistoryEvent::getDescriptionOfPublish)
                //      .filter(HistoryEvent -> HistoryEvent.contains(action))
                .allMatch((txt -> txt.contains(action)));
        assertThat("не удовлетворяет условию", result);
        return this;
    }

    /**
     * Жмем кнопку 'Удалить все записи'
     */
    public HistoryEvents removeAllPublish() {
        LOG.info("Удаляем все записи'");
        List <HistoryEvent> historyEvents = getListEvents();
        for (HistoryEvent i : historyEvents) {
            i.removeLastPublish();
        }
        //    getListEvents().clear();
        return this;
    }

    //TODO переделать на 1 запись

    public HistoryEvents checkRemoveOfPublication() {
        LOG.info("Проверяем корректное удаление публикаций");
        List <HistoryEvent> historyEvents = getListEvents();
        boolean result = historyEvents.isEmpty();
        assertThat("не удовлетворяет условию", result);
        return this;
    }

    //TODO доработать и пременить

    /**
     * Жмем кнопку 'Закрыть рекламу'
     */
    public HistoryEvents closeAdvert() {
        WebElement element = getRoot().findElement(By.xpath("//div[@class='trg-b-close-overlay js-close-overlay']"));
        LOG.info("Реклама закрыта");
        List <WebElement> elements = getRoot().findElements(By.cssSelector(".rb-banner"));
        for (WebElement i : elements) {
            Actions actions = new Actions(getWebDriver());
            actions.moveToElement(i).build().perform();
            new WebDriverWait(getWebDriver(), 5)
                    .until(ExpectedConditions.invisibilityOf(element));
            element.click();
            i.findElement(By.xpath("//span[text()='Не интересует']"));
            i.click();
        }
        screenshot();
        return this;
    }
}