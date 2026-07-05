package pl.afera.aferaapp.repository.criteriaTraining;

import lombok.Data;

@Data
public class SearchKeyParameters {
    private String scandalNameSnippet;
    private Integer startYear;
    private String politicianLastName;
}
