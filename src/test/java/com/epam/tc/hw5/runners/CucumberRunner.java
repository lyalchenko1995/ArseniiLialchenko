package com.epam.tc.hw5.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com.epam.tc.hw5.steps"}
)

public class CucumberRunner extends AbstractTestNGCucumberTests {
}
