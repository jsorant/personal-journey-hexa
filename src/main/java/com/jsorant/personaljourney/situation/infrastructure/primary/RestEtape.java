package com.jsorant.personaljourney.situation.infrastructure.primary;


import com.jsorant.personaljourney.shared.enumeration.domain.Enums;
import com.jsorant.personaljourney.situation.domain.Etape;

public enum RestEtape {
    DEFINIR_SIGNES_PHYSIOLOGIQUES
    ;

    public static RestEtape from(Etape etape) {
        return Enums.map(etape, RestEtape.class);
    }
}
