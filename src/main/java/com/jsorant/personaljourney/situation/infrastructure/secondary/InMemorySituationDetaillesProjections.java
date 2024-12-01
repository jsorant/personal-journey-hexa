package com.jsorant.personaljourney.situation.infrastructure.secondary;

import com.jsorant.personaljourney.situation.domain.Situation;
import com.jsorant.personaljourney.situation.domain.SituationDetaillesProjections;
import com.jsorant.personaljourney.situation.domain.SituationId;
import org.jmolecules.ddd.annotation.Repository;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
@org.springframework.stereotype.Repository
public class InMemorySituationDetaillesProjections implements SituationDetaillesProjections {
  private final Map<SituationId, Situation> situations = new HashMap<>();

  @Override
  public Optional<Situation> pour(SituationId situationId) {
    return Optional.ofNullable(situations.get(situationId));
  }

  @Override
  public void ajouter(SituationId id, Instant dateCreation) {
    situations.put(id, new Situation(id, dateCreation));
  }

  public void clear() {
    situations.clear();
  }
}
