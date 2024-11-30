package com.jsorant.personaljourney.situation.infrastructure.primary;

import java.util.List;

final class RestSituationsFixtures {
  private RestSituationsFixtures() {
  }

  public static RestSituations restSituations() {
    return new RestSituations(List.of(restSituation(), autreRestSituation()));
  }

  private static RestSituation autreRestSituation() {
    return new RestSituation("SD2", "2024-10-12T15:45:00Z");
  }

  private static RestSituation restSituation() {
    return new RestSituation("SD1", "2024-10-12T14:45:00Z");
  }
}
