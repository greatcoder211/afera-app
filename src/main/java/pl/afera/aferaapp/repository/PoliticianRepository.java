package pl.afera.aferaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.afera.aferaapp.model.entity.Politician;
@RepositoryRestResource(collectionResourceRel = "politicians", path = "politicians")
public interface PoliticianRepository extends JpaRepository<Politician, Long> {

}
