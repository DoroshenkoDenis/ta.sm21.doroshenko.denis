package com.nc.edu.ta.doroshenkodenis.steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/com/nc/edu/ta/doroshenkodenis/features"},
        glue = {"com/nc/edu/ta/doroshenkodenis/steps"}, plugin = {"pretty"})
public class RunCucumberTest {
}
