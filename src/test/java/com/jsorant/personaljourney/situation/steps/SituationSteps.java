package com.jsorant.personaljourney.situation.steps;

import com.jsorant.personaljourney.cucumber.rest.CucumberRestTemplate;
import com.jsorant.personaljourney.shared.date.infrastructure.secondary.FakeDateProvider;
import com.jsorant.personaljourney.situation.infrastructure.secondary.InMemoryEtapeSituationProjections;
import com.jsorant.personaljourney.situation.infrastructure.secondary.InMemorySituationDetaillesProjections;
import com.jsorant.personaljourney.situation.infrastructure.secondary.InMemorySituationRepository;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import static com.jsorant.personaljourney.cucumber.rest.CucumberRestAssertions.assertThatLastAsyncResponse;

public class SituationSteps {
  private final CucumberRestTemplate rest;
  private final FakeDateProvider fakeDateProvider;
  private final InMemoryEtapeSituationProjections etapesSituationsProjections;
  private final InMemorySituationDetaillesProjections situationsDetaillesProjections;
  private final InMemorySituationRepository situationsRepository;

  public SituationSteps(CucumberRestTemplate rest, FakeDateProvider fakeDateProvider, InMemoryEtapeSituationProjections etapesSituationsProjections, InMemorySituationDetaillesProjections situationsDetaillesProjections, InMemorySituationRepository situationsRepository) {
    this.rest = rest;
    this.fakeDateProvider = fakeDateProvider;
    this.etapesSituationsProjections = etapesSituationsProjections;
    this.situationsDetaillesProjections = situationsDetaillesProjections;
    this.situationsRepository = situationsRepository;
  }

  @Before
  public void before() {
    etapesSituationsProjections.clear();
    situationsDetaillesProjections.clear();
    situationsRepository.clear();
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

  @Then("Le détail de la situation {string} est")
  public void leDetailDeLaSituationEst(String id, Map<String, String> expectedSituation) {
    rest.get("/api/situation/" + id);
    assertThatLastAsyncResponse().hasOkStatus()
      .hasResponse().withValue(expectedSituation);
  }

  @Then("La récupération du détail de la situation {string} échoue car elle n'existe pas")
  public void laRecuperationDuDetailDeLaSituationEchoueCarElleNExistePas(String id) {
    rest.get("/api/situation/" + id);
    assertThatLastAsyncResponse().hasHttpStatus(HttpStatus.NOT_FOUND);
  }

  @Then("La récupération de l{string}existe pas")
  public void laRecuperationDeLEtapeDeLaSituationEchoueCarElleNExistePas(String id) {
    rest.get("/api/situation/" + id + "/etape");
    assertThatLastAsyncResponse().hasHttpStatus(HttpStatus.NOT_FOUND);
  }

  @When("Je définis les signes physiologiques de la situation {string} avec")
  public void jeDefinisLesSignesPhysiologiquesDeLaSituationAvec(String id, List<String> signesPhysiologiques) {
    List<String> decoratedSignesPhysiologiques = signesPhysiologiques.stream().map(s -> "\"" + s + "\"").toList();
    String signesListAsString = String.join(",", decoratedSignesPhysiologiques);
    rest.post("/api/situation/" + id + "/signes-physiologiques", "{ \"signesPhysiologiques\": [%s] }"
      .formatted(signesListAsString));
    assertThatLastAsyncResponse().hasOkStatus();
  }
}
