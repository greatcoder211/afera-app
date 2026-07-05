package pl.afera.aferaapp.repository.criteriaTraining;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PartyScandalSummary {
    private String partyName;
    private Long scandalCount;
}