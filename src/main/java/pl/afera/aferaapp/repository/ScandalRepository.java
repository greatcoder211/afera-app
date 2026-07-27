package pl.afera.aferaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.afera.aferaapp.model.entity.Scandal;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "scandals", path = "scandals")
public interface ScandalRepository extends JpaRepository<Scandal, Long> {
    @Query("select s from Scandal s join fetch s.associatedPoliticians where s.id = :id")
    Optional<Scandal> scandalWithPoliticians(Long id);
}
