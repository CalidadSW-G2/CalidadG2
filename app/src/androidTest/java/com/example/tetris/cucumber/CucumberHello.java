package com.example.tetris.cucumber;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CucumberHello {
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
