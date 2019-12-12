package ru.pflb.at.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.pflb.at.techno.SWDriver;


public class MailPage extends BasePage {

    /**
     * Почта 'url'
     */
    private static String url = "https://my.mail.ru/";

    /**
     * Конструктор класса
     *
     * @param swDriver
     */
    public MailPage(SWDriver swDriver) {
        super(swDriver);
    }

    /**
     * Кнопка "Почта"
     */
    @FindBy(xpath = "//td/a/span[text()='Почта']")
    private WebElement bottonMail;

    /**
     * Кнопка "Написать письмо"
     */
    @FindBy(xpath = "//span/span[@class='compose-button__wrapper']")
    private WebElement bottonNewLetter;

    /**
     * Текстовое поле "кому"
     */
    @FindBy(xpath = "//label/div/div/input[@class='container--H9L5q size_s--3_M-_']")
    private WebElement mailToUser;

    /**
     * Текстовое поле "тема"
     */
    @FindBy(xpath = "//div/div/div/input[@class='container--H9L5q size_s--3_M-_']")
    private WebElement mailSubject;

    /**
     * Текстовое поле "Письмо"
     */
    @FindBy(xpath = "//div[@class='editable-znht cke_editable cke_editable_inline cke_contents_true cke_show_borders']/div/div")
    private WebElement letter;

    /**
     * Кнопка "Отправить"
     */
    @FindBy(xpath = "//span[@class='button2 button2_base button2_primary button2_hover-support js-shortcut']/span")
    private WebElement bottonSent;


    /**
     * Жмем кнопку 'Почта'
     */
    public MailPage enterMail() {
        bottonMail.click();
        screenshot();
        return this;
    }

    /**
     * Вводим кому пишем
     */
    public MailPage mailToUser(String addres) {
        LOG.info("В поле 'Кому' записано: {}", addres);
        mailToUser.sendKeys(addres);
        return this;
    }

    /**
     * Вводим тему письма
     */
    public MailPage mailSubject(String subject) {
        mailSubject.sendKeys(subject);
        LOG.info("В поле 'Тема' записано: {}", subject);
        return this;
    }

    /**
     * Текст письма
     */
    public MailPage letter(String text) {
        letter.sendKeys(text);
        LOG.info("В поле 'Письма' записано: {}", text);
        return this;
    }

    /**
     * Жмем кнопку 'Почта'
     */
    public MailPage sentTo() {
        screenshot();
        bottonSent.click();
        return this;
    }

    public MailPage open() {
        openPage(url);
        return this;
    }

}
