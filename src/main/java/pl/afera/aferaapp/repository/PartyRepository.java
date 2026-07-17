package pl.afera.aferaapp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.afera.aferaapp.model.entity.Party;
public interface PartyRepository extends CrudRepository<Party, Long> {
    Party save(Party party);
    @Override
    Iterable<Party> findAll();
}
