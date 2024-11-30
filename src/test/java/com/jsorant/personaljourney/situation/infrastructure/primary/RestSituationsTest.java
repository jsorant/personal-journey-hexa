package com.jsorant.personaljourney.situation.infrastructure.primary;

import com.jsorant.personaljourney.UnitTest;
import org.junit.jupiter.api.Test;

import static com.jsorant.personaljourney.situation.domain.SituationFixtures.situations;
import static com.jsorant.personaljourney.situation.infrastructure.primary.RestSituationsFixtures.restSituations;
import static org.assertj.core.api.Assertions.assertThat;

@UnitTest
class RestSituationsTest {

  @Test
  void shouldCreateRestSituationsDifficiles() {
    assertThat(RestSituations.from(situations())).isEqualTo(restSituations());
  }
}
