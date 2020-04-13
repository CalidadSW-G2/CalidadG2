package com.example.tetris.test;

import com.example.tetris.Juego;
import com.example.tetris.MainActivity;
import com.example.tetris.Pieza;
import com.example.tetris.Tablero;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JuegoIntegrationTest {

    Tablero tablero;
    Juego juego;
    MainActivity ma;
    Pieza pieza;

    /* First and second scenario*/

    @Given("^Tablero class generates all the pieces$")
    public void setupTablero() {
        tablero = new Tablero();
    }

    @When("^Juego class creates two more pieces$")
    public void setupJuegoIncremented() {
        juego = new Juego(null,tablero,null,0,null);
        juego.getTablero().generarPieza(1);
        juego.getTablero().generarPieza(2);
    }

    @When("^Juego class removes a piece$")
    public void setupJuegoDecremented() {
        juego = new Juego(null,tablero,null,0,null);
        juego.getTablero().borrarPieza();
    }

    @Then("^Tablero and Juego should have the same number of pieces$")
    public void checkIncrementPieces() {
        Assert.assertEquals(tablero.getListaPiezas().size(),juego.getListaPiezas().size());
    }

    /* Third scenario */

    @Given("^Tablero generates a new piece$")
    public void tableroGeneratesNewPiece(){
        tablero = new Tablero();
        tablero.generarPieza(5);
    }

    @When("^Tablero deletes the new created piece$")
    public void tableroDeletesThatPiece(){
        int index = tablero.getListaPiezas().size()-1;
        pieza = tablero.getListaPiezas().get(index);
        tablero.borrarPieza(pieza);
        tablero.getListaPiezas().remove(pieza);
        Juego juego = new Juego(null,tablero,null,0,null);
    }

    @Then("^Juego should not have that piece$")
    public void checkNotSpecificPieceInJuego(){
        Assert.assertEquals(juego.getListaPiezas().contains(pieza),false);
    }

    /* Fourth and fifth Scenario*/

    @Given("^MainActivity class generates Juego$")
    public void setupMainActivity(){
        ma = new MainActivity();
    }

    @When("^Juego changes player points$")
    public void changeMainActivityPoints(){
        Juego.setPuntos(100);
    }

    @Then("^Juego in MainActivity class should have 100 points$")
    public void checkIncrementPoints(){
        Assert.assertEquals(ma.getPuntosInt(),100);
    }

    @Then("^MainActivity and Juego gamemode should be the same$")
    public void checkGamemode(){
        Assert.assertEquals(ma.getModo(),Juego.getModo());
    }

}
