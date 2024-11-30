package com.jsorant.personaljourney.situation.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import static com.jsorant.personaljourney.cucumber.rest.CucumberRestAssertions.assertThatLastAsyncResponse;

public class SituationSteps {
  @When("Je déclare une nouvelle situation difficile le {string}")
  public void jeDeclareUneNouvelleSituationDifficileLe(String date) {
    // TODO REST CALL
  }

  @Then("La liste de mes situation difficiles est")
  public void laListeDeMesSituationDifficilesEst(Map<String, String> liste) {
    // TODO REST CALL
    assertThatLastAsyncResponse().hasOkStatus().hasResponse().containing(liste);
  }
}
