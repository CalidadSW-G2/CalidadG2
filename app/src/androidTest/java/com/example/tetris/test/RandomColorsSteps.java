package com.example.tetris.test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import com.example.tetris.Tablero;
import com.example.tetris.ColoresActivity;

import org.junit.Assert;

public class RandomColorsSteps {


    @Given("^squareIsRed$")
    public void squareisred() {
        Tablero.setColorCuadrado(7);
    }

    @When("^RandomButtonIsSelected$")
    public void randombuttonisselected() {
        Tablero.setColorCuadrado(ColoresActivity.randomColor(Tablero.getColorCuadrado()));
    }

    @Then("^SquareCanBeAnythingButRed$")
    public void redcanbeanythingbutred() {
        Assert.assertTrue(Tablero.getColorCuadrado() != 7);
    }

}