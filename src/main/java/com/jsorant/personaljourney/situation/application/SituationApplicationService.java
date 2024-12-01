package com.jsorant.personaljourney.situation.application;

import com.jsorant.personaljourney.shared.date.domain.DateProvider;
import com.jsorant.personaljourney.situation.domain.Etape;
import com.jsorant.personaljourney.situation.domain.Situation;
import com.jsorant.personaljourney.situation.domain.SituationId;
import com.jsorant.personaljourney.situation.domain.SituationRepository;
import com.jsorant.personaljourney.situation.domain.service.SituationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SituationApplicationService {
  private final SituationService situations;

  public SituationApplicationService(DateProvider dateProvider, SituationRepository situationRepository) {
    this.situations = new SituationService(dateProvider, situationRepository);
  }

  public void creerSituation() {
    situations.creerSituation();
  }

  public List<Situation> recupererSituations() {
    return situations.recupererSituations();
  }

  public Etape etapePour(SituationId situationId) {
    return Etape.DEFINIR_SIGNES_PHYSIOLOGIQUES;
  }
}
