package com.jsorant.personaljourney.situation.domain;

import java.time.Instant;

public final class SituationFixtures {
  private SituationFixtures() {
  }

  public static Situation situation() {
    return new Situation(situationId(), dateCreation());
  }

  public static SituationId situationId() {
    return new SituationId("SD1");
  }

  public static Instant dateCreation() {
    return Instant.parse("2024-10-12T14:45:00Z");
  }

  public static Instant autreDateCreation() {
    int anHourInSeconds = 60 * 60;
    return dateCreation().plusSeconds(anHourInSeconds);
  }
}
