package com.jsorant.personaljourney.situation.domain;

import com.jsorant.personaljourney.UnitTest;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static com.jsorant.personaljourney.situation.domain.SituationFixtures.situation;
import static org.assertj.core.api.Assertions.assertThat;

@UnitTest
public class SituationTest {

  @Test
  void shouldCreateSituation() {
    Situation situation = situation();

    assertThat(situation.id()).isEqualTo(new SituationId("SD1"));
    assertThat(situation.dateCreation()).isEqualTo(Instant.parse("2024-10-12T14:45:00Z"));
  }
}
