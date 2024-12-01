package com.jsorant.personaljourney.situation.domain.service;

import com.jsorant.personaljourney.shared.date.domain.DateProvider;
import com.jsorant.personaljourney.situation.domain.Situation;
import com.jsorant.personaljourney.situation.domain.SituationRepository;
import com.jsorant.personaljourney.situation.domain.events.SituationCreee;
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

  public SituationCreee creerSituation() {
    Situation situation = new Situation(situations.prochainId(), dateProvider.now());
    situations.save(situation);
    return new SituationCreee(situation.id(), situation.dateCreation());
  }

  public List<Situation> recupererSituations() {
    return situations.getAll();
  }
}
