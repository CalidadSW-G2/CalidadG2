package com.example.tetris.test;

import com.example.tetris.Juego;
import com.example.tetris.MainActivity;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.Main;

public class CheckPointsTest {

    MainActivity ma;

    @Given("^setupMainActivity$")
    public void setupMainActivity(){
        MainActivity ma = new MainActivity();
    }

    @When("^changeMainActivityPoints$")
    public void changeMainActivityPoints(){
        Juego.setPuntos(100);
    }

    @Then("^checkIncrementPoints$")
    public void checkIncrementPoints(){
        Assert.assertEquals(ma.getJuego().getPuntos(),100);
    }

}
