package com.jsorant.personaljourney.situation.domain.service;

import com.jsorant.personaljourney.situation.domain.DateProvider;

import java.time.Instant;

public final class FakeDateProvider implements DateProvider {
  private Instant now;

  public FakeDateProvider() {
    this.now = Instant.now();
  }

  public void setNow(Instant newNow) {
    this.now = newNow;
  }

  @Override
  public Instant now() {
    return now;
  }
}
