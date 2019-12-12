package ru.pflb.at.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.pflb.at.techno.SWDriver;
import ru.pflb.at.techno.UserProperties;

public class RegistrationPage extends BasePage {

    /**
     * Мой мир 'url'
     */
    private static String url = "https://my.mail.ru/";

    /**
     * Конструктор класса
     *
     * @param swDriver
     */
    public RegistrationPage(SWDriver swDriver) {
        super(swDriver);
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
    public RegistrationPage checkLogin(String login) {
        LOG.info("В поле 'Логин' записать: {}", login);
        elementLogin.sendKeys(login);
        return this;
    }

    /**
     * Вводим пароль
     */
    public RegistrationPage checkPassword(String password) {
        elementPassword.sendKeys(password);
        LOG.info("Пароль заполнен");
        return this;
    }

    /**
     * Жмем кнопку вход
     */
    public RegistrationPage enter() {
        buttonEnter.click();
        screenshot();
        return this;
    }

    /**
     * Открытие веб-страницы 'Мой мир'
     */
    public RegistrationPage open() {
        openPage(url);
        return this;
    }

    /**
     * Авторизация
     *
     * @param userProperties параметры для входа
     */
    public RegistrationPage login(UserProperties userProperties) {
        return this
                .open()
                .checkLogin(userProperties.getLogin())
                .checkPassword(userProperties.getPassword())
                .enter();
    }

    public String getErrorMessage() {

        return "Ошибка";
    }

    public RegistrationPage assertThatErrorMessageIs(String errorMessage) {

        return null;
    }

}
