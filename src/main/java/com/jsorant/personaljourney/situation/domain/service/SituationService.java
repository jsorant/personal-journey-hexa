package com.jsorant.personaljourney.situation.domain.service;

import com.jsorant.personaljourney.shared.date.domain.DateProvider;
import com.jsorant.personaljourney.situation.domain.Situation;
import com.jsorant.personaljourney.situation.domain.SituationId;
import com.jsorant.personaljourney.situation.domain.SituationRepository;
import org.jmolecules.ddd.annotation.Service;

@Service
public class SituationService {

  public void creerSituation(SituationRepository situations, DateProvider dateProvider) {
    SituationId id = situations.prochainId();
    situations.save(new Situation(id, dateProvider.now()));
  }
}
