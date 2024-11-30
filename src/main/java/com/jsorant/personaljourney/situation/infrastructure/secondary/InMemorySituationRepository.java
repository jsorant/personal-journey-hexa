package com.jsorant.personaljourney.situation.infrastructure.secondary;

import com.jsorant.personaljourney.situation.domain.Situation;
import com.jsorant.personaljourney.situation.domain.SituationId;
import com.jsorant.personaljourney.situation.domain.SituationRepository;
import org.jmolecules.ddd.annotation.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@org.springframework.stereotype.Repository
public class InMemorySituationRepository implements SituationRepository {
  private final List<Situation> situations = new ArrayList<>();

  @Override
  public List<Situation> getAll() {
    return situations;
  }

  @Override
  public SituationId prochainId() {
    return new SituationId("SD" + (situations.size() + 1));
  }

  @Override
  public void save(Situation situation) {
    this.situations.add(situation);
  }
}
