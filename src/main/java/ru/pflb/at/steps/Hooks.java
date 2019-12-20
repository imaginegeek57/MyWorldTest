package ru.pflb.at.steps;

import io.cucumber.java8.En;
import ru.pflb.at.techno.SWDriver;

public class Hooks implements En {
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
