package com.jsorant.personaljourney.situation.infrastructure.primary;

import com.jsorant.personaljourney.shared.enumeration.domain.Enums;
import com.jsorant.personaljourney.situation.domain.SignePhysiologique;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Arrays;
import java.util.List;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(name = "SignesPhysiologiques", description = "Les signes physiologiques liés à une situation difficile")
public record RestSignesPhysiologiques(
  @Schema(requiredMode = REQUIRED) RestSignePhysiologique[] signesPhysiologiques) {
  public List<SignePhysiologique> toDomain() {
    return Arrays.stream(signesPhysiologiques).map(signe -> Enums.map(signe, SignePhysiologique.class)).toList();
  }
}
