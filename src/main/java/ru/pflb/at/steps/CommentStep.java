package ru.pflb.at.steps;

import io.cucumber.java8.En;
import ru.pflb.at.page.LoginHomePage;
import ru.pflb.at.page.MainPage;
import ru.pflb.at.techno.SWDriver;
import ru.pflb.at.techno.UserProperties;
import ru.pflb.at.techno.webConfig.WebConfig;

import static org.hamcrest.Matchers.equalTo;

public class CommentStep implements En {

    public WebConfig webConfig;
    public UserProperties userProperties;
    public SWDriver swDriver;
    public LoginHomePage loginHomePage;
    public MainPage mainPage;

    public CommentStep() {
        webConfig = new WebConfig();
        userProperties = new UserProperties();
        swDriver = SWDriver.getInstance();
        loginHomePage = new LoginHomePage(swDriver);
        mainPage = new MainPage(swDriver);

        Given("I write new comment: {string}", (String text) -> {
            mainPage.getHistoryEvent()
                    .writeComment(text);
        });

        And("I put random smile", () -> {
            mainPage.getHistoryEvent()
                    .putRandomSmile();
        });

        When("I click button sent", () -> {
            mainPage.getHistoryEvent()
                    .clickSent();
        });

        Then("Check that text of comment and smile equals my last comment: {string}", (String text) -> {
            mainPage.getHistoryEvent()
                    .checkComments(equalTo(text));
        });
    }
}
