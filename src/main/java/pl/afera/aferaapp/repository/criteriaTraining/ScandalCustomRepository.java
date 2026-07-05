package pl.afera.aferaapp.repository.criteriaTraining;

import java.util.List;

public interface ScandalCustomRepository {
    List<PartyScandalSummary> getPartyScandalCount();
}
