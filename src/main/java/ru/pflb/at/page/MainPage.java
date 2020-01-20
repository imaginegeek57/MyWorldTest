package ru.pflb.at.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.pflb.at.page.elements.NewEventForm;
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

    /**
     * Работа с методами класса 'NewEventForm'
     *
     * @return
     */
    public NewEventForm getNewEventForm() {
        WebElement newEventFormRoot = getWebDriver().findElement(By.xpath("//div[@data-mru-fragment='publisher']"));
        screenshot();
        return new NewEventForm(newEventFormRoot, getSwDriver());
    }


}
