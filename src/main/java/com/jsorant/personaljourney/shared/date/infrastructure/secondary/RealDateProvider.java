package com.jsorant.personaljourney.shared.date.infrastructure.secondary;

import com.jsorant.personaljourney.shared.date.domain.DateProvider;
import com.jsorant.personaljourney.shared.generation.domain.ExcludeFromGeneratedCodeCoverage;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class RealDateProvider implements DateProvider {

  @Override
  @ExcludeFromGeneratedCodeCoverage
  public Instant now() {
    return Instant.now();
  }
}
