package com.jsorant.personaljourney.situation.domain;

import org.jmolecules.architecture.hexagonal.Port;

import java.util.List;

@Port
public interface SituationRepository {
  List<Situation> getAll();

  SituationId prochainId();

  void save(Situation situation);
}
