package com.example.tetris.test;

import com.example.tetris.Juego;
import com.example.tetris.Tablero;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CheckPiecesTest {

    Tablero tablero;
    Juego juego;

    @Given("^setupTablero$")
    public void setupTablero() {
        tablero = new Tablero();
        tablero.generarPieza(1);
        tablero.generarPieza(2);
    }

    @When("^setupJuego$")
    public void setupJuego() {
        juego = new Juego(null,tablero,null,0,null);
    }

    @Then("^checkIncrementPieces$")
    public void checkIncrementPieces() {
        Assert.assertEquals(tablero.getListaPiezas().size(),juego.getListaPiezas().size());
    }

}
