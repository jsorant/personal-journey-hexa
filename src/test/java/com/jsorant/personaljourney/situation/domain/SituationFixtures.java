package com.jsorant.personaljourney.situation.domain;

import java.time.Instant;
import java.util.List;

public final class SituationFixtures {
  private SituationFixtures() {
  }

  public static List<Situation> situations() {
    return List.of(
      situation(),
      autreSituation()
    );
  }

  public static Situation situation() {
    return new Situation(situationId(), dateCreation());
  }

  public static Situation autreSituation() {
    return new Situation(autreSituationId(), autreDateCreation());
  }

  public static SituationId situationId() {
    return new SituationId("SD1");
  }

  public static SituationId autreSituationId() {
    return new SituationId("SD2");
  }

  public static Instant dateCreation() {
    return Instant.parse("2024-10-12T14:45:00Z");
  }

  public static Instant dateDefinitionSignesPhysiologiques() {
    return dateCreation().plusSeconds(60);
  }

  public static List<SignePhysiologique> signesPhysiologiques() {
    return List.of(SignePhysiologique.NAUSEE, SignePhysiologique.DOULEURS);
  }

  public static Instant autreDateCreation() {
    int anHourInSeconds = 60 * 60;
    return dateCreation().plusSeconds(anHourInSeconds);
  }
}
