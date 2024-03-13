package com.booking.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:target/build/cucumber.json"},
            features = {"src/test/resources"},
            glue = {"com.booking.steps.booking"},
            tags = "@Regression"
)

public class RunnerTest {
}
