package ru.pflb.at.steps;

import io.cucumber.java8.En;
import ru.pflb.at.page.LoginHomePage;
import ru.pflb.at.page.MainPage;
import ru.pflb.at.techno.SWDriver;
import ru.pflb.at.techno.UserProperties;
import ru.pflb.at.techno.webConfig.WebConfig;

public class EventStep implements En {

    public WebConfig webConfig;
    public UserProperties userProperties;
    public SWDriver swDriver;
    public LoginHomePage loginHomePage;
    public MainPage mainPage;

    public EventStep() {
        webConfig = new WebConfig();
        userProperties = new UserProperties();
        swDriver = SWDriver.getInstance();
        loginHomePage = new LoginHomePage(swDriver);
        mainPage = new MainPage(swDriver);

        Given("I switch to publications for filter by photo", () -> {
            mainPage.getHistoryEvents()
                    .clickPhoto();
        });

        And("I switch to publications for filter by records", () -> {
            mainPage.getHistoryEvents()
                    .clickRecords();
        });
        Then("Page has only events with photos", () -> {
            mainPage.getHistoryEvents()
                    .checkPhotoFilter();
        });


        And("Page has only events with records", () -> {
            mainPage.getHistoryEvents()
                    .checkRecordFilter();
        });

    }
}
