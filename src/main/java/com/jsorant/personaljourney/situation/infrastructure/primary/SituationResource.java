package com.jsorant.personaljourney.situation.infrastructure.primary;

import com.jsorant.personaljourney.situation.application.SituationApplicationService;
import com.jsorant.personaljourney.situation.domain.Situation;
import com.jsorant.personaljourney.situation.domain.SituationId;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @PostMapping("/{id}/signes-physiologiques")
  @Operation(summary = "Définir les signes physiologiques d'une situation difficile")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Définition réussie"),
  })
  ResponseEntity<Void> definirSignesPhysiologiques(@PathVariable String id, @RequestBody RestSignesPhysiologiques signesPhysiologiques) {
    situations.definirSignesPhysiologiques(new SituationId(id), signesPhysiologiques.toDomain());
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

  @GetMapping("/{id}")
  @Operation(summary = "Récupère le détail d'une situation difficile")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200"),
    @ApiResponse(responseCode = "404", description = "Situation non trouvée"),
  })
  ResponseEntity<RestSituationDetaillee> recupererDetailSituation(@PathVariable String id) {
    return situations.recupererDetailSituation(new SituationId(id))
      .map(situation -> ResponseEntity.ok(RestSituationDetaillee.from(situation)))
      .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping("/{id}/etape")
  @Operation(summary = "Récupère l'étape actuelle de la situation")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200"),
    @ApiResponse(responseCode = "404", description = "Situation non trouvée"),
  })
  ResponseEntity<RestEtape> recupererSituations(@PathVariable String id) {
    return situations.etapePour(new SituationId(id))
      .map(etape -> ResponseEntity.ok(RestEtape.from(etape)))
      .orElseGet(() -> ResponseEntity.notFound().build());
  }
}
