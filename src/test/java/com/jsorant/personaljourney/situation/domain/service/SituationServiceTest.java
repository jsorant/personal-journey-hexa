package com.jsorant.personaljourney.situation.domain.service;

import com.jsorant.personaljourney.UnitTest;
import com.jsorant.personaljourney.situation.domain.Situation;
import com.jsorant.personaljourney.situation.domain.SituationId;
import com.jsorant.personaljourney.situation.domain.SituationRepository;
import com.jsorant.personaljourney.situation.infrastructure.secondary.InMemorySituationRepository;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;

import static com.jsorant.personaljourney.situation.domain.SituationFixtures.autreDateCreation;
import static com.jsorant.personaljourney.situation.domain.SituationFixtures.dateCreation;
import static org.assertj.core.api.Assertions.assertThat;

@UnitTest
public class SituationServiceTest {

  SituationService service = new SituationService();
  FakeDateProvider dateProvider = new FakeDateProvider();
  SituationRepository situations = new InMemorySituationRepository();

  @Test
  void shouldCreerDeuxSituations() {
    dateProvider.setNow(dateCreation());
    service.creerSituation(situations, dateProvider);

    dateProvider.setNow(autreDateCreation());
    service.creerSituation(situations, dateProvider);

    List<Situation> liste = situations.getAll();
    assertThat(liste).hasSize(2);

    assertSituation(liste.get(0), "SD1", dateCreation());
    assertSituation(liste.get(1), "SD2", autreDateCreation());
  }

  private static void assertSituation(Situation situation, String expectedId, Instant expectedDateCreation) {
    assertThat(situation.id()).isEqualTo(new SituationId(expectedId));
    assertThat(situation.dateCreation()).isEqualTo(expectedDateCreation);
  }
}
