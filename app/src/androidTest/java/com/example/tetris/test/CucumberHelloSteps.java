package com.example.tetris.test;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class CucumberHelloSteps {
    @Given("^Nothing$")
    public void nothing() {
    }

    @When("^NothingAgain$")
    public void nothingagain() {
    }

    @Then("^Hello$")
    public void hello() {
        Assert.assertTrue(true);
    }
}
