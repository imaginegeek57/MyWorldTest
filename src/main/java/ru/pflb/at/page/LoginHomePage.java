package ru.pflb.at.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.pflb.at.config.SWDriver;

public class LoginHomePage extends BasePage {

//    public static LoginHomePage loginHomePage = new LoginHomePage(SWDriver.getInstance());

    /**
     * Конструктор класса
     *
     * @param swDriver
     */
    public LoginHomePage(SWDriver swDriver) {
        super(swDriver);
    }

    /**
     * Открываем
     *
     * @return
     */
    public LoginHomePage open() {
        get("https://my.mail.ru/");
        PageFactory.initElements(getWebDriver(), this);
        return this;
    }

    /**
     * Текстовое поле "логин"
     */
    @FindBy(xpath = "//div/label/input[@name='Login']")
    private WebElement elementLogin;

    /**
     * Текстовое поле "пароль"
     */
    @FindBy(xpath = "//div/label/input[@name='Password']")
    private WebElement elementPassword;

    /**
     * Кнопка "Войти"
     */
    @FindBy(xpath = "//div/input[@class='ui-button-main']")
    private WebElement buttonEnter;


    /**
     * Вводим логин
     */
    public LoginHomePage checkLogin(String login) {
        LOG.info("В поле 'Логин' записать: {}", login);
        elementLogin.sendKeys(login);
        return this;
    }


    /**
     * Вводим пароль
     */
    public LoginHomePage checkPassword(String password) {
        elementPassword.sendKeys(password);
        LOG.info("Пароль заполнен");
        return this;
    }

    /**
     * Жмем кнопку вход
     */
    public LoginHomePage enter() {
        buttonEnter.click();
        return this;
    }
}
