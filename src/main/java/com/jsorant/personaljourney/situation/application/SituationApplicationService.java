package com.jsorant.personaljourney.situation.application;

import com.jsorant.personaljourney.shared.date.domain.DateProvider;
import com.jsorant.personaljourney.situation.domain.*;
import com.jsorant.personaljourney.situation.domain.events.SignePhysiologiqueDefinis;
import com.jsorant.personaljourney.situation.domain.events.SituationCreee;
import com.jsorant.personaljourney.situation.domain.service.SituationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SituationApplicationService {
  private final SituationService situations;
  private final EtapeSituationProjections etapesSituationsProjections;
  private final SituationDetaillesProjections situationsDetaillesProjections;

  public SituationApplicationService(DateProvider dateProvider, SituationRepository situationRepository, EtapeSituationProjections etapesSituationsProjections, SituationDetaillesProjections situationsDetaillesProjections) {
    this.etapesSituationsProjections = etapesSituationsProjections;
    this.situationsDetaillesProjections = situationsDetaillesProjections;
    this.situations = new SituationService(dateProvider, situationRepository);
  }

  public void creerSituation() {
    SituationCreee situationCreee = situations.creerSituation();
    // TODO publish/handle event
    handle(situationCreee);
  }

  private void handle(SituationCreee situationCreee) {
    situationsDetaillesProjections.ajouter(situationCreee.id(), situationCreee.dateCreation());
    etapesSituationsProjections.definir(situationCreee.id(), Etape.DEFINIR_SIGNES_PHYSIOLOGIQUES);
  }

  public List<Situation> recupererSituations() {
    return situations.recupererSituations();
  }

  public Optional<Etape> etapePour(SituationId situationId) {
    return etapesSituationsProjections.pour(situationId);
  }

  public Optional<Situation> recupererDetailSituation(SituationId situationId) {
    return situationsDetaillesProjections.pour(situationId);
  }

  public void definirSignesPhysiologiques(SituationId id, List<SignePhysiologique> signesPhysiologiques) {
    SignePhysiologiqueDefinis event = situations.definirSignesPhysiologiques(id, signesPhysiologiques);
    // TODO publish/handle event
    handle(event);
  }

  private void handle(SignePhysiologiqueDefinis event) {
    etapesSituationsProjections.definir(event.situationId(), Etape.DECRIRE_SITUATION);
  }
}
