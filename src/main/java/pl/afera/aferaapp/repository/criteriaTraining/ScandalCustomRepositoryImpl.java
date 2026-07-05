package pl.afera.aferaapp.repository.criteriaTraining;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import pl.afera.aferaapp.model.Party;
import pl.afera.aferaapp.model.Scandal;

import java.util.List;

@Repository
public class ScandalCustomRepositoryImpl implements ScandalCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PartyScandalSummary> getPartyScandalCount() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PartyScandalSummary> query = cb.createQuery(PartyScandalSummary.class);
        Root<Scandal> root = query.from(Scandal.class);
        Join<Scandal, Party> partyJoin = root.join("associatedPoliticalParties");
        query.multiselect(partyJoin.get("name"), cb.count(root));
        query.groupBy(partyJoin.get("name"));
        query.orderBy(cb.desc(cb.count(root)));
        return entityManager.createQuery(query).getResultList();
    }
}