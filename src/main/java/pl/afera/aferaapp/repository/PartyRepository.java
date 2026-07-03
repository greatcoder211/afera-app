package pl.afera.aferaapp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.afera.aferaapp.model.Party;
public interface PartyRepository extends CrudRepository<Party, Long> {
    Party save(Party party);
}
