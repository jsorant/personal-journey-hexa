package com.jsorant.personaljourney.shared.date.domain;

import org.jmolecules.architecture.hexagonal.Port;

import java.time.Instant;

@Port
public interface DateProvider {
  Instant now();
}
