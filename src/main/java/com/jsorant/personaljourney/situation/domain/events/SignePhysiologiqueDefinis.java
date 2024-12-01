package com.jsorant.personaljourney.situation.domain.events;

import com.jsorant.personaljourney.situation.domain.SignePhysiologique;
import com.jsorant.personaljourney.situation.domain.SituationId;
import org.jmolecules.event.annotation.DomainEvent;

import java.time.Instant;
import java.util.List;

@DomainEvent
public record SignePhysiologiqueDefinis(SituationId situationId, Instant date, List<SignePhysiologique> signes) {
}
