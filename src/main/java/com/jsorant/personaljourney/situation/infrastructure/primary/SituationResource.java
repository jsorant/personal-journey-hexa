package com.jsorant.personaljourney.situation.infrastructure.primary;

import com.jsorant.personaljourney.situation.application.SituationApplicationService;
import com.jsorant.personaljourney.situation.domain.Situation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Situation")
@RequestMapping("/api/situation")
class SituationResource {

  private final SituationApplicationService situations;

  public SituationResource(SituationApplicationService situations) {
    this.situations = situations;
  }

  @PostMapping()
  @Operation(summary = "Créer une nouvelle situation difficile")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Création réussie"),
  })
  ResponseEntity<Void> creerSituation() {
    situations.creerSituation();
    return ResponseEntity.ok().build();
  }

  @GetMapping()
  @Operation(summary = "Récupère la liste des situations difficiles")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200"),
  })
  ResponseEntity<RestSituations> recupererSituations() {
    List<Situation> liste = situations.recupererSituations();
    return ResponseEntity.ok(RestSituations.from(liste));
  }
}
