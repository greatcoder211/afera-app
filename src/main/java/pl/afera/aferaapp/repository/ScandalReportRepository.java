package pl.afera.aferaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.afera.aferaapp.model.entity.ScandalReport;
@RepositoryRestResource(collectionResourceRel = "scandal-reports", path = "scandal-reports")
public interface ScandalReportRepository extends JpaRepository<ScandalReport, Long> {
}
