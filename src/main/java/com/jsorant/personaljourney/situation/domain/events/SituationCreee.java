package com.jsorant.personaljourney.situation.domain.events;

import com.jsorant.personaljourney.situation.domain.SituationId;
import org.jmolecules.event.annotation.DomainEvent;

import java.time.Instant;

@DomainEvent
public record SituationCreee(SituationId id, Instant dateCreation) {
}
