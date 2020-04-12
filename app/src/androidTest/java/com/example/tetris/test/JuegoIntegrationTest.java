package com.example.tetris.test;

import com.example.tetris.Juego;
import com.example.tetris.MainActivity;
import com.example.tetris.Tablero;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JuegoIntegrationTest {

    Tablero tablero;
    Juego juego;
    MainActivity ma;

    @Given("^Tablero class generates all the pieces$")
    public void setupTablero() {
        tablero = new Tablero();
    }

    @When("^Juego class creates two more pieces$")
    public void setupJuego() {
        juego = new Juego(null,tablero,null,0,null);
        juego.getTablero().generarPieza(1);
        juego.getTablero().generarPieza(2);
    }

    @Then("^Tablero and Juego should have the same number of pieces$")
    public void checkIncrementPieces() {
        Assert.assertEquals(tablero.getListaPiezas().size(),juego.getListaPiezas().size());
    }

    @Given("^MainActivity class generates Juego with 0 points$")
    public void setupMainActivity(){
        MainActivity ma = new MainActivity();
    }

    @When("^Juego changes player points$")
    public void changeMainActivityPoints(){
        Juego.setPuntos(100);
    }

    @Then("^Juego in MainActivity class should have 100 points$")
    public void checkIncrementPoints(){
        Assert.assertEquals(ma.getJuego().getPuntos(),100);
    }

}
