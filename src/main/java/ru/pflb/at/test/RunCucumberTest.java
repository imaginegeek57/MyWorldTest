package ru.pflb.at.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "ru.pflb.at.steps",
        features = "src/main/resources/features",
        tags = {"@PostMusic"})
public class RunCucumberTest {

}