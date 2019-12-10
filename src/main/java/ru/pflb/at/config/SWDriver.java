package ru.pflb.at.config; // TODO Package config не очень подходит для менеджера драйвера

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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
}
