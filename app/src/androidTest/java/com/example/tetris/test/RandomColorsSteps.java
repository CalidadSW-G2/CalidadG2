package com.example.tetris.test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import com.example.tetris.Tablero;
import com.example.tetris.ColoresActivity;

import org.junit.Assert;

public class RandomColorsSteps {

    //Color range "Red" 0 , "Pink" 1 , "Light Blue" 2 , "Dark Blue" 3 , "Green" 4 , "Orange" 5 , "Yellow" 6 ,"Random" 7

    @Given("^squareIsRed$")
    public void squareisred() {
        Tablero.setColorCuadrado(7);
    }

    @When("^RandomButtonIsSelected$")
    public void randombuttonisselected() {
        Tablero.setColorCuadrado(ColoresActivity.randomColor(Tablero.getColorCuadrado()));
    }

    @Then("^SquareCanBeAnythingButRed$")
    public void squarecanbeanythingbutred() {
        Assert.assertTrue(Tablero.getColorCuadrado() != 7);
    }

    //RandomColorL , blue
    @Given("^lIsBlue$")
    public void lisblue() {
        Tablero.setColorCuadrado(7);
    }

    //RandonButtonIsSelected

    @Then("^lCanBeAnythingButBlue$")
    public void lcanbeanythingbutblue() {
        Assert.assertTrue(Tablero.getColorCuadrado() != 7);
    }

    //RandomColorZ , Green
    @Given("^zIsGreen$")
    public void zisgreen() {
        Tablero.setColorCuadrado(7);
    }

    @Then("^zCanBeAnythingButGreen$")
    public void zcanbeanythingbutgreen() {
        Assert.assertTrue(Tablero.getColorCuadrado() != 7);
    }

    //RandomColorI , Yellow
    @Given("^iIsYellow$")
    public void iisyellow() {
        Tablero.setColorCuadrado(7);
    }

    @Then("^iCanBeAnythingButYellow$")
    public void icanbeanythingbutyellow() {
        Assert.assertTrue(Tablero.getColorCuadrado() != 7);
    }

    //RandomColorT , Pink
    @Given("^tIsPink$")
    public void tisPink() {
        Tablero.setColorCuadrado(7);
    }

    @Then("^tCanBeAnythingButPink$")
    public void tcanbeanythingbutpink() {
        Assert.assertTrue(Tablero.getColorCuadrado() != 7);
    }

    //RandomColorS , Orange
    @Given("^sIsOrange$")
    public void sisOrange() {
        Tablero.setColorCuadrado(7);
    }

    @Then("^sCanBeAnythingButOrange$")
    public void scanbeanythingbutorange() {
        Assert.assertTrue(Tablero.getColorCuadrado() != 7);
    }


}