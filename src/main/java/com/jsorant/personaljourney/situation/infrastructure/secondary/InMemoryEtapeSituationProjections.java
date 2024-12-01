package com.jsorant.personaljourney.situation.infrastructure.secondary;

import com.jsorant.personaljourney.situation.domain.Etape;
import com.jsorant.personaljourney.situation.domain.EtapeSituationProjections;
import com.jsorant.personaljourney.situation.domain.SituationId;
import org.jmolecules.ddd.annotation.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
@org.springframework.stereotype.Repository
public class InMemoryEtapeSituationProjections implements EtapeSituationProjections {
  private final Map<SituationId, Etape> etapes = new HashMap<>();

  @Override
  public Optional<Etape> pour(SituationId situationId) {
    return Optional.ofNullable(etapes.get(situationId));
  }

  @Override
  public void definir(SituationId id, Etape etape) {
    etapes.put(id, etape);
  }

  public void clear() {
    etapes.clear();
  }
}
