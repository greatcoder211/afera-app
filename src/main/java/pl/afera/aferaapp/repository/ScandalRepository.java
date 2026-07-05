package pl.afera.aferaapp.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.afera.aferaapp.model.Scandal;
import pl.afera.aferaapp.repository.criteriaTraining.ScandalCustomRepository;

import java.util.Optional;

@Repository
public interface ScandalRepository extends CrudRepository<Scandal, Long>, ScandalCustomRepository, JpaSpecificationExecutor<Scandal> {
    @Query("select s from Scandal s join fetch s.associatedPoliticians where s.id = :id")
    Optional<Scandal> scandalWithPoliticians(Long id);
}
