package ru.pflb.at.page;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.pflb.at.config.SWDriver;

import java.io.File;
import java.io.IOException;

public abstract class BasePage {

    protected static final Logger LOG = LogManager.getLogger(BasePage.class);

    private SWDriver swDriver;

    /**
     * Конструктор класса
     */
    protected BasePage(SWDriver swDriver) {
        this.swDriver = swDriver;
    }

    protected SWDriver getSwDriver() {
        return swDriver;
    }

    protected WebDriver getWebDriver() {
        return getSwDriver().getDriver();
    }

    /**
     * Переход на веб-страницу
     *
     * @param url адрес
     */
    protected void get(String url) {
        swDriver.getDriver().get(url);
    }

    // TODO Данный метод лучше держать в менеджере драйвера

    /**
     * Метод для закрытия
     */
    public void close() {
        swDriver.getDriver().close();
        System.out.println("Закрыл вкладку.");
    }

    // TODO Реализацию данного метода лучше держать в менеджере драйвера
    public BasePage screenshot() {
        try {
            File screenshot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyToDirectory(screenshot, new File("screenshots/"));
            LOG.debug("screenshot has done");
        } catch (IOException e) {
        }
        return this;
    }


}
