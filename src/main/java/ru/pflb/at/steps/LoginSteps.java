package ru.pflb.at.steps;

import io.cucumber.java8.En;
import ru.pflb.at.page.LoginHomePage;
import ru.pflb.at.techno.SWDriver;
import ru.pflb.at.techno.UserProperties;

import static org.hamcrest.Matchers.equalTo;

public class LoginSteps implements En {

    public UserProperties userProperties;
    public SWDriver swDriver;
    public LoginHomePage loginHomePage;

    public LoginSteps() {
        userProperties = new UserProperties();
        swDriver = SWDriver.getInstance();
        loginHomePage = new LoginHomePage(swDriver);

        Given("I open the login page", () -> {
            loginHomePage.open();
        });

        When("I write login", () -> {
            loginHomePage.checkLogin(userProperties.getLogin());
        });

        And("I write password", () -> {
            loginHomePage.checkPassword(userProperties.getPassword());
        });

        And("I enter the site", () -> {
            loginHomePage.enter();
        });

        Then("I check my Email", () -> {
            loginHomePage.assertThatCurrentUserMail(equalTo(userProperties.getMail()));
        });
    }
}
