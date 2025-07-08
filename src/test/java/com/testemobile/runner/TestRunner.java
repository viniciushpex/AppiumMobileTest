package com.testemobile.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.testemobile.steps"},
        plugin = {"pretty", "summary"},
        monochrome = true
)
public class TestRunner {
}