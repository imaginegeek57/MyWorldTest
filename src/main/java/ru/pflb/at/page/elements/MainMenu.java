package ru.pflb.at.page.elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import ru.pflb.at.techno.SWDriver;

public class MainMenu {

    public static final Logger LOG = LogManager.getLogger(MainMenu.class);

    protected WebElement rootElement;
    protected SWDriver swDriver;

    public MainMenu(WebElement rootElement, SWDriver swDriver) {
        this.rootElement = rootElement;
        this.swDriver = swDriver;
    }

    /**
     * Выбираем строкчку меню
     * feed - Лента
     * friends - Друзья
     * photo - Фото
     * video - Видео
     * music - Музыка
     *
     * @return
     */
//    public MainMenu getMainMenuItem(String item) {
//        WebElement element = getWebDriver().findElement(By.xpath("//ul[@class='b-left-menu__items']/li[@data-id='" + item + "']"));
//        LOG.info("Выбрана строчка меню: {}", item);
//        screenshot();
//        return new MainMenu(element, getSwDriver());
//    }
    public void clickFriends() {

    }

    public void clickMusic() {

    }

}
