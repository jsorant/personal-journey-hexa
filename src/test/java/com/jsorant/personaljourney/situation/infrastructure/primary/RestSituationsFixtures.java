package com.jsorant.personaljourney.situation.infrastructure.primary;

import com.jsorant.personaljourney.UnitTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.jsorant.personaljourney.situation.domain.SituationFixtures.situations;
import static org.assertj.core.api.Assertions.assertThat;

@UnitTest
class RestSituationsDifficilesTest {

  @Test
  void shouldCreateRestSituationsDifficiles() {
    assertThat(RestSituationsDifficiles.from(situations())).isEqualTo(
      new RestSituationsDifficiles(
        List.of(
          new RestSituationDifficileApercu("SD1", "2024-10-12T14:45:00Z"),
          new RestSituationDifficileApercu("SD2", "2024-10-12T15:45:00Z")
        )
      )
    );
  }
}
