package com.jsorant.personaljourney.situation.steps;

import com.jsorant.personaljourney.cucumber.rest.CucumberRestTemplate;
import com.jsorant.personaljourney.shared.date.infrastructure.secondary.FakeDateProvider;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import static com.jsorant.personaljourney.cucumber.rest.CucumberRestAssertions.assertThatLastAsyncResponse;

public class SituationSteps {
  private final CucumberRestTemplate rest;
  private final FakeDateProvider fakeDateProvider;

  public SituationSteps(CucumberRestTemplate rest, FakeDateProvider fakeDateProvider) {
    this.rest = rest;
    this.fakeDateProvider = fakeDateProvider;
  }

  @When("Je déclare une nouvelle situation difficile le {string}")
  public void jeDeclareUneNouvelleSituationDifficileLe(String date) {
    fakeDateProvider.setNow(Instant.parse(date));
    rest.post("/api/situation", "{}");
    assertThatLastAsyncResponse().hasOkStatus();
  }

  @Then("La liste de mes situation difficiles est")
  public void laListeDeMesSituationDifficilesEst(List<Map<String, String>> expectedSituations) {
    rest.get("/api/situation");
    assertThatLastAsyncResponse().hasOkStatus()
      .hasElement("$.situations").containingExactly(expectedSituations);
  }

  @Then("La situation {string} est à l'étape {string}")
  public void laSituationEstALEtape(String id, String etape) {
    rest.get("/api/situation/" + id + "/etape");
    assertThatLastAsyncResponse().hasOkStatus()
      .hasResponse().withValue(etape);
  }
}
