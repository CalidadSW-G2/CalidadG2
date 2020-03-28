package com.example.tetris;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="/features", glue="")
public class Prueba {

    @Given("^Nothing$")
    public void nothing()  {
    }

    @When("^NothingAgain$")
    public void nothingagain() {
    }

    @Then("^Hello$")
    public void hello() {
        Assert.assertTrue(true);
    }
}
