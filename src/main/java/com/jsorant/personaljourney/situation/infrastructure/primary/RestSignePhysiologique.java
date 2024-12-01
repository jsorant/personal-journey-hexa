package com.jsorant.personaljourney.situation.infrastructure.primary;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "SignePhysiologique", description = "Les signes physiologiques possibles")
public enum RestSignePhysiologique {
    NAUSEE,
    DOULEURS
}
