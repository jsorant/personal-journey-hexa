package com.jsorant.personaljourney.situation.infrastructure.primary;

import com.jsorant.personaljourney.situation.domain.Situation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

import java.util.List;

@Schema(name = "Situations", description = "Liste des situations difficiles")
public record RestSituations(
  @Schema(requiredMode = RequiredMode.REQUIRED) List<RestSituation> situations) {
  public static RestSituations from(List<Situation> liste) {
    return new RestSituations(
      liste.stream().map(RestSituations::from).toList()
    );
  }

  private static RestSituation from(Situation situation) {
    return new RestSituation(situation.id().value(), situation.dateCreation().toString());
  }
}
