package com.nc.edu.ta.doroshenkodenis;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/com/nc/edu/ta/doroshenkodenis/features"},
        glue = {"com/nc/edu/ta/doroshenkodenis/stepdefs"},
        plugin = {"pretty"}
//        , tags = "@ObjectsSearchTest"
)
public class RunCucumberTest {
}
