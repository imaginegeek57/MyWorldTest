package ru.pflb.at.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//TODO add time for wait publish


@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "ru.pflb.at.steps",
        features = "src/main/resources/features",
        tags = {"@LoginError"})
public class RunCucumberTest {

}