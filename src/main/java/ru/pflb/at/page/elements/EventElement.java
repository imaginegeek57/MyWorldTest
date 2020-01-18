package ru.pflb.at.page.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.pflb.at.techno.SWDriver;

public class EventElement {

    protected WebElement rootElement;
    private SWDriver swDriver;

    public EventElement(WebElement rootElement, SWDriver swDriver) {
        this.rootElement = rootElement;
        this.swDriver = swDriver;
    }

    public String getText() {
        return rootElement.findElement(By.xpath(".//div[@data-type='text-container']")).getText();
    }

}
