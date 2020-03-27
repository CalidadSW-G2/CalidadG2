package com.example.tetris.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "features"
        ,glue={"CucumberHello"}
)
@RunWith(Cucumber.class)
public class CucumberRunner {

}
