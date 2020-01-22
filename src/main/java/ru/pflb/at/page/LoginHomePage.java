package ru.pflb.at.page;

import org.hamcrest.Matcher;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.pflb.at.techno.BasePage;
import ru.pflb.at.techno.SWDriver;
import ru.pflb.at.techno.UserProperties;
import ru.pflb.at.techno.jsonParser.JacksonParser;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginHomePage extends BasePage {

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
     * Кнопка "Закрыть рекламу"
     */
    @FindBy(xpath = "//div[@class='b-popup__header__close icon-crumbs_delete-album icon-crumbs_delete-album']")
    private WebElement buttonCloseAd;

    /**
     * Почта пользователя
     */
    @FindBy(id = "PH_user-email")
    private WebElement currentUserMail;

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
     * Переход на веб-страницу
     *
     * @param url адрес
     */
    public LoginHomePage openPage(String url) {
        LOG.info("Переход на веб-страницу: " + url);
        getSwDriver().getDriver().get(url);
        return this;
    }

    /**
     * Авторизация
     *
     * @param userProperties параметры для входа
     */
    public LoginHomePage login(JacksonParser jackson, UserProperties userProperties) {
        return this
                .openPage(jackson.get_Url())
                .checkLogin(userProperties.getLogin())
                .checkPassword(userProperties.getPassword())
                .enter();
    }

    /**
     * Жмем кнопку 'Закрыть рекламу'
     */
    public LoginHomePage closeAdvert() {
        buttonCloseAd.click();
        LOG.info("Реклама закрыта");
        screenshot();
        return this;
    }

    public String getErrorMessage() {
        return registrationError.getText();
    }

    public String getCurrentUserMail() {
        return currentUserMail.getText();
    }

    public LoginHomePage assertThatErrorMessage(Matcher <String> matcher) {
        LOG.info("Проверка сообщения об ошибке при авторизации");
        assertThat("Сообщение об ошибке не удовлетворяет условию", getErrorMessage(), matcher);
        return this;
    }

    /**
     * Проверка что почта текущего пользователя соответствует условию
     *
     * @param matcher условию
     */
    public LoginHomePage assertThatCurrentUserMail(Matcher <String> matcher) {
        LOG.info("Проверка что почта текущего пользователя удовлетворяет условию: {}", matcher);
        assertThat("Отображаемая почта текущего пользователя не соответствует условию", getCurrentUserMail(), matcher);
        return this;
    }
}
