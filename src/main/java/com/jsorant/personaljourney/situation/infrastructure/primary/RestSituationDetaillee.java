package com.jsorant.personaljourney.situation.infrastructure.primary;

import com.jsorant.personaljourney.situation.domain.Situation;
import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(name = "SituationDetaillée", description = "Détail d'une situation difficile")
public record RestSituationDetaillee(
        @Schema(requiredMode = REQUIRED) String id,
        @Schema(requiredMode = REQUIRED) String dateCreation
) {
    public static RestSituationDetaillee from(Situation situation) {
        return new RestSituationDetaillee(situation.id().value(), situation.dateCreation().toString());
    }
}
