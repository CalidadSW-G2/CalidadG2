package com.example.tetris.test;

import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.example.tetris.Juego;

public class TenSongsSteps {

    public static int numCanciones = 0;

    @Given("^VersionFinalDelJuego$")
    public void versionfinaldeljuego()  {
        //Esta Historia de Usuario se puede testear en tiempo de compilacion
        //Por version final del juego se entiende al codigo que esta listo para pasar a produccion
        //O al menos a pre produccion
    }

    @When("^ComprueboCuantasCanciones$")
    public void compruebocuantascanciones() {
        numCanciones = Juego.getNumberOfSongs();
    }

        @Then("^HayAlMenosDiez$")
    public void hayalmenosdiez() {
        Assert.assertTrue(numCanciones >= 10);
    }
}
