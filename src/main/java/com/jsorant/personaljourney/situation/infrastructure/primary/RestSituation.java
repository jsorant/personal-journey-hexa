package com.jsorant.personaljourney.situation.infrastructure.primary;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(name = "Situation", description = "Aperçu d'une situation difficile")
public record RestSituation(
  @Schema(requiredMode = REQUIRED) String id,
  @Schema(requiredMode = REQUIRED) String dateCreation
) {
}
