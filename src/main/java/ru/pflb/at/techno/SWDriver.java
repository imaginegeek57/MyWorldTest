package ru.pflb.at.techno;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SWDriver {

    public static final Logger LOG = LogManager.getLogger(SWDriver.class);

    /**
     * Единственный экземпляр класса
     */
    private static SWDriver instance;

    /**
     * Получение экземпляра класса
     *
     * @return экземпляр класса
     */
    public static SWDriver getInstance() {
        if (instance == null) {
            instance = new SWDriver();
        }
        return instance;
    }

    /**
     * Вебдрайвер
     */
    private WebDriver driver;

    /**
     * Получить драйвер
     *
     * @return драйвер
     */
    public WebDriver getDriver() {
        return driver;
    }

    private SWDriver() {
        System.setProperty("webdriver.chrome.driver", SWDriver.class.getResource("/webdrivers/chromedriver.exe").getPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void screenshot() {
        try {
            File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyToDirectory(screenshot, new File("screenshots/"));
            LOG.debug("screenshot has done");
        } catch (IOException e) {
        }
    }

    /**
     * Метод для закрытия
     */
    public void close() {
        if (getDriver() == null)
            return;
        try {
            LOG.debug("Закрытие браузера");
            getDriver().quit();
        } catch (Throwable throwable) {
        }
    }

}
