package com.jsorant.personaljourney.situation.infrastructure.primary;

import com.jsorant.personaljourney.situation.domain.Situation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

import java.util.List;

@Schema(name = "SituationsDifficiles", description = "Liste des situations difficiles")
public record RestSituationsDifficiles(
  @Schema(requiredMode = RequiredMode.REQUIRED) List<RestSituationDifficileApercu> situations) {
  public static RestSituationsDifficiles from(List<Situation> liste) {
    return new RestSituationsDifficiles(
      liste.stream().map(RestSituationsDifficiles::from).toList()
    );
  }

  private static RestSituationDifficileApercu from(Situation situation) {
    return new RestSituationDifficileApercu(situation.id().value(), situation.dateCreation().toString());
  }
}
