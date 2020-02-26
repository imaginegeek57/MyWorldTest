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

        And("Check correct exit from account", () -> {
            loginHomePage.checkCorrectExit();
        });

        And("Check correct exit from account: {string}", (String text) -> {
            loginHomePage.goToWebPage(webConfig.getUrl())
                    .writeLogin(userProperties.getLogin())
                    .writePassword(text)
                    .clickEnter()
                    .assertThatErrorMessage(equalTo("Неправильное имя пользователя или пароль"));
        });
    }
}
