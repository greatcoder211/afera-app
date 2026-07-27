package pl.afera.aferaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.afera.aferaapp.model.entity.Party;
@Repository
@RepositoryRestResource(collectionResourceRel = "parties", path = "parties")
public interface PartyRepository extends JpaRepository<Party, Long> {}
