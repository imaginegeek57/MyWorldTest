package ru.pflb.at.techno;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseElement {
    public static final Logger LOG = LogManager.getLogger(BaseElement.class);

    private SWDriver swDriver;
    private WebElement rootElement;

    /**
     * Конструктор класса
     */
    protected BaseElement(WebElement rootElement, SWDriver swDriver) {
        this.rootElement = rootElement;
        this.swDriver = swDriver;
    }

    protected SWDriver getSwDriver() {
        return swDriver;
    }

    protected WebDriver getWebDriver() {
        return getSwDriver().getDriver();
    }

    public void screenshot() {
        getSwDriver().screenshot();
    }

    public WebDriverWait webWait(long timeOutInSeconds) {
        return new WebDriverWait(getWebDriver(), timeOutInSeconds);
    }

    public WebElement getRoot() {
        return rootElement;
    }
}
