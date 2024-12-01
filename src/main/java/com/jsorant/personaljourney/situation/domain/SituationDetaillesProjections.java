package com.jsorant.personaljourney.situation.domain;

import org.jmolecules.architecture.hexagonal.Port;

import java.time.Instant;
import java.util.Optional;

@Port
public interface SituationDetaillesProjections {
  Optional<Situation> pour(SituationId situationId);

  void ajouter(SituationId id, Instant dateCreation);
}
