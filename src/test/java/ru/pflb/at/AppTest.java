package ru.pflb.at;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import ru.pflb.at.config.PageObject;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    private static ChromeDriver chromeDriver;


    @Test
    public void True() {
        chromeDriver.get("https://my.mail.ru/");

        PageObject pageObject = PageFactory.initElements(chromeDriver, PageObject.class);

        pageObject.search("Кот");

        chromeDriver.close();
    }
}
