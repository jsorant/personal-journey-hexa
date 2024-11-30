package com.jsorant.personaljourney.situation.domain.service;

import com.jsorant.personaljourney.shared.date.domain.DateProvider;
import com.jsorant.personaljourney.situation.domain.Situation;
import com.jsorant.personaljourney.situation.domain.SituationId;
import com.jsorant.personaljourney.situation.domain.SituationRepository;
import org.jmolecules.ddd.annotation.Service;

import java.util.List;

@Service
public class SituationService {

  private final DateProvider dateProvider;
  private final SituationRepository situations;

  public SituationService(DateProvider dateProvider, SituationRepository situations) {
    this.dateProvider = dateProvider;
    this.situations = situations;
  }

  public void creerSituation() {
    SituationId id = situations.prochainId();
    situations.save(new Situation(id, dateProvider.now()));
  }

  public List<Situation> recupererSituations() {
    return situations.getAll();
  }
}
