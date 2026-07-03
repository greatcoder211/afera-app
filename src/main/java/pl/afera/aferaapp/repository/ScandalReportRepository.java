package pl.afera.aferaapp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.afera.aferaapp.model.ScandalReport;

public interface ScandalReportRepository extends CrudRepository<ScandalReport, Long> {
}
