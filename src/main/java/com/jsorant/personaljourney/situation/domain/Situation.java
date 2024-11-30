package com.jsorant.personaljourney.situation.domain;

import com.jsorant.personaljourney.shared.error.domain.Assert;
import org.jmolecules.ddd.annotation.AggregateRoot;

import java.time.Instant;

@AggregateRoot
public record Situation(SituationId id, Instant dateCreation) {
  public Situation {
    Assert.notNull("id", id);
  }
}
