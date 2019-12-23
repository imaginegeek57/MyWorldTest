package ru.pflb.at.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.pflb.at.techno.BasePage;
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
    private WebElement buttonMail;

    /**
     * Кнопка "Написать письмо"
     */
    @FindBy(xpath = "//span/span[@class='compose-button__wrapper']")
    private WebElement buttonNewMail;

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
    @FindBy(css = "div.cke_editable")
    private WebElement mailBody;

    /**
     * Кнопка "Отправить"
     */
    @FindBy(xpath = "//span[@class='button2 button2_base button2_primary button2_hover-support js-shortcut']/span")
    private WebElement buttonSent;

    /**
     * Ожидающий осьминог
     */
    @FindBy(id = "app-loader")
    private WebElement appLoader;

    /**
     * Жмем кнопку 'Почта'
     */
    public MailPage enterMail() {
        buttonMail.click();
        new WebDriverWait(getWebDriver(), 60)
                .until(ExpectedConditions.invisibilityOf(appLoader));
        screenshot();
        return this;
    }

    /**
     * Жмем кнопку 'Написать письмо'
     */
    public MailPage newMail() {
        buttonNewMail.click();
        screenshot();
        return this;
    }

    /**
     * Вводим кому пишем
     */
    public MailPage mailToUser(String addres) {
        mailToUser.sendKeys(addres);
        LOG.info("В поле 'Кому' записано: {}", addres);
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
    public MailPage letterBody(String text) {
        mailBody.sendKeys(text);
        LOG.info("В поле 'Письма' записано: {}", text);
        return this;
    }

    /**
     * Жмем кнопку 'Отправить письмо'
     */
    public MailPage sentTo() {
        screenshot();
        buttonSent.click();
        LOG.info("Пиьмо отправлено");
        return this;
    }

    public MailPage open() {
        openPage(url);
        return this;
    }

}
