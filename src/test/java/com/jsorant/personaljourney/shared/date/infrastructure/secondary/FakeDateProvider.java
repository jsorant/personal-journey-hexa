package com.jsorant.personaljourney.shared.date.infrastructure.secondary;

import com.jsorant.personaljourney.shared.date.domain.DateProvider;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@Primary
@Profile("test")
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
