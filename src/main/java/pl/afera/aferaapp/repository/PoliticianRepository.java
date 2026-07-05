package pl.afera.aferaapp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.afera.aferaapp.model.Politician;

public interface PoliticianRepository extends CrudRepository<Politician, Long> {

}
