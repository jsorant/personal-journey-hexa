package com.jsorant.personaljourney.situation.domain.service;

import com.jsorant.personaljourney.UnitTest;
import com.jsorant.personaljourney.shared.date.infrastructure.secondary.FakeDateProvider;
import com.jsorant.personaljourney.situation.domain.Situation;
import com.jsorant.personaljourney.situation.domain.SituationId;
import com.jsorant.personaljourney.situation.domain.SituationRepository;
import com.jsorant.personaljourney.situation.domain.events.SituationCreee;
import com.jsorant.personaljourney.situation.infrastructure.secondary.InMemorySituationRepository;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;

import static com.jsorant.personaljourney.situation.domain.SituationFixtures.autreDateCreation;
import static com.jsorant.personaljourney.situation.domain.SituationFixtures.dateCreation;
import static org.assertj.core.api.Assertions.assertThat;

@UnitTest
public class SituationServiceTest {

  private final FakeDateProvider dateProvider = new FakeDateProvider();
  private final SituationRepository situations = new InMemorySituationRepository();
  private final SituationService service = new SituationService(dateProvider, situations);

  @Test
  void shouldCreerDeuxSituations() {
    dateProvider.setNow(dateCreation());
    service.creerSituation();

    dateProvider.setNow(autreDateCreation());
    service.creerSituation();

    List<Situation> liste = situations.getAll();
    assertThat(liste).hasSize(2);

    assertSituation(liste.get(0), "SD1", dateCreation());
    assertSituation(liste.get(1), "SD2", autreDateCreation());
  }

  @Test
  void shouldMakeDomainEvent() {
    dateProvider.setNow(dateCreation());
    SituationCreee event = service.creerSituation();

    assertThat(event.id()).isEqualTo(new SituationId("SD1"));
    assertThat(event.dateCreation()).isEqualTo(dateCreation());
  }

  private static void assertSituation(Situation situation, String expectedId, Instant expectedDateCreation) {
    assertThat(situation.id()).isEqualTo(new SituationId(expectedId));
    assertThat(situation.dateCreation()).isEqualTo(expectedDateCreation);
  }
}
