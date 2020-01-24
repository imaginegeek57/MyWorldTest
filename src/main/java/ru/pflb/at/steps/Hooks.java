package ru.pflb.at.steps;

import io.cucumber.java8.En;
import ru.pflb.at.techno.BaseTest;
import ru.pflb.at.techno.SWDriver;

public class Hooks extends BaseTest implements En {
    public SWDriver swDriver;

    public Hooks() {

        Before(() -> {
            swDriver = SWDriver.getInstance();
        });

        After(() -> {
            swDriver.close();
        });


    }

}
