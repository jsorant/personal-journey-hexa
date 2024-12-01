package com.jsorant.personaljourney.situation.domain;

import org.jmolecules.architecture.hexagonal.Port;

import java.util.Optional;

@Port
public interface EtapeSituationProjections {
  Optional<Etape> pour(SituationId situationId);

  void definir(SituationId id, Etape etape);
}
