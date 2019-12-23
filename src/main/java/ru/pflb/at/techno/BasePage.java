package ru.pflb.at.techno;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public static final Logger LOG = LogManager.getLogger(BasePage.class);

    private SWDriver swDriver;

    /**
     * Конструктор класса
     */
    protected BasePage(SWDriver swDriver) {
        this.swDriver = swDriver;
        PageFactory.initElements(getWebDriver(), this);
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

    /**
     * Переход на веб-страницу
     *
     * @param url адрес
     */
    protected void openPage(String url) {
        swDriver.getDriver().get(url);
        LOG.info("Страница " + url + " открыта");
    }

}
