package ru.pflb.at.techno;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static ru.pflb.at.page.BasePage.LOG;

public class SWDriver {

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

    /**
     * работа с ожиданиями
     */
    public static WebDriverWait wait;

    private SWDriver() {
        System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10, 250);
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
        if (getDriver() == null) return;
        try {
            LOG.debug("Закрытие браузера");
            getDriver().quit();
        } catch (Throwable throwable) {
        }
    }

}
