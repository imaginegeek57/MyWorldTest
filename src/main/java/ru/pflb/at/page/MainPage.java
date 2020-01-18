package ru.pflb.at.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.pflb.at.page.elements.EventElement;
import ru.pflb.at.page.elements.MainMenu;
import ru.pflb.at.techno.BasePage;
import ru.pflb.at.techno.SWDriver;

public class MainPage extends BasePage {

    public static final Logger LOG = LogManager.getLogger(MainPage.class);

    /**
     * Конструктор класса
     *
     * @param swDriver
     */
    public MainPage(SWDriver swDriver) {
        super(swDriver);
    }

    public SWDriver swDriver;

//    NewEventForm newEventForm = new NewEventForm(swDriver);
//    PhotoWindow photoWindow = new PhotoWindow(swDriver);
//    MusicWindow musicWindow = new MusicWindow(swDriver);

    public EventElement getEventByIndex(int index) {
        WebElement eventElement = getWebDriver().findElement(By.xpath("//div[@id='history_container']/div[starts-with(@type, 'event:')][" + index + "]"));
        return new EventElement(eventElement, getSwDriver());
    }

    public MainMenu getMainMenu() {
        // ... Поиск корневого элемента для MainMenu
        return new MainMenu(swDriver, rootElement);
    }


}
