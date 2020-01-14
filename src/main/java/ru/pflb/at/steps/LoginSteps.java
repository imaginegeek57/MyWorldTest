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

        Given("I am authorizing by email", () -> {
            loginHomePage.open(userProperties.getUrl())
                    .checkLogin(userProperties.getLogin())
                    .checkPassword(userProperties.getPassword())
                    .enter()
                    .closeAdvert();
        });


        Then("I check my Email", () -> {
            loginHomePage.assertThatCurrentUserMail(equalTo(userProperties.getMail()));
        });
    }
}
