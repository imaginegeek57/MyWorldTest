package ru.pflb.at.page;

import org.hamcrest.Matcher;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.pflb.at.techno.SWDriver;
import ru.pflb.at.techno.UserProperties;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginHomePage extends BasePage {

    /**
     * Мой мир 'url'
     */
    private static String url = "https://my.mail.ru/";

    /**
     * Конструктор класса
     *
     * @param swDriver
     */
    public LoginHomePage(SWDriver swDriver) {
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
     * Локатор ошибки "Неправильное имя пользователя или пароль"
     */
    @FindBy(xpath = "//div[text()='Неправильное имя пользователя или пароль']")
    private WebElement registrationError;


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
        screenshot();
        return this;
    }

    /**
     * Открытие веб-страницы 'Мой мир'
     */
    public LoginHomePage open() {
        openPage(url);
        return this;
    }


    //div[text()='Неправильное имя пользователя или пароль']

    /**
     * Авторизация
     *
     * @param userProperties параметры для входа
     */
    public LoginHomePage login(UserProperties userProperties) {
        return this
                .open()
                .checkLogin(userProperties.getLogin())
                .checkPassword(userProperties.getPassword())
                .enter();
    }

    public String getErrorMessage() {
        return registrationError.getText();
    }

    public LoginHomePage assertThatErrorMessage(Matcher <String> matcher) {
        assertThat("Сообщение об ошибке не удовлетворяет условию", getErrorMessage(), matcher);
        return this;
    }
}
