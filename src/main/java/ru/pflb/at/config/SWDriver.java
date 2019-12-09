package ru.pflb.at.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SWDriver {

    private static final Logger LOG = LogManager.getLogger(SWDriver.class);

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
     * Вебдрайвер для хрома
     */
    private ChromeDriver chromeDriver;

    /**
     * работа с ожиданиями
     */
    public WebDriverWait wait;

    private SWDriver() {
        System.setProperty("webdriver.chrome.chromeDriver", "bin/chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        wait = new WebDriverWait(chromeDriver, 10, 250);
    }

}
