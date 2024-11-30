package com.jsorant.personaljourney.situation.domain;

import com.jsorant.personaljourney.shared.error.domain.Assert;

public record SituationId(String value) {
  public SituationId {
    Assert.notNull("value", value);
  }
}
