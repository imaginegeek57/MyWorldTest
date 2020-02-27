package ru.pflb.at.steps;

import io.cucumber.java8.En;
import ru.pflb.at.page.LoginHomePage;
import ru.pflb.at.techno.SWDriver;
import ru.pflb.at.techno.UserProperties;
import ru.pflb.at.techno.webConfig.WebConfig;

import static org.hamcrest.Matchers.equalTo;

public class LoginStep implements En {

    public WebConfig webConfig;
    public UserProperties userProperties;
    public SWDriver swDriver;
    public LoginHomePage loginHomePage;

    public LoginStep() {
        webConfig = new WebConfig();
        userProperties = new UserProperties();
        swDriver = SWDriver.getInstance();
        loginHomePage = new LoginHomePage(swDriver);

        Given("I do authorization to email", () -> {
            loginHomePage.login(webConfig, userProperties);
            loginHomePage.closeAdvert();
        });

        Then("I check authorization my email", () -> {
            loginHomePage.assertThatCurrentUserMail(equalTo(userProperties.getMail()));
        });

        And("Click button 'EXIT'", () -> {
            loginHomePage.clickExit();
        });

        And("Check correct exit from account", () -> {
            loginHomePage.checkCorrectExit();
        });

        Given("Write correct login to account", () -> {
            loginHomePage.goToWebPage(webConfig.getUrl())
                    .writeLogin(userProperties.getLogin());
        });

        And("Write random characters to password: {string}", (String text) -> {
            loginHomePage.writePassword(text);
        });

        And("Click button 'ENTER'", () -> {
            loginHomePage.clickEnter();
        });

        Then("Page has string about error", () -> {
            loginHomePage
                    .assertThatErrorMessage(equalTo("Неправильное имя пользователя или пароль"));
        });
    }
}