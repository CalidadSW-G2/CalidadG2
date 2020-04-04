package com.example.tetris.test;

import org.junit.Assert;
import com.example.tetris.Juego;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ChangeMusicLatencySteps {

    @Given("^musicThatChangesEvery20$")
    public void musicthatchangesevery20() { Juego.setLatency(20); }

    @Given("^musicThatChangesEvery10$")
    public void musicthatchangesevery10() { Juego.setLatency(10); }

    @When("^changeEvery10isSelected$")
    public void changeevery10isselected() {
        //sencond10 = findViewById(R.id.second10);
        //sencond10.setOnClickListener(new View.OnClickListener() {
            //@Override public void onClick(View v) {
                Juego.setLatency(10);
                //Toast.makeText(getApplicationContext(), "Has cambiado la musica a un
        // intervalo de 10 segundos", Toast.LENGTH_SHORT).show(); }
        //}); FUNCION IDENTICA A LA DE MAIN ACTIVITY
    }
    @When("^changeEvery20isSelected$")
    public void changeevery20isselected() {
        //sencond20 = findViewById(R.id.second20);
        //sencond20.setOnClickListener(new View.OnClickListener() {
            //@Override public void onClick(View v) {
                Juego.setLatency(20);
                //Toast.makeText(getApplicationContext(), "Has cambiado la musica a un
        // intervalo de 20 segundos", Toast.LENGTH_SHORT).show(); }
        //}); FUNCION IDENTICA A LA DE MAIN ACTIVITY
    }

    @Then("^musicChangesEvery10$")
    public void musicchangesevery10() { Assert.assertEquals(Juego.getLatency(), 10); }

    @Then("^musicChangesEvery20$")
    public void musicchangesevery20() { Assert.assertEquals(Juego.getLatency(), 20); }
}
